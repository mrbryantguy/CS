// Bryant Hernandez
// 10 / 2 / 2019

public class IntArrayBag {

	// Invariants of the IntArrayBag class:
	// 1.The actual number of elements in the bag is in the instance variable
	// manyItems, which is no more than data.length.
	// 2. For an empty bag, we do not care what is stored in data array;
	// for a non-empty bag, the elements in the bag are stored in data[0]
	// through data[manyItems-1], and we don not care what is in the
	// rest of the data array.
	
	private int[ ] data; // integer array
	private int manyItems; // count
	
	// add method
	public void add( int element ) {
		
		// if capacity is met, create new array
		if( manyItems == data.length ) {
			int biggerArray[ ];
			
				biggerArray = new int[ manyItems*2 + 1 ]; // double the size
				// copy in elements
				for( int i = 0; i < manyItems; i++ )
					biggerArray[i] = data[i];
				
				data = biggerArray;
		} // end if
		
		// add element
		data[manyItems] = element;
		manyItems++;
	} // end add
	
	// method to count number of occurrences of a particular element target
	public int countOccurrences(int target){
	int answer = 0 ;
	int index;
	answer = 0;
	
	for (index = 0; index < manyItems; index++)
		if (target == data[index])
			answer++;
	
	return answer;
	} // end coutnOccurrences
	

} // end class