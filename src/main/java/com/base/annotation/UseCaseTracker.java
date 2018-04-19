package com.base.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nathan on 17/1/17.
 */
public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCases, Class<?> cl) {
        for (Method method : cl.getDeclaredMethods()) {
            UseCase annotation = method.getAnnotation(UseCase.class);
            if (annotation != null) {
                System.out.println("use case " + annotation.id() + annotation.description());
                useCases.remove(new Integer(annotation.id()));
            }
        }
        for (Integer useCase : useCases) {
            System.out.println("missing use case-"+useCase);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCase(useCases, PasswordUtils.class);
    }
}
