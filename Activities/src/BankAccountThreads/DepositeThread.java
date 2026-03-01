package BankAccountThreads;

class DepositeThread implements Runnable {
    BankAccount account;
    public DepositeThread(BankAccount account){
        this.account = account;
    }

    @Override
    public void run(){
        for(int i = 100; i <= 500; i+= 100) {
            account.deposit(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
