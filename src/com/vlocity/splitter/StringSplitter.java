package com.vlocity.splitter;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

	public String givenString;
	public String[] separators;
	
	public static void main(String[] args) {
		
		StringSplitter split = new StringSplitter("foo.bar#baz",Separator.PERIOD.toString());
	    split.splitMethod();
	
	    split = new StringSplitter("foo.bar#baz",Separator.PERIOD.toString(),Separator.HASH.toString());
	    split.splitMethod();
	}
	
	public StringSplitter (String givenString, String... separators) {
	    this.givenString=givenString;
	    this.separators = separators;
	}
	
	public List<String> splitMethod() {
	
	    String newGivenString = givenString;
	
	    if(separators.length > 1) {
	        // skip the first separator
	        for(int i = 1; i < separators.length; i++) {
	            newGivenString = newGivenString.replaceAll(separators[i], separators[0]);
	        }
	    }
	
	    List<String> splitList  = Arrays.asList(newGivenString.split(separators[0]));
	
	    System.out.println(splitList);
	
	    return splitList;	
	}   	
	
	enum Separator{	
		
	    PERIOD {
	        @Override
	        public String toString() {
	            return "\\.";
	        }
	    },	
	    
	    HASH {
	        @Override
	        public String toString() {
	            return "#";
	        }
	    },
	
	    COMMA {
	        @Override
	        public String toString() {
	            return ",";
	        }
	    }	
	}

}
