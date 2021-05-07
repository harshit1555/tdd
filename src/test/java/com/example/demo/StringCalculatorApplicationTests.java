package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringCalculatorApplicationTests {

	@Test
	public void shouldReturnZero() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(0, cal.add(""));
		
	}
	
	@Test
	public void shouldReturnOne() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(1, cal.add("1"));
	}
	@Test
	public void addTwoValuesofString() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(3, cal.add("1,2"));
	}
	@Test 
	public void addMultipleValues() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(10, cal.add("1,2,3,4"));
	}
	@Test
	public void splitBySpace() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(6, cal.add("1\n2,3"));
	}
	@Test
	public void changeDelimiter() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(7, cal.add("1;2\n4"));
	}
	@Test
	public void negativeNumber() throws NegativeNumberExeption
	{
		
		try 
		{
			StringCal cal=new StringCal();
		}
		catch (Exception e) 
		{
			assertEquals("Negative numbers not allowed", e.getMessage());
		}
	}
	@Test 
	public void numberGreaterThan1000() throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(5, cal.add("1;1005\n4"));
	}
	@Test
	public void delimiterOfLengthThree()throws NegativeNumberExeption
	{
		StringCal cal=new StringCal();
		assertEquals(7, cal.add("1%2\n4"));
	}

}
