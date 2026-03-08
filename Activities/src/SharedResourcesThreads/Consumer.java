package SharedResourcesThreads;

public class Consumer implements Runnable {
    SharedResources shared;

    public Consumer(SharedResources shared){
        this.shared = shared;
    }

    @Override
    synchronized public void run(){
        try {
            shared.consume();
        } catch (InterruptedException e){

        }
    }
}
