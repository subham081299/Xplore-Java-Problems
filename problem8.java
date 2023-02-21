package Xplore_Problems;
/*
## Problem Statement

Create class Inventory with below attributes:
inventoryId - String
maximumQuantity - int
currentQuantity - int
threshold - int

Create class Solution and implement static method "replenish" in the Solution class.
This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is lesser than or equal to the original array of Inventory object's threshold attribute.

Write necessary getters and setters.

Before calling "replenish" method in the main method, read values for four Inventory objects referring the attributes in above sequence along with a int limit.
Then call the "replenish" method and write logic in main method to print "Critical Filling",if the threshold attribute is greater than 75. Else if the threshold attribute is between 50 and 75 then print "Moderate Filling". Else print "Non-Critical Filling"

## Input

    1
    100
    50
    50
    2
    200
    60
    40
    3
    150
    35
    45
    4
    80
    45
    40
    45

## Output

    2 Non-Critical Filling
    3 Non-Critical Filling
    4 Non-Critical Filling
 */
import java.util.*;
public class problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory[] input = new Inventory[4];
        for (int i = 0 ; i<4; i++)
        {
            input[i] = new Inventory(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        int limit = sc.nextInt();
        sc.close();
        Inventory[] result = replenish(input, limit);
        for (int i = 0; i < result.length; i++){
            if (result[i].getThreshold() >= 75)
                System.out.println(result[i].getInventoryId() + " Critical Filling");
            else if (result[i].getThreshold() >= 50 && result[i].getThreshold() <= 74)
                System.out.println(result[i].getInventoryId() + " Moderate Filling");
            else
                System.out.println(result[i].getInventoryId() + " Non-Critical Filling");
    }
}

    private static Inventory[] replenish(Inventory[] inventories, int limit) {
        Inventory[] refined = new Inventory[0];
        for (int i = 0; i < inventories.length; i++){
            if (inventories[i].getThreshold() <= limit){
                refined=Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1] = inventories[i];
            }
        }
        return refined;
    }
    }

    class Inventory{
    private String inventoryId;
    private int maximumQuantity ,currentQuantity , threshold ;
    public Inventory(String inventoryId,int maximumQuantity , int currentQuantity , int threshold)
    {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}