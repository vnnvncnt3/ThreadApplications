package BankAccountThreads;

public class BankAccount {
    public Double balance;
    public Object lock = new Object();

    public BankAccount(){
        this.balance = (Double) 500.00;
    }

    public void deposit(double amount){
        synchronized (lock){
            balance += amount;
            System.out.println("Deposite Balance: " + balance);
            lock.notify();
        }
    }

        public void withdraw(double amount){
            synchronized (lock) {
                while(balance < amount){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (amount >= balance || amount < 0) {
                        System.out.println("Insufficient Balance");
                        return;
                    }

                }

                balance -= amount;
                System.out.println("Withdraw Balance: " + balance);
                lock.notify();
            }
        }
    }
