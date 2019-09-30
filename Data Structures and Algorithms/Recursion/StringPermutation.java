/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#7 String Permutation
 * This program will use recursion to show all possible permutations of string abc.
 */

public class StringPermutation 
{
    public static void main(String[] args) 
    {
        String s = "abc";
        System.out.println(s + "'s permutations");
        System.out.println("-------------------");
        displayPermutation(s);
    }

    public static void displayPermutation(String s) 
    {
        displayPermutation("", s);
    }

    public static void displayPermutation(String s1, String s2) 
    {
        if (s2.equals("")) 
        {
            System.out.println(s1);
        } 
        else 
        {
            for (int i = 0; i < s2.length(); i++) 
            {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }
}
