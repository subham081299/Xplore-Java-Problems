package Xplore_Problems;
/*
## Problem Statement

Create class Movie with below attributes:
movieName - String
company - String
genre - String
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class.
This method will take array of Movie objects and a searchGenre String as parameters.
And will return another array of Movie objects where the searchGenre String matches with the original array of Movie object's genre attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the attributes in above sequence along with a String searchGenre.
Then call the "getMovieByGenre" method and write logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else print "Low Budget Movie".

## Input

    aaa
    Marvel
    Action
    250000000
    bbb
    Marvel
    Comedy
    25000000
    ccc
    Marvel
    Comedy
    2000000
    ddd
    Marvel
    Action
    300000000
    Action

## Output

    High Budget Movie
    High Budget Movie
 */
import java.util.*;
public class Problem_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Movies[] movies = new Movies[4];
        for (int i = 0;i<4; i++)
            movies[i] = new Movies(sc.next(), sc.next(), sc.next(), sc.nextInt());
        String search_genre = sc.next();
        sc.close();
        Movies[] ans= getMovieByGenre(movies,search_genre);
        for (int i = 0 ; i< ans.length;i++)
        {
            if(ans[i].getBudget()>80000000) System.out.println("High Budget Movie");
            else System.out.println("Low Budget Movie");
        }
    }

    private static Movies[] getMovieByGenre(Movies[] movies, String search_genre) {
        Movies[] ans= new Movies[0];
        for (int i = 0 ; i<movies.length ; i++)
        {
            if (movies[i].getGenre().equalsIgnoreCase(search_genre))
            {
                ans = Arrays.copyOf(ans,ans.length+1);
                ans[ans.length-1]= movies[i];
            }
        }
        return ans;
    }
}
class Movies{
    private String movieName,company,genre;
    private int budget;
    public Movies(String movieName,String company,String genre,int budget)
    {
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
