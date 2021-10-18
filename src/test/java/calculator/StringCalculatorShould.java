package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

class StringCalculatorShould {

		StringCalculator strCal;
		
		@BeforeEach
		public void init() {
			strCal= new StringCalculator();			
			}
		//1
		@Test
		void StringIsEmptyReturnZero() throws NegativeNumberException {
			assertEquals(0,strCal.Add(""));
			
		}
		//2
		@Test
		void StringHavingSingleDigitReturnDigit() throws NegativeNumberException {
			assertEquals(3,strCal.Add("3"));
			}
		//3
		@Test
		void StringHavingTwoDigitWithCommaDelimeterReturnSum() throws NegativeNumberException {
			assertEquals(5,strCal.Add("2,3"));
			}
		//4
		@Test
		void StringHavingLargeNumberWithCommaDelimeterReturnSum() throws NegativeNumberException {
			assertEquals(100,strCal.Add("3,3,4,2,6,7,12,10,13,40"));
			}
		//5
		@Test
		void StringHavingTwoDigitWithSemiColnDelimeterReturnSum() throws NegativeNumberException {
			assertEquals(4,strCal.Add("1;3"));
		
		
			}
		//6
		@Test
		void StringHavingThreeDigitWithCommaDelimeterAndLineChangeReturnSum() throws NegativeNumberException {
			assertEquals(8,strCal.Add("3\n,3,2"));
			}
		//7
		@Test
		void StringHavingNumberThousandOrAboveGreaterThenReturnSum() throws NegativeNumberException {
			assertEquals(8,strCal.Add("1000,1,3,4"));
			}
		//8
		@Test
		public void StringWithNegativeNumThrowsException() {
		    Throwable exception = assertThrows(NegativeNumberException.class,
		          ()->{strCal.Add("[#]\n-2#1");} );
		}
		//9
		@Test
		public void DelimeterOfAnyLength()throws NegativeNumberException {
			assertEquals(6,strCal.Add("[***]\n1***2***3"));
			}
		//10
		@Test
		public void DelimeterOfAnyLengthAndNumberAreBig()throws NegativeNumberException {
			assertEquals(10,strCal.Add("[****]\n1****2****3****1002****4"));
			}
		
}
 
