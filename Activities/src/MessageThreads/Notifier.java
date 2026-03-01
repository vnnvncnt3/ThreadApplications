package MessageThreads;

public class Notifier implements Runnable {
    Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            synchronized (message) {
                message.setMessage("Everything is good");
                message.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread was interrupted");
        }
    }
}