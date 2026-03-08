package BankAccountThreads;

public class WithdrawThread implements Runnable {
    BankAccount account;
    public WithdrawThread(BankAccount account){
        this.account = account;
    }

    @Override
    public void run(){
        for(int i = 100; i <= 500; i+= 100) {
            try {
                account.withdraw(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("The withdrawal was interrupted!");
            }
        }
    }
}
