public class HelloWorldThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Hello, world!");
            try {
                Thread.sleep(1000); // 1 секунда
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
                break;
            }
        }
    }
}