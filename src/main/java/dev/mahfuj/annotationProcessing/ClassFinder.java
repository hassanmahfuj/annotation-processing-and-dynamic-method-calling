package dev.mahfuj.annotationProcessing;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {

    public static List<Class<?>> findClasses(String packageName, Class<? extends Annotation> annotation)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        URL resource = classLoader.getResource(path);
        File directory = new File(resource.getFile());

        List<Class<?>> classes = new ArrayList<>();
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".class")) {
                        String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                        Class<?> clazz = Class.forName(className);
                        if (annotation == null || clazz.isAnnotationPresent(annotation)) {
                            classes.add(Class.forName(className));
                        }
                    }
                }
            }
        }
        return classes;
    }

}
