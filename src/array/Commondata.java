package array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Commondata {
public static ArrayList<Integer> findCommonElements( int[][] arrays ){
    	
    	final ArrayList<Integer> commonElements = new ArrayList<Integer>();  
    	
    	int maxSoFar = Integer.MIN_VALUE; 
    	System.out.println("maxSoarrays.lengthFar :"+arrays.length);
	    while( true ){ 		    	
	    	
	    	int maxValueToSearchNext = Integer.MIN_VALUE;
	    	
	    	boolean allEqual = true;
	    	
	    	for( int j = 0; j < arrays.length; j++ ){    			
	    		System.out.println("maxSoFar :"+maxSoFar);
				int pos = Arrays.binarySearch( arrays[j], maxSoFar );	    			
				System.out.println("pos :"+pos);
				if( pos < 0 ){
					
					allEqual = false;
					pos = Math.abs(pos) - 1;
					
					if( pos >= arrays[j].length ){
						break;
					}
					
					int curValue = arrays[j][pos];
					
					maxValueToSearchNext = Math.max( maxValueToSearchNext, curValue );
					
				} 	
				else {				
					if( pos + 1 < arrays[j].length ){
						int nextValue = arrays[j][pos+1];
						if( nextValue != maxSoFar ){
							maxValueToSearchNext = Math.max( maxValueToSearchNext, arrays[j][pos+1] );
						}
					}				
				}
				System.out.println("maxValueToSearchNext :"+maxValueToSearchNext);
			}
	    	
	    	if( allEqual ){
	    		
	    		commonElements.add( maxSoFar );
	    		
	    		if( maxValueToSearchNext == maxSoFar ){
	    			break; 
	    		}
	    	}	    	
       		
       		if( maxValueToSearchNext == Integer.MIN_VALUE ){
       			break;
       		}       		
       		maxSoFar = maxValueToSearchNext; 
	    }
	    
    	return commonElements;
    }
public static void main(String [] aargs)
{
	int [][] arr = { {10,160 ,200 ,500, 500},{4 ,150, 160, 200 ,500},{ 2 ,160 ,200 ,202 ,203},{ 3 ,150, 155 ,160 ,200},{3 ,150 ,155 ,160 ,200}};
			
	
	ArrayList<Integer>  res = findCommonElements(arr);
	System.out.println("result :"+res.toString());
}
}
