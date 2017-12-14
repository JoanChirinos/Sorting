/*
  Sticky Noses - Johnny Wong, Joan Chirinos
  APCS1 pd8
  HW53
  2017-12-14
*/

    /**********
     * Best Case for bubbleSort: An AL in ascending order
     *    Why? Because the way we have it written, it has a constant number
     *    of comparisons (if AL size is constant). However, it only swaps if
     *    the element is in the wrong place. It would be better to tell the
     *    method to stop running once it passes without any swaps
     * Worst Case for bubbleSort: An AL in descending order
     *    Why? As previously stated, bubbleSort will do the same number of
     *    comparisons no matter the order. However, it will do the greatest
     *    number of swaps when the AL is in descending order. (I think it's
     *    about 0.5n^2 - 0.5n swaps . I did some trials and graphing stuff)
     **********/

    /**********
     * There is no worst or best case scenario for selectionSort  because, no
     * matter what, selectionSort has to do a constant number of comparisons
     * and swaps (even if an element swaps with itself)
     **********/

    /**********
     * Best case scenario for insertionSort: AL sorted in ascending order
     *    Why? Because like this, no elements will swap places. This will also
     *    result in the least number of comparisons
     * Worst case scenario for insertionSort: AL sorted in descending order
     *    Why? Because this way, it works sort of like a type of bubble(ish)
     *    sorting. Starting at element 1 and working towards the last element,
     *    each element will swap with the adjacent element with a lower index
     *    until it reaches index 0. This will result in the greatest number of
     *    swaps and comparisons.
     **********/

import java.util.ArrayList;

public class SortTester {


    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    
    public static void main(String[] args) {

	/***************************
	 * Creating+Populating ALs *
	 ***************************/
	
	ArrayList<Comparable> bestbubble = new ArrayList<Comparable>();
	for (int i = 1; i < 6; i++)
	    bestbubble.add(i);
	
	ArrayList<Comparable> worstbubble = new ArrayList<Comparable>();
	for (int i = 5; i > 0; i--)
	    worstbubble.add(i);

	
	ArrayList<Comparable> ascendingselect = new ArrayList<Comparable>();
	for (int i = 1; i < 6; i++)
	    ascendingselect.add(i);
	
	ArrayList<Comparable> descendingselect = new ArrayList<Comparable>();
	for (int i = 5; i > 0; i--)
	    descendingselect.add(i);

	ArrayList<Comparable> randomselect = new ArrayList<Comparable>();
	for (int i = 0; i < 5; i++)
	    randomselect.add(i);
	shuffle(randomselect);
	
	ArrayList<Comparable> bestinsert = new ArrayList<Comparable>();
	for (int i = 1; i < 6; i++)
	    bestinsert.add(i);
	
	ArrayList<Comparable> worstinsert = new ArrayList<Comparable>();
	for (int i = 5; i > 0; i--)
	    worstinsert.add(i);

	/**********************
	 * Sorting goes below *
	 **********************/

	System.out.println("bestbubble: ");
	MySorts.bubbleSort(bestbubble);
	System.out.println();

	System.out.println("worstbubble: ");
	MySorts.bubbleSort(worstbubble);
	System.out.println();

	System.out.println("ascendingselect: ");
	MySorts.selectionSort(ascendingselect);
	System.out.println();

	System.out.println("descendingselect: ");
	MySorts.selectionSort(descendingselect);
	System.out.println();

	System.out.println("randomselect: ");
	MySorts.selectionSort(randomselect);
	System.out.println();

	System.out.println("bestinsert: ");
	MySorts.insertionSort(bestinsert);
	System.out.println();

	System.out.println("worstinsert: ");
	MySorts.insertionSort(worstinsert);
	System.out.println();
    }
    
}
