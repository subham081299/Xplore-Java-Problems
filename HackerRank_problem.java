package Xplore_Problems;
import java.io.IOException;
import java.util.*;
import java.util.Collections;
public class HackerRank_problem {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Account a = new Account(sc.nextInt(), sc.nextDouble(), sc.nextDouble());
        int yrs = sc.nextInt();
        sc.close();
        System.out.println(calculate(a,yrs));
    }

    private static double calculate(Account a, int yrs) {
        double ans = (double) (a.getRate()/100)*yrs + a.getRate();
        if (ans<10)return ans*100;
        else if (ans<100) {return ans*10;}
        else return ans;
    }
}
class Account{
    private int id;
    private double balance,rate;
    public Account(int id, double balance,double rate)
    {
        this.id = id;
        this.balance = balance;
        this.rate = rate;
    }
    public  void setId(int id)
    {
        this.id = id;
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public void setRate(double rate)
    {
        this.rate = rate;
    }
    public  int getId(){return  id;}
    public double getBalance(){return  balance;}
    public double getRate(){return rate;}
}