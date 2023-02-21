package Xplore_Problems;
/*
   ## Problem Statement

Create a class NavalVessel with the below attributes:\
vesselId – int\
vesselName – String\
noOfVoyagesPlanned – int\
noOfVoyagesCompleted – int\
purpose – String\
classification – String

Write getters, setters for the above attributes. Create constructor which takes parameter in the above sequence except classification.

Create class Solution with main method. Implement two static methods – findAvgVoyagesByPct and findVesselByGrade in Solution class.

**findAvgVoyagesByPct method:**

This method will take two input parameters -array of NavalVessel objects and int parameter percentage. The method will return the average of the noOfVoyagesCompleted attribute from NavalVessel objects which meets the percentage requirement as mentioned below.The percentage for each navalVessel is calculated as percentage .(noOfVoyagesCompleted \* 100)/noOfVoyagesPlanned. If the above calculated percentage is greater than or equal to the percentage passed as the parameter, then those objects should participate in the average calculation. If there are no objects with the mentioned criteria, then the method should return 0.

**findVesselByGrade method:**

This method will take a String parameter purpose, along with the array of NavalVessel objects. The method will return the NavalVessel object, if the input String parameter matches with the purpose attribute of the NavalVessel object.
Before returning the object, the classification should be derived as mentioned below. This classification value should be assigned to the object before returning. If any of the above conditions are not met, then the method should return null.
The classification attribute should be calculated based on the percentage calculation mentioned above. If the percentage = 100 then classification should be ‘Star’, if percentage is between 99 and 80 then classification should be ‘Leader, if percentage is between 79 and 55 then classification should be ‘Inspirer otherwise the classification should be ‘Striver’
If the returned value is null then it should print “No Naval Vessel is available with the specified purpose”.

Before calling these static methods in main, use Scanner object to read the values of four NavalVessel objects referring attributes in the above mentioned attribute sequence (except the classification attribute). Next, read the value for percentage and purpose.

## Input

    111
    Rojer
    100
    100
    Passenger
    222
    Kalam
    200
    100
    Goods
    333
    Yashwin
    400
    300
    Army
    444
    Thanishwini
    500
    500
    Welfare
    75
    Army

## Output

    300
    Yashwin%Inspirer
 */
import java.util.*;
public class Problem_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavalVessel[] input = new NavalVessel[4];
        for (int i = 0 ; i<4 ; i++)
            input[i] = new NavalVessel(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.next());
        int percentage = sc.nextInt();
        String purpose = sc.next();
        sc.close();
        int ans1 = findAvgVoyagesByPct(percentage,input);
        if (ans1 > 0) System.out.println(ans1);
        else
            System.out.println("There are no voyages completed with this percentage");
        NavalVessel ans2 = findVesselByGrade(purpose , input);
        if (ans2 == null)
            System.out.println("No Naval Vessel is available with the specified purpose");
        else
            System.out.println(ans2.getVesselName() + "%" + ans2.getClassification());

    }

    private static NavalVessel findVesselByGrade(String purpose, NavalVessel[] input) {
        for (int i = 0;i<4; i++) {

            if (purpose.equalsIgnoreCase(input[i].getPurpose())) {
                int percent = (input[i].getNoOfVoyagesCompleted() * 100) / input[i].getNoOfVoyagesPlanned();
                if (percent == 100)input[i].setClassification("Star");
                else if (percent>=80 && percent<100)input[i].setClassification("Leader");
                else if (percent>=55 && percent<80)input[i].setClassification("Inspirer");
                else input[i].setClassification("Striver");
                return input[i];
            }
        }
        return null;
    }

    public  static  int findAvgVoyagesByPct(int percentage ,NavalVessel[] arr)
    {
        int avg = 0,cnt = 0;
        for (int i = 0;i<4; i++)
        {
            int percent = (arr[i].getNoOfVoyagesCompleted() * 100) / arr[i].getNoOfVoyagesPlanned();
            if (percent>= percentage)
            {
                avg+= arr[i].getNoOfVoyagesCompleted();
                cnt++;
            }
        }
        if (avg ==0)return 0;
        else return avg/cnt;
    }
}
class NavalVessel
{
    private int vesselId,noOfVoyagesPlanned,noOfVoyagesCompleted;
    private String vesselName,purpose,classification;
    public NavalVessel(int vesselId,String vesselName , int noOfVoyagesPlanned,int noOfVoyagesCompleted,String purpose)
    {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;

    }

    public int getVesselId() {
        return vesselId;
    }

    public void setVesselId(int vesselId) {
        this.vesselId = vesselId;
    }

    public int getNoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }

    public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
    }

    public int getNoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}