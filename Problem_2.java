package Xplore_Problems;
/*
   Problem Statement
Create class Associate with below attributes: id - int name - String technology - String experienceInYears - int

Create class Solution and implement static method "associatesForGivenTechnology" in the Solution class.
This method will take array of Associate objects and a searchTechnology String as parameters.
And will return another array of Associate objects where the searchTechnology String matches with the original array of
 Associate object's technology attribute (case insensitive search) and experienceInYears attribute should be multiples of 5.

Write necessary getters and setters.

Before calling "associatesForGivenTechnology" method in the main method, read values for five associate objects referring
 the attributes in above sequence along with a String searchTechnology. Then call the "associatesForGivenTechnology"
 method and write the logic to print the id's in the main method.
 */
import java.util.*;
public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Associate[] input = new Associate[5];
        for (int i = 0 ; i<5 ; i++)
        {
            input[i] = new Associate(sc.nextInt(),sc.next(), sc.next(), sc.nextInt());
        }
        String searchTechnology = sc.next();
        sc.close();
        Associate[] result= associatesForGivenTechnology(searchTechnology,input);
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i].getId());
        }

    }

    private static Associate[] associatesForGivenTechnology(String searchTechnology, Associate[] associates) {
        Associate[] refined = new Associate[0];
        for(int i=0;i<associates.length;i++) {
            if(associates[i].getTechnology().equalsIgnoreCase(searchTechnology) && associates[i].getExperiencedInYears()%5==0){
                refined=Arrays.copyOf(refined,refined.length+1);
                refined[refined.length-1] = associates[i];
            }
        }
        return refined;
    }
}
class Associate{
    private int id , experiencedInYears;
    private String name,technology;
    public Associate(int id,String name , String technology , int experiencedInYears)
    {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.experiencedInYears = experiencedInYears;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperiencedInYears() {
        return experiencedInYears;
    }

    public void setExperiencedInYears(int experiencedInYears) {
        this.experiencedInYears = experiencedInYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}