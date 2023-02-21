package Xplore_Problems;
/*
create a class Footwear which consists of the below attributes.
  footwearId=int
  footwearName=String
  footwearType=String
  price =int

the above attributes should be private.
write getter and setter and parametrised constructor as required.

create the class footwearProgrammm with the main method.
implement the 2 static methods.getCountByType and
getSecondHighestPriceByBrand in the Solution class.


getCountByType method:
   this method will take two input parameters.
array of the Footwear objects and string parameter footwear type.
this method will return the count of the footwears from array of the
footwear objects for the given type of footwear.
if no footwear with the given footwear type is found in the
array of footwear abjects,then the method should return 0.



getSecondHighestPriceByBrand method:
  this method will take 2 input parameters-array of footwear objects and string parameter inputFootwearName.the method
will return the second highest footwear objects based on the price from the array of the Footwear objects
whose brand name matches with the input string parameter.
if no footwear with the given brand is present in the array of the footwear objects,the the method
should return null.

NOTE: no two footwear objects would have the same footwearId.All the searches should be case insensitive.
the above mentioned static methods should be called from the main method.

for getCountByType method- the main method should print the count of the footwears ,if the returned value
is greater than zero. or it should print "Footwear not available";

for getSecondHighestPriceByBrand method-The main method should print price from the returned footwear objects
if the returned footwear object is not null.else it should print "Brand not available".
 */
import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Footwear[] footwears = new Footwear[5];
      for(int i = 0 ; i<5 ; i++)
      {
          int a = sc.nextInt();sc.nextLine();
          String b = sc.nextLine();
          String c = sc.nextLine();
          int d = sc.nextInt();
          sc.nextLine();

          footwears[i] = new Footwear(a,b,c,d);
      }
      String input_type = sc.nextLine();
      String input_name = sc.nextLine();

      int count = getCountByType(footwears,input_type);

      if (count>0) System.out.println("Count is: " + count);
      else System.out.println("No Footwear available");

      Footwear secondHighest = getSecondHighestByBrand(footwears,input_name);
      if (secondHighest == null)
      {
          System.out.println("Brand Not available");
      }else {
          System.out.println(secondHighest.footwearId);
          System.out.println(secondHighest.footwearName);
          System.out.println(secondHighest.footwearType);
          System.out.println(secondHighest.price);
      }
    }

    private static Footwear getSecondHighestByBrand(Footwear[] footwears, String input_name) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0 ; i<footwears.length ; i++)
        {
            if (footwears[i].getFootwearName().equalsIgnoreCase(input_name))
            {
                list.add(footwears[i].price);
            }
        }
        if(list.size()==0)return null;

        Collections.sort(list);
        int x = list.get(list.size()-2);
        for (int i = 0 ; i < footwears.length ; i++)
        {
            if (footwears[i].price == x)return footwears[i];
        }
        return null;
    }

    private static int getCountByType(Footwear[] footwears, String input_type) {
        int c = 0;
        for (int i = 0 ; i <footwears.length ; i++)
        {
            if (footwears[i].footwearType.equalsIgnoreCase(input_type))
            {
                c++;
            }
        }
        return c;
    }
}
class Footwear{
    int footwearId;
    String footwearName;
    String footwearType;
    int price;
    //parameterized constructor
    public Footwear(int footwearId,String footwearName , String footwearType , int price)
    {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }
    //getter and setter

    public String getFootwearName() {
        return footwearName;
    }

    public void setFootwearName(String footwearName) {
        this.footwearName = footwearName;
    }

    public String getFootwearType() {
        return footwearType;
    }

    public void setFootwearType(String footwearType) {
        this.footwearType = footwearType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFootwearId() {
        return footwearId;
    }

    public void setFootwearId(int footwearId) {
        this.footwearId = footwearId;
    }
}
