package BankAccountThreads;

public class BankAccount {
    public Double balance;
    public final Object lock = new Object();

    public BankAccount(){
        this.balance = (Double) 500.00;
    }

    public void deposit(double amount){
        synchronized (lock){
            balance += amount;
            System.out.println("Deposit Balance: " + balance);
            lock.notify();
        }
    }

        public void withdraw(double amount) throws InterruptedException{
            synchronized (lock) {
                if(amount < 0){
                    System.out.println("Invalid amount");
                    return;
                }

                while(balance < amount){
                    lock.wait();
                }

                balance -= amount;
                System.out.println("Withdraw Balance: " + balance);
            }
        }
    }
