// Sticky Noses - Johnny Wong, Joan Chirinos
// APCS1 pd8
// HW55 -- Never Fear, Big Oh Is Here!
// 2017-12-14

import java.util.ArrayList;

public class MySorts {
 
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
    
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // Best case time: O(n)
    // Worst case time: O(n)
    //    Why? Our implementation of bubbleSort makes n-1 passes. We don't
    //    have the functionality to recognize when the AL is sorted. Instead,
    //    we coded for a set number of passes
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	
	int swapcount = 0, compcount = 0, passcount = 0;
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {

	    passcount++;
	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		compcount++;
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 )
		    swapcount++;
		    data.set( i, data.set(i+1,data.get(i)) );	
		//System.out.println(data); //diag: show current state of list
	    }
	}
	System.out.println("# of elements: " + data.size());
	System.out.println("# of comparisons: " + compcount);
	System.out.println("# of swaps: " + swapcount);
	System.out.println("# of passes: " + passcount);
    }

    /**********
     * There is no worst or best case scenario for selectionSort  because, no
     * matter what, selectionSort has to do a constant number of comparisons
     * and swaps (even if an element swaps with itself)
     **********/
    
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // Best case time: O(n)
    // Worst case time: O(n)
    //    Why? Our implementation of selectionSort makes n-1 passes.
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	int swapcount = 0, compcount = 0, passcount = 0;
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    passcount++;
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		compcount++;
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    swapcount++;
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	}
	System.out.println("# of elements: " + data.size());
	System.out.println("# of comparisons: " + compcount);
	System.out.println("# of swaps: " + swapcount);
	System.out.println("# of passes: " + passcount);
    }//end selectionSort

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

    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    // Best case time: O(n)
    // Worst case time: O(n)
    //    Why? Our implementation of insertionSort makes n-1 passes
    public static void insertionSort( ArrayList<Comparable> data )
    {
	int swapcount = 0, compcount = 0, passcount = 0;
	for( int partition = 1; partition < data.size(); partition++ ) {
	    passcount++;
	    //partition marks first item in unsorted region

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		compcount++;
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    swapcount++;
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
	System.out.println("# of elements: " + data.size());
	System.out.println("# of comparisons: " + compcount);
	System.out.println("# of swaps: " + swapcount);
	System.out.println("# of passes: " + passcount);
    }//end insertionSort


    /******************************
     * CONCLUSIONS/JUSTIFICATIONS:*
     ******************************
     * ***Data drawn from ArrayList of size 1000***

     * bubbleSort's Best Case requires 1 more swap than its Worst Case, 
     * but they have the same number of passes required.
     * The number of comparisons are also the same.

     * selectionSort's cases all require the same number of swaps, passes, and
     * comparisons.

     * insertionSort's Best Case requires 0 swaps, the same number of passes,
     * and less comparisons
     * as opposed to it's Worst Case, where its number of swaps equaled the
     * number of comparisons yet 
     * required the same number of passes as insertionSort's Best Case.

     * *****TL;DR*****
     * All three current sort methods bubbleSort, selectionSort, and
     * insertionSort all seem to be linear.
     * However, they may have different speeds (in respect to a graph on a
     * coordinate plane, different slopes)
     * which is noticeable due to the different number of swaps and comparisons
     * each method has to take in their best and worst cases.
     * we can conclude that, although the swaps for these methods increase
     * linearly, in practice the swaps and comparisons make some run slower
     * than others, under certain conditions
     **********/

}
