package Xplore_Problems;

import java.util.*;

public class Problem20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        hotel[] arr = new hotel[4];
        for (int i = 0; i <4 ; i++) {
            int id =  sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String date = sc.nextLine();
            int no = sc.nextInt();
            sc.nextLine();
            String wifi = sc.nextLine();
            double total = sc.nextDouble();

            arr[i] = new hotel(id,name,date,no,wifi,total);
        }
        sc.nextLine();
        String m = sc.nextLine();
        String n;
        if (m.contains("Yes"))
        {
            m = m.substring(0,m.indexOf("Yes"));
            n = m.substring(m.indexOf("Yes"));
        }
         n = sc.nextLine();
        sc.close();
        int ans1 = count(arr,m);
        if (ans1>0) System.out.println(ans1);
        else System.out.println("No rooms booked in the given month");
        int ans2 = search(arr,n);
        if (ans2>0) System.out.println(ans2);
        else System.out.println("No such option available");

    }

    private static int count(hotel[] arr, String m) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDate().substring(3,6).equalsIgnoreCase(m))return arr[i].getNo();
        }return 0;
    }

    private static int search(hotel[] arr, String n) {
        double max1 = 0 ,max2 = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].getWifi().equalsIgnoreCase(n))
            {
                max1 = Math.max(max1,arr[i].getTotal());
            }
        }
        int id = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i].getWifi().equalsIgnoreCase(n))
            {
                if (max2<arr[i].getTotal() && max2 != max1)
                {
                    max2 = arr[i].getTotal();
                    id = arr[i].getId();
                }
            }
        }return  id;
    }
}
class hotel{
    private int id,no;
    private String name, date,wifi;
    private double total;
    public hotel(int id,String name,String date,int no,String wifi,double total)
    {
        this.id = id;
        this.name = name;
        this.date = date;
        this.no = no;
        this.wifi = wifi;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}