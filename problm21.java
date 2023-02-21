package Xplore_Problems;
/*


Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.



Create class Solution with the main method.

Implement two static methods - findAvgBudgetByDirector and getMovieByRatingBudget in Solution class.



findAvgBudgetByDirector method:
This method will take two input parameters - array of Movie objects and string parameter director.
The method will return the average of the budget attribute from Movie objects directed by the director passed as parameter.
If no movie with the given director is present in the array of movie objects, then the method should return 0.



getMovieByRatingBudget method:
This method will take two int parameters rating and budget, along with the array of movie objects.
The method will return the movie object, if the input parameters rating and budget, matches with the rating and budget attribute of the movie object respectively.

Also check if rating is a factor of budget (eg: 3 is a factor of 12 because 3 divides 12 without leaving a remainder).
If any of the conditions are not met, then the method should return null.



Note : No two movie object would have the same value for rating and budget attributes.
          All the searches should be case insensitive.
          The budget mentioned are in crores and in INR.


These above mentioned static methods should be called from the main method.

For findAvgBudgetByDirector method - The main method should print the average budget as it is if the returned value is greater than 0, or it
should print "Sorry - The given director has not yet directed any movie".



For getMovieByRatingBudget method - The main method should print the movieId of the returned movie object. If the returned value is null
then it should print "Sorry - No movie is available with the specified rating and budget requirement".



Before calling these static methods in main, use Scanner object to read the values of four
Movie objects referring attributes in the above mentioned attribute sequence.
Next, read the value for director, rating and budget.


Consider below sample input and output:


Input:


1101
ratham
4
100
1201
shankar
5
500
1301
shankar
3
50
1401
ratham
5
300
ratham
5
300

​

Output:


200
1401
 */
import java.util.*;
public class problm21 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        moviez[] arr = new moviez[4];
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            int rating = sc.nextInt();
            int budget = sc.nextInt();
            arr[i] = new moviez(id,name,rating,budget);
        }
        sc.nextLine();
        String director = sc.nextLine();
        int rat = sc.nextInt();
        int bud = sc.nextInt();
        int ans1 = findAvgBudgetbyDirector(arr,director);
        if (ans1>0) System.out.println(ans1);
        else System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        moviez temp = getMovieByRatingBudget(arr,rat,bud);
        if(temp == null)
            System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        else
            System.out.println(temp.getMovieId());

    }

    private static int findAvgBudgetbyDirector(moviez[] arr, String director) {
        int avg = 0,c=0;
        for (moviez m:arr)
        {
            if (m.getDirector().equalsIgnoreCase(director))
            {
                avg+=m.getBudget();
                c++;
            }
        }
        return avg>0?avg/c:0;
    }

    private static moviez getMovieByRatingBudget(moviez[] arr, int rat, int bud) {

        for (moviez a:arr)
        {
            if (a.getBudget()==bud && a.getRating()==rat && a.getBudget()%a.getRating()==0)
            {
                return a;

            }
        }return null;
    }
}
class moviez{
    private int movieId,rating,budget;
    private String director;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public moviez(int movieId, String director, int rating, int budget)
    {
        this.movieId=movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

}