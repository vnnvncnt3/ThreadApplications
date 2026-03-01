package MessageThreads;

public class Waiter implements Runnable {
    Message message;

    public Waiter(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        synchronized (message){
            try{
                message.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("Thread was interrupted");
            }

            System.out.println("Message: " + message.getMessage());
        }
    }
}
