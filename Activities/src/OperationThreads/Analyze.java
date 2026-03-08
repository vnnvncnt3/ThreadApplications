package OperationThreads;

public class Analyze implements Runnable {
    final Operations operations;
    int ans;

    public Analyze(Operations operations){
        this.operations = operations;
        this.ans = 0;
    }

    @Override
    public void run(){
        try{
            synchronized (operations){
                ans = operations.sum / operations.list.size();
            }
        } catch(ArithmeticException e){

        }

    }

    public int getAns(){
        return ans;
    }
}
