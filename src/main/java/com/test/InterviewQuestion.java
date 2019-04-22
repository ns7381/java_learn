package com.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class InterviewQuestion {

    /**
     * 牛顿迭代法实现求平方根
     *
     * @param number 需要求解的数值
     * @return 数值的平方根
     */
    public static int sqrt(int number) throws IllegalArgumentException{
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

    public static void copyFileAndWatch(String fromDirectory, String toDirectory) {
        try {
            Path fromPath = Paths.get(fromDirectory);
            Path toPath = Paths.get(toDirectory);
            if (!Files.exists(toPath)) {
                Files.createDirectory(toPath);
            }
            Files.walk(fromPath, 4).filter(Files::isRegularFile)
                    .forEach(img -> {
                        try {
                            int nameCount = img.getNameCount();
                            Path year = img.getName(nameCount - 4);
                            Path month = img.getName(nameCount - 3);
                            Path day = img.getName(nameCount - 2);
                            Path name = img.getName(nameCount - 1);
                            String toFileName = String.format("%s_%s_%s_%s", year, month, day, name);
                            Files.copy(img, Paths.get(toPath + File.separator + toFileName), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            WatchService watchService = FileSystems.getDefault().newWatchService();
            fromPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            while (true) {
                // 阻塞方式，消费文件更改事件
                List<WatchEvent<?>> watchEvents = watchService.take().pollEvents();
                for (WatchEvent<?> watchEvent : watchEvents) {
                    System.out.printf("[%s]文件发生了[%s]事件。%n", watchEvent.context(), watchEvent.kind());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFileAndWatch("E:\\github\\java_learn\\src\\main\\java\\com\\test\\A", "E:\\github\\java_learn\\src\\main\\java\\com\\test\\B");
    }
}
