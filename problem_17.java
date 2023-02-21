package Xplore_Problems;
/*
Create a class Player with below attributes:
playerId - int
skill - String
level - String
points - int



Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.



Create class Solution with the main method.

Implement two static methods - findPointsForGivenSkill and getPlayerBasedOnLevel in Solution class.



findPointsForGivenSkill method:
This method will take two input parameters - array of Player objects and string parameter skill.
The method will return the sum of the points attribute from player objects for the skill passed as parameter.
If no player with the given skill is present in the array of player objects, then the method should return 0.



getPlayerBasedOnLevel method:
This method will take two String parameters level and skill, along with the array of Player objects.
The method will return the player object, if the input String parameters matches with the level and skill attribute of the player object and its point attribute is greater than or equal to 20. If any of the conditions are not met, then the method should return null.



Note : No two player object would have the same value for skill and level attribute.
       All player object would have the points greater than 0.
       All the searches should be case insensitive.


These above mentioned static methods should be called from the main method.

For findPointsForGivenSkill method - The main method should print the points as it is if the returned price is greater than 0, or it
should print "The given Skill is not available".

For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object. If the returned value is null
then it should print "No player is available with specified level, skill and eligibility points".



Before calling these static methods in main, use Scanner object to read the values of four Player objects referring attributes in the above mentioned attribute sequence.
Next, read the value for skill and level.
Please consider the skill value read above as skill parameter for both the static methods.


Consider below sample input and output:
Input:

101
cricket
Basic
20
102
cricket
Intermediate
25
111
football
Intermediate
50
113
baseball
Advanced
100
cricket
Intermediate



Output:
45
102

​

Solutions:


 */
import  java.util.*;
public class problem_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        player1[] arr = new player1[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();sc.nextLine();
            String skill = sc.nextLine();
            String level = sc.nextLine();
            int points = sc.nextInt();sc.nextLine();
            arr[i] = new player1(id,skill,level,points);
        }
        String game = sc.nextLine();
        String lvl = sc.nextLine();
        int op1 = findPointsForGivenSkill(arr,game);
        int op2 = getPlayerBasedOnLevel(arr,lvl);
        if (op1>0) System.out.println(op1);
        else System.out.println("The given Skill is not available");
        if (op2>0) System.out.println(op2);
        else System.out.println("No player is available with specified level, skill and eligibility points");
    }

    private static int getPlayerBasedOnLevel(player1[] arr, String lvl) {
        int ans = 0;
        for(player1 p: arr)
        {
            if (p.getLevel().equalsIgnoreCase(lvl))return p.getId();
        }return ans;
    }

    private static int findPointsForGivenSkill(player1[] arr, String game) {
        int ans = 0;
        for(player1 p:arr)
        {
            if (p.getSkill().equalsIgnoreCase(game))
            {
                ans+= p.getPoints();
            }
        }
        return ans;
    }
}
class player1{
    private int id,points;
    private String skill,level;
    public player1(int id,String skill,String level,int points)
    {
        this.id = id;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}