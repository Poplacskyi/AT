package lab_5;


public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Серіалізація / десеріалізація
        JsonXmlHandler.handle();

        // 2. Stream API
        RandomPersonGenerator.streamOps();

        // 3. Maven аргумент (опціонально)
        if (args.length > 0) {
            int n = Integer.parseInt(args[0]);
            System.out.println("Generated " + n + " people:");
            RandomPersonGenerator.generate(n).forEach(System.out::println);
        }
    }
}
