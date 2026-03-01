package DataThreads;

public class Sender implements Runnable {
    Data data;

    public Sender(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        data.send();
    }
}
