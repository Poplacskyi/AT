public class Main {
    public static void main(String[] args) throws Exception {
        // Запуск потоку
        HelloWorldThread thread = new HelloWorldThread();
        thread.start();

        // Виклик рефлексії
        ReflectionDemo.runReflection();

        // Використання узагальненого класу
        GenericList<String> list = new GenericList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Generic List Elements:");
        list.printElements();

        // Зупинка після 5 секунд
        Thread.sleep(5000);
        thread.interrupt();
    }
}