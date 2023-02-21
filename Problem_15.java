package Xplore_Problems;
/*
Problem Statement

Create class Sim with below attributes: id - int company - String balance - int ratePerSecond - double circle - String

Create class Solution and implement static method "matchAndSort" in the Solution class. This method will take array of Sim objects, search_circle String and search_rate double as parameters. And will return another Sim array where the search_circle matches with the circle parameter of the original Sim array and the search_rate double is greater than the original array of Sim object's ratePerSecond attribute which is also sorted by means of balance attribute in descending order.

Write necessary getters and setters.

Before calling "matchAndSort" method in the main method, read values for four Sim objects referring the attributes in above sequence along with a String search_circle and a double search_rate. Then call the "matchAndSort" method and write logic in main method to print the id's of the result obtained.
Input

1
jio
430
1.32
mumbai
2
idea
320
2.26
mumbai
3
airtel
500
2.54
mumbai
4
vodafone
640
3.21
mumbai
mumbai
3.4

Output

4
3
1
2

 */
import java.util.* ;
public class Problem_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim input[] = new Sim[4];
        for (int i = 0 ; i < 4;i++)
            input[i] = new Sim(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.next());

        String search_circle = sc.next();
        double search_rate = sc.nextDouble();
        sc.close();

        Sim[] result= matchAndSort(input,search_circle,search_rate);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i].getId());
        }
    }
    public  static Sim[] matchAndSort(Sim[] sim,String search_circle,double search_rate)
    {
        Sim[] refined = new Sim[0];
        for(int i=0;i<sim.length;i++){
            if((sim[i].getCircle()).equals(search_circle)&&(sim[i].getRatePerSecond()<search_rate)){
                refined=Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1]=sim[i];
            }
        }
        Arrays.sort(refined,new SortByBalance());
        return refined;
    }
}
class Sim{
    private int id,balance;
    private String company,circle;
    private double ratePerSecond;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public Sim(int id, String company, int balance, double ratePerSecond, String circle)
    {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }
}
class SortByBalance implements  Comparator<Sim>
{
    public int compare(Sim a,Sim b)
    {
        return b.getBalance()-a.getBalance();
    }
}