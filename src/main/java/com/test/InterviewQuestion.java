package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class InterviewQuestion {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterviewQuestion.class);

    /**
     * 牛顿迭代法实现求平方根
     *
     * @param number 需要求解的数值
     * @return 数值的平方根
     */
    public static int sqrt(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("求解数值必须大于等于0.");
        } else if (number == 0) {
            return 0;
        }
        double x0 = number, x1, differ;

        while (true) {
            x1 = (x0 * x0 + number) / (2 * x0);
            differ = x1 * x1 - number;

            if (differ <= 0.1 && differ >= -0.1) {
                return (int) x1;
            }
            x0 = x1;
        }
    }

    /**
     * copy file And watch file create event to dynamically copy file
     * @param fromDirectory copy from dir
     * @param toDirectory copy to dir
     */
    public static void copyFileAndWatch(String fromDirectory, String toDirectory) {
        try {
            Path fromPath = Paths.get(fromDirectory);
            Path toPath = Paths.get(toDirectory);
            if (!Files.exists(toPath)) {
                Files.createDirectory(toPath);
            }
            final Map<WatchKey, Path> keys = new HashMap<>();
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Consumer<Path> register = p -> {
                if (!Files.isDirectory(p)) {
                    throw new RuntimeException("folder " + p + " does not exist or is not a directory");
                }
                try {
                    Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                            WatchKey watchKey = dir.register(watchService, ENTRY_CREATE);
                            keys.put(watchKey, dir);
                            return CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                            copyFileToDirectory(file, toDirectory);
                            return CONTINUE;
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException("Error registering path " + p);
                }
            };
            register.accept(fromPath);
            Executors.newSingleThreadExecutor().submit(() -> {
                while (true) {
                    final WatchKey key;
                    try {
                        key = watchService.take();
                    } catch (InterruptedException ex) {
                        return;
                    }
                    final Path dir = keys.get(key);
                    if (dir == null) {
                        System.err.println("WatchKey " + key + " not recognized!");
                        continue;
                    }
                    key.pollEvents().forEach(watchEvent -> {
                        Path path = (Path) watchEvent.context();
                        final Path absPath = dir.resolve(path);
                        if (Files.isDirectory(absPath)) {
                            register.accept(absPath);
                        } else {
                            copyFileToDirectory(absPath, toDirectory);
                        }
                    });
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
            });
        } catch (IOException e) {
            LOGGER.error("IO error: ", e);
        }
    }

    /**
     * copy file to directory
     * @param img image file
     * @param toDirectory copy to file
     */
    private static void copyFileToDirectory(Path img, String toDirectory) {
        try {
            int nameCount = img.getNameCount();
            if (nameCount < 4) {
                return;
            }
            Path year = img.getName(nameCount - 4);
            Path month = img.getName(nameCount - 3);
            Path day = img.getName(nameCount - 2);
            Path name = img.getName(nameCount - 1);
            String toFileName = String.format("%s_%s_%s_%s", year, month, day, name);
            Files.copy(img, Paths.get(toDirectory, toFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            LOGGER.error("Image file copy error.", e);
        }
    }

}
