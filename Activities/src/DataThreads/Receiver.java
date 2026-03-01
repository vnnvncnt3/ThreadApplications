package DataThreads;

public class Receiver implements Runnable {
    Data data;

    public Receiver(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        data.recieve();
    }
}
