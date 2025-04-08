import java.lang.reflect.*;

public class ReflectionDemo {
    public static void runReflection() throws Exception {
        MyCustomClass obj = new MyCustomClass();
        Class<?> clazz = obj.getClass();

        System.out.println("Declared methods and return types:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " returns " + method.getReturnType().getSimpleName());
        }

        // метод greet
        Method greetMethod = clazz.getDeclaredMethod("greet", String.class);
        Object result = greetMethod.invoke(obj, "Любомир");
        System.out.println("Invoked greet(): " + result);
    }
}
