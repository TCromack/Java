/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#6 Baby Names Application
 * Setters,Getters,Constructors
 */
package babynames;
 
public class BabyName implements Comparable<BabyName>
{
    
    private String name;
    private String gender;
    private int number;
    
    public BabyName(String name, String gender, int number)
    {
        this.name = name;
        this.gender = gender;
        this.number = number;
        
    }
 
    public void numberCount(int number)
    {
        this.number += number;
    }
    
    public String getName()
    {
        return this.name;
    }
 
    public int getNumber()
    {
        return this.number;
    }
 
//************************************************************************************
    public boolean equals(Object temp)
    {
        if (this == temp)
            return true;
        if (temp == null)
            return false;
        if (getClass() != temp.getClass())
            return false;
        BabyName other = (BabyName) temp;
        if (name == null)
        {
            if (other.name != null)
                return false;
        } 
        else if (!name.equals(other.name))
            return false;
        return true;
    }
 
//************************************************************************************
    public int compareTo(BabyName sort) 
    {
        if (this.number < sort.number)
            return 1;
        if (this.number > sort.number)
            return -1;
        if (this.name.compareTo(sort.name) < 0)
            return -1;
        if (this.name.compareTo(sort.name) > 0)
            return 1;
        else
            return 0;
    }
//************************************************************************************
    public String toString()
    {
        return "Name: " + this.name + " Gender: " + this.gender + "  Number: " + this.number + "\n";
    }
}
