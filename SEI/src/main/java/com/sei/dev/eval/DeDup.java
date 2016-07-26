package com.sei.dev.eval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

/**
 * This class implementation for getting unique numbers from an array.
 * User: Durga Maram
 * Date: 07/21/2016
 * Time: 8:36 AM
 */
public class DeDup {
	/**
	 * Logger for logging
	 */
	private static final Logger LOGGER = Logger.getLogger(DeDup.class.getName());
	/**
	 * Local variable
	 */
	public transient int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
	/**
	 * Error message
	 */
	public static final String ERROR_MESSAGE = "Input should not be null";

	/**
	 * Use Case: Sorts the input array into ascending numerical order & duplicates skipped
	 * Implementation note: The sorting is done by Arrays.sort
	 * Performance 0(nlog(n))
	 * @param input array to be sorted which had duplicates 
	 * @return array of unique items from input array in sorted order
	 * @throws NullPointerException - if the input is null
	 */	
	public int[] sortAndFindUnique(final int[] input){
		LOGGER.debug("entered sortAndFindUnique(int[] input)");
		Validate.notNull(input, ERROR_MESSAGE);
		
		final int[] sortedArray = new int[input.length];
		System.arraycopy(input, 0, sortedArray, 0, sortedArray.length);
		Arrays.sort(sortedArray);
		final List<Integer> noDuplicateList = new ArrayList<Integer>(input.length);
		int previousElement = 0;
			 
	    for (int i = 0; i < sortedArray.length;i++) {
	    	if (i==0 || previousElement != sortedArray[i]) {
	    		noDuplicateList.add(sortedArray[i]);
	    	}
	    	previousElement = sortedArray[i];
	    }
	    return covertCollectionToArray(noDuplicateList);
	}

	/**
	 * Use Case: Finds Unique numbers in a specified int array.
	 * Pros: Produced array will not contain any duplicate numbers
	 * Cons: No guarantee of the original order
	 * Performance 0(n)
	 * @param input array to be sorted which had duplicates 
	 * @return array of unique items from input array 
	 * @throws NullPointerException - if the input is null
	 */
	public int[] findUnique(final int[] input){
		LOGGER.debug("entered findUnique(int[] input)");
		Validate.notNull(input, ERROR_MESSAGE);

		final Set<Integer> setInt = new HashSet<Integer>();
		for(final int i: input){
			setInt.add(i);
		}
		   
	    return covertCollectionToArray(setInt);
	}

	/**
	 * Use Case: Finds Unique numbers in specified in an int array.
	 * Pros: Produced array will not contain any duplicate numbers
	 * Pros: Original order is preserved.
	 * Memory constraint.
	 * @param input array to be sorted which had duplicates 
	 * @return array of unique items from input array
	 * @throws NullPointerException - if the input is null 
	 */	
	public int[] findUniqueNoOrderChange(final int[] inputIntegers){
		LOGGER.debug("entered findUniqueNoOrderChange(int[] input)");
		Validate.notNull(inputIntegers, ERROR_MESSAGE);
		
		final Set<Integer> setInt = new LinkedHashSet<Integer>();
		
		for(final int i: inputIntegers){
			setInt.add(i);
		}
	    return covertCollectionToArray(setInt);
	}
	
	/**
	 * Utility method to convert integer Collection<Integer> to int array.
	 * @param input integer Collection<Integer> 
	 * @return int array 
	 * @throws NullPointerException - if the input is null
	 */		
	
	public int[] covertCollectionToArray(final Collection<Integer> input) {
		LOGGER.debug("entered covertCollectionToArray(int[] input) from :");
		Validate.notNull(input, ERROR_MESSAGE);
		final int[] intArray = ArrayUtils.toPrimitive(input.toArray(new Integer[0])); 
		LOGGER.debug("before return the results :");
		LOGGER.debug(Arrays.toString(intArray));
		return intArray;
	}

}
