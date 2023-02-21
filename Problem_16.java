package Xplore_Problems;
/*
Create class Sim with below attributes: simId - int customerName - String balance - double ratePerSecond - double circle - String

Create class Solution and implement static method "transferCircle" in the Solution class. This method will take array of Sim objects, circle1 String and circle2 string as parameters. And will return another Sim array where the circle1 matches with the circle parameter of the original Sim array and the circle parameter of the new array is set to circle2 and is also sorted by means of ratePerSecond attribute in desending order.

Write necessary getters and setters.

Before calling "transferCircle" method in the main method, read values for five Sim objects referring the attributes in above sequence along with a String circlee1 and circle2. Then call the "transferCircle" method and write logic in main method to print all the attributes of the result obtained.
Input

1
raju
130
1.32
mum
2
sachin
120
2.26
ahd
3
ram
200
2.54
kol
4
shubham
640
3.21
ahd
5
kalpesh
150
1.8
ahd
ahd
kol

Output

4 shubham kol 3.21
2 sachin kol 2.26
5 kalpesh kol 1.8

 */
import java.util.*;
public class Problem_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sim[] arr = new sim[5];
        for (int i = 0; i<5;i++)
            arr[i] = new sim(sc.nextInt(), sc.next(), sc.nextDouble(),sc.nextDouble(), sc.next());
        String circle1 = sc.next();
        String circle2 = sc.next();
        sim[] ans = transferCircle(arr,circle1,circle2);

        sc.close();

        for (int i=0;i< ans.length;i++)
        {
            System.out.println(ans[i].getSimId() + " " + ans[i].getCustomer_Name() + " " + ans[i].getCircle() + " "+ ans[i].getRatePerSecond());
        }

    }

    private static sim[] transferCircle(sim[] arr, String circle1, String circle2) {
        sim[] res = new sim[0];
        for (int i = 0; i< arr.length;i++)
        {
            if (arr[i].getCircle().equalsIgnoreCase(circle1))
            {
                res = Arrays.copyOf(res,res.length+1);
                res[res.length-1] = arr[i];
                res[res.length-1].setCircle(circle2);
            }
        }
        for (int i = 0 ; i < res.length - 1 ; i++) {
            for (int j = 0; j < res.length - i - 1; j++) {
                if (res[j].getRatePerSecond() < res[j + 1].getRatePerSecond()) {
                    //swap
                    sim temp = res[j];
                    res[j] = res[j + 1];
                    res[j + 1] = temp;
                }
            }

        }return res;
    }
}
class sim{
    private int simId;
    private String customer_Name,circle;
    private double balance,ratePerSecond;

    public int getSimId() {
        return simId;
    }

    public void setSimId(int simId) {
        this.simId = simId;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public void setRatePerSecond(double ratePerSecond) {
        this.ratePerSecond = ratePerSecond;
    }

    public sim(int simId, String customer_Name, double balance, double ratePerSecond, String circle)
    {
        this.simId = simId;
        this.customer_Name = customer_Name;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle=circle;
    }
}
