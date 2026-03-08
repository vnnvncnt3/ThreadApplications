package SharedResourcesThreads;

public class Producer implements Runnable {
    SharedResources shared;

    public Producer(SharedResources shared){
        this.shared = shared;
    }

    @Override
    synchronized public void run(){
        try {
            shared.produce();
        } catch (InterruptedException e){

        }
    }
}
