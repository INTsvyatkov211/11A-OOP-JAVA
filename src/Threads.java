public class Threads {
    public static void main(String[] args) {

        java.lang.Thread numberThread = new java.lang.Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Number: " + i);
                try {
                    java.lang.Thread.sleep(500); 
                } catch (InterruptedException e) {
                    System.out.println("Number thread was interrupted.");
                }
            }
        });


        java.lang.Thread messageThread = new java.lang.Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello, Thread!");
                try {
                    java.lang.Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Message thread was interrupted.");
                }
            }
        });


        numberThread.start();
        messageThread.start();


        try {
            numberThread.join();
            messageThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Program finished!");
    }
}