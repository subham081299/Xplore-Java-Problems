package Xplore_Problems;
/*Write a Java program to print the characters at the odd position of a given string

        Input
        Hey there!
        Output
        e hr!

 */
import java.util.*;
public class Problem_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        char[] result = s.toCharArray();
        for(int i=1;i<result.length;i=i+2) {
            System.out.print(result[i]);
        }
    }

}
