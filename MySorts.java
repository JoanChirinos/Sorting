// Sticky Noses - Johnny Wong, Joan Chirinos
// APCS1 pd8
// HW53 --
// 2017-12-14



public class MySorts {
    
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSort( ArrayList<Comparable> data )
    {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
		//System.out.println(data); //diag: show current state of list
	    }
	}
    }

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
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
	}
    }//end selectionSort

    /**********
     * There is no worst or best case scenario for selectionSort  because, no
     * matter what, selectionSort has to do a constant number of comparisons
     * and swaps (even if an element swaps with itself)
     **********/

    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSort( ArrayList<Comparable> data )
    {
	for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

		// "walk" the current item to where it belongs
		// by swapping adjacent items
		if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
		    //diag:
		    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
		    data.set( i, data.set( i-1, data.get(i) ) ); 
		}
		else 
		    break; 
	    }
	}
    }//end insertionSort

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
}
