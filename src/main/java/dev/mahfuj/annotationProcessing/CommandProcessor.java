package dev.mahfuj.annotationProcessing;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CommandProcessor {

    private final List<Method> handlerMethods = new ArrayList<>();

    public CommandProcessor() {
        registerHandlers("dev.mahfuj.annotationProcessing");
    }

    public void registerHandlers(String packageName) {
        try {
            List<Class<?>> handlerClasses = ClassFinder.findClasses(packageName, Aggregate.class);

            for (Class<?> handlerClass : handlerClasses) {
                Method[] methods = handlerClass.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(CommandHandler.class)) {
                        handlerMethods.add(method);
                    }
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public <T> void process(T command) {
        if (command.getClass().isAnnotationPresent(CommandAttribute.class)) {
            try {
                for (Method method : handlerMethods) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(command.getClass())) {
                        try {
                            Object handlerInstance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                            method.invoke(handlerInstance, command);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
