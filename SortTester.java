/*
  Sticky Noses - Johnny Wong, Joan Chirinos
  APCS1 pd8
  HW53 -- Solid Comparative Analysis
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

     * Excecution time for both the Best Case and the Worst Case for 
     * bubbleSort seem to run like a linear function.
     * Why? The num of passes that it takes for the inputted ArrayList 
     * increases by a factor of 1 for every added element, which has 
     * been tested by our bubbleSort method printing out how many 
     * passes it takes to sort an AL in ascending order as well as an
     * AL in descending order.
     **********/

    /**********
     * There is no worst or best case scenario for selectionSort  because, 
     * no matter what, selectionSort has to do a constant number of comparisons
     * and swaps (even if an element swaps with itself)

     * Execution time for selectionSort seems to run like a linear function.
     * Why? The num of passes that it takes for the inputted ArrayList increases 
     * by a factor of 1 for every added element,which has been tested by our selectionSort 
     * method printing out how many passes it takes to sort an AL in ascending order, 
     * an AL in descending order, and an AL in 'random' (AL has been shuffled by the shuffle method) order.
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

     * Execution time for insertionSort seems to run like a linear function.
     * Why? The num of passes that it takes for the inputted ArrayList increases 
     * by a factor of 1 for every added element, which has been tested by our 
     * insertionSort method printing out how many passes it takes to sort an AL in 
     * ascending order and an AL in descending order.


     * CONCLUSIONS/JUSTIFICATIONS:
     * ***Data drawn from ArrayList of size 1000***

     * bubbleSort's Best Case requires 1 more swap than its Worst Case, 
     * but they have the same number of passes required.
     * The number of comparisons are also the same.

     * selectionSort's cases all require the same number of swaps, passes, and comparisons.

     * insertionSort's Best Case requires 0 swaps, the same number of passes, and less comparisons
     * as opposed to it's Worst Case, where its number of swaps equaled the number of comparisons yet 
     * required the same number of passes as insertionSort's Best Case.

     * *****TL;DR*****
     * All three current sort methods bubbleSort, selectionSort, and insertionSort all seem to be linear.
     * However, they may have different speeds (in respect to a graph on a coordinate plane, different slopes)
     * which is noticeable due to the different number of swaps and comparisons each method has to take in their best and worst cases.
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
	for (int i = 1; i < 1001; i++)
	    bestbubble.add(i);
	
	ArrayList<Comparable> worstbubble = new ArrayList<Comparable>();
	for (int i = 1000; i > 0; i--)
	    worstbubble.add(i);

	
	ArrayList<Comparable> ascendingselect = new ArrayList<Comparable>();
	for (int i = 1; i < 1001; i++)
	    ascendingselect.add(i);
	
	ArrayList<Comparable> descendingselect = new ArrayList<Comparable>();
	for (int i = 1000; i > 0; i--)
	    descendingselect.add(i);

	ArrayList<Comparable> randomselect = new ArrayList<Comparable>();
	for (int i = 0; i < 1000; i++)
	    randomselect.add(i);
	shuffle(randomselect);
	
	ArrayList<Comparable> bestinsert = new ArrayList<Comparable>();
	for (int i = 1; i < 1001; i++)
	    bestinsert.add(i);
	
	ArrayList<Comparable> worstinsert = new ArrayList<Comparable>();
	for (int i = 1000; i > 0; i--)
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
