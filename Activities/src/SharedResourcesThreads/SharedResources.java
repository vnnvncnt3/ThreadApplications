package SharedResourcesThreads;

import java.util.*;

public class SharedResources{
    public int value;
    boolean available;

    public SharedResources(int value){
        available = true;
        this.value = value;
    }

    synchronized public void produce() throws InterruptedException{
        for(int i = 0; i < 5; i++){
            this.wait();
            Random random = new Random();
            value = random.nextInt(1,51);
            System.out.println("Produced: " + value);
            available = true;
            this.notify();
        }
    }

    synchronized public void consume() throws InterruptedException{
        for(int i = 0; i < 5; i++){
            if(!available){
                this.wait();
            }

            System.out.println("Consumers: " + value);
            available = false;
            this.notify();
        }
    }
}


