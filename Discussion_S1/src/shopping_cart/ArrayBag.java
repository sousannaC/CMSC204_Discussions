/*
 * Student name: Sousanna Chugunova
 * Class: CMSC204 
 * Instructor: Dr. Thai
 * Platform/compiler: eclipse
 */

package shopping_cart;
import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T>{
	 private T[] bag;
	 private int numberOfEntries;
	 private static final int DEFAULT_CAPACITY = 25;
	 
	 @SuppressWarnings("unchecked")
	public ArrayBag() {
	 bag = (T[]) new Object [DEFAULT_CAPACITY];
	 numberOfEntries = 0;
	 }

	/** Returns the current size of the bag */
	public int getCurrentSize() {
	return numberOfEntries; 
	}
	
	
	/** Checks if bag is empty */
	public boolean isEmpty() {
    return numberOfEntries == 0;
}
	
	/** Adds a new entry to this bag.*/
	public boolean add(T newEntry) {
	    if (numberOfEntries == bag.length) {
	        doubleCapacity();
	    }
	    bag[numberOfEntries++] = newEntry;
	    return true;
	}
	
    /** Doubles the capacity of the array bag. */
	private void doubleCapacity() {
	    int newCapacity = bag.length * 2;
	    bag = Arrays.copyOf(bag, newCapacity);
	}
	
	/** 
	 * Removes and returns the entry at the given index within the bag.	 */
	private T removeEntry(int givenIndex) {
	    T result = null;
	    if (givenIndex >= 0 && givenIndex < numberOfEntries) {
	        result = bag[givenIndex];
	        bag[givenIndex] = bag[numberOfEntries - 1];
	        bag[numberOfEntries - 1] = null;
	        numberOfEntries--;
	    }
	    return result;
	}
	
    /** Removes one unspecified entry from this bag, if possible. */
	@Override
	public T remove() {
	    if (isEmpty()) {
	        return null;
	    } else {
	        return removeEntry(numberOfEntries - 1);
	    }
	}
	
	/** Removes one occurrence of a given entry from this bag, if possible.*/
	@Override
	public boolean remove(T anEntry) {
	    int item = getIndexOf(anEntry);
	    if (item != -1) {
	        removeEntry(item);
	        return true;
	    }
	    return false;
	}
	/** 
	 * Locates given entry within the bag and returns the index if found, 
	 * or -1 otherwise. */
	private int getIndexOf(T anEntry) {
	    for (int i = 0; i < numberOfEntries; i++) {
	        if (anEntry.equals(bag[i])) {
	            return i;
	        }
	    }
	    return -1;
	}
	/** Removes all entries from this bag. */
	@Override
	public void clear() {
	    Arrays.fill(bag, null);
	    numberOfEntries = 0;
	}
	
	/** Counts the number of times a given entry appears in this bag.*/
	@Override
	public int getFrequencyOf(T anEntry) {
	    int frequency = 0;
	    for (T entry : bag) {
	        if (anEntry.equals(entry)) {
	            frequency++;
	        }
	    }
	    return frequency;
	}
	
	/** Tests whether this bag contains a given entry.*/
	@Override
	public boolean contains(T anEntry) {
	    for (T entry : bag) {
	        if (anEntry.equals(entry)) {
	            return true;
	        }
	    }
	    return false;
	}
   
	/** Retrieves all entries that are in this bag.*/
	@Override
	public T[] toArray() {
	    @SuppressWarnings("unchecked")
	    T[] returnArray = (T[]) new Object[numberOfEntries];
	    int index = 0;
	    for (T entry : bag) {
	        if (entry != null) {
	            returnArray[index++] = entry;
	        }
	    }
	    return returnArray;
	}

} 



