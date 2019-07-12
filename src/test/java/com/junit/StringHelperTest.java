package com.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper=new StringHelper();

	@Test
	public void testStringHelper_DoubleA() {
		
		assertEquals("CD",helper.stringHelper("AACD")); 
		 
	}

	@Test
	public void testStringHelper_SinlgeA() {
		
		assertEquals("CD",helper.stringHelper("ACD")); 
	}
	
	@Test
	public void testfistAndLastAreSme_BasicNgative(){
		
		assertFalse("Checking Negative",helper.fistAndLastAreSme("ABCD"));
		assertTrue("Checking Positve",helper.fistAndLastAreSme("AB"));
	}
	
	@Test
	public void testCompareTwoArrays(){
		
		int a[]={1,3,2,5,4};
		int b[]={1,2,3,4,5};
		Arrays.sort(a);
		assertArrayEquals(b, a);
	}
	
	@Test(expected=NullPointerException.class)
	public void testCompareTwoArrays_NPE(){
		
		int a[]=null;
		
		Arrays.sort(a);
		//assertArrayEquals(b, a);
	}
	
	@Test(timeout=10)
	public void testCompareTwoArrays_Performance(){
		
		int a[]={1,3,4,2,5};
		for(int i=0;i<10000;i++){
			a[0]=i;
			Arrays.sort(a);
		}
		
		//assertArrayEquals(b, a);
	}
	
}
