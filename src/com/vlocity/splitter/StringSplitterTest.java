package com.vlocity.splitter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.vlocity.splitter.StringSplitter.Separator;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.Assert;

public class StringSplitterTest {
	
	String str1, str2;
	
	// Store the original standard out before changing it.
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	StringSplitter split = new StringSplitter(str1, str2);
		
	@BeforeMethod
	public void beforeTest() {
		// Redirect all System.out to consoleContent.	
		System.setOut(new PrintStream(outContent));    
	}	
	
	@Test (description = "Test method 1")
	public void testMethod1() {                	

		// String Separator - Period
		split = new StringSplitter("foo.bar#baz",Separator.PERIOD.toString());		
		split.splitMethod();
		
		// Verify the string
		Assert.assertEquals(outContent.toString().trim(), split.splitMethod().toString());
	}
	
	@Test (description = "Test method 2")
	public void testMethod2() {  
		
		// String Separator - Period and Hash
		split = new StringSplitter("foo.bar#baz",Separator.PERIOD.toString(),Separator.HASH.toString());
		split.splitMethod();
		        
		// Verify the string
		Assert.assertEquals(outContent.toString().trim(), split.splitMethod().toString());

	}
	
	@AfterMethod
	public void afterTest() {
		// Put back the standard out.
		System.setOut(originalOut);
		
		// Print what has been captured.
		System.out.println("Actual String:" + this.outContent.toString());
		System.out.println("Expected String:" + split.splitMethod());
		
		// Clear the consoleContent.
        this.outContent = new ByteArrayOutputStream();
		
	}
}
