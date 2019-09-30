/*
 * Name: Tyler Cromack
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW#8 Spell Check
 * This program will find misspelled words in a text and move them to the top of the index when found
 */
public class MostRecentlyUsed<E extends String> extends MyLinkedList<E> 
{
 
    @Override
    public boolean contains(E e) 
    {
        if (indexOf(e) != -1) 
        {
            remove(e);
            addFirst(e);
            return true;
        }
        
        return false;
    }
}
