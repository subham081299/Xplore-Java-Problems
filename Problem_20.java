package Xplore_Problems;
import java.util.Scanner;
public class Problem_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Autonomous_Car[] arr = new Autonomous_Car[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();sc.nextLine();
            String brand = sc.nextLine();
            int num_conducted = sc.nextInt();
            int num_passed = sc.nextInt();
            sc.nextLine();
            String environment = sc.nextLine();
            arr[i] = new Autonomous_Car(id,brand,num_conducted,num_passed,environment);
        }
        String env = sc.nextLine();
        String b = sc.nextLine();

        int ans1 = findNumberOfTestPassedByEnv(arr, env);
        Autonomous_Car ans2 = updateCarGrade(arr, b);

        if (ans1 > 0) {
            System.out.println(ans1);
        } else {
            System.out.println("There are no tests passed in this particular environment");
        }

        if (ans2 == null) {
            System.out.println("No Car is available with the specified brand");

        } else {
            System.out.println(ans2.getBrand() + "::" + ans2.getGrade());
        }
    }
    public static int findNumberOfTestPassedByEnv(Autonomous_Car[] arr , String env)
    {
        int ans = 0 ;
        for (Autonomous_Car obj :arr )
        {
            if (obj.getEnviroment().equalsIgnoreCase(env))
            {
                ans+= obj.getNumPassed();
            }
        }
        return ans;
    }

    public static Autonomous_Car updateCarGrade(Autonomous_Car[] arr,String brand)
    {
        Autonomous_Car ans = null;

        for(Autonomous_Car obj:arr)
        {
            if (obj.getBrand().equalsIgnoreCase(brand))
            {
                int rating = (obj.getNumPassed()*100)/obj.getNumConducted();
                if (rating>=80)
                {
                    obj.setGrade("A1");
                }
                else{
                    obj.setGrade("B2");
                }
                return obj;

            }
        }
        return ans;
    }
}
class Autonomous_Car{
    private int carld,num_conducted,num_passed;
    private String brand,environment,grade;
    public Autonomous_Car(int carld,String brand,int num_conducted,int num_passed,String environment)
    {
        this.carld= carld;
        this.brand = brand;
        this.num_conducted=num_conducted;
        this.num_passed=num_passed;
        this.environment=environment;


    }
    public void setCarId(int id)
    {
        this.carld=id;
    }
    public void setBrand(String b)
    {
        this.brand = b;
    }
    public void setNumConducted(int num)
    {
        this.num_conducted = num_conducted;
    }
    public void setNumPassed(int num)
    {
        this.num_passed = num_passed;
    }
    public void setEnviroment(String env)
    {
        this.environment = env;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    //getters
    public int getCarId()
    {
        return carld;
    }
    public String getBrand()
    {
        return brand;
    }
    public int getNumConducted()
    {
        return num_conducted;
    }
    public int getNumPassed()
    {
        return num_passed;
    }
    public String getEnviroment()
    {
        return environment;
    }
    public String getGrade()
    {
        return grade;
    }
}
