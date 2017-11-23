
import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionsTest {

	@Test(timeout=500)
	public void test1() {
		assertTrue(Functions.isPrime(2));
	}
	@Test(timeout=500)
	public void test2() {
		assertTrue(Functions.isPrime(13));
	}
	@Test(timeout=500)
	public void test3() {
		assertFalse(Functions.isPrime(25));
	}
	@Test(timeout=500)
	public void test4() {
		assertTrue(Functions.isPrime(Integer.MAX_VALUE));
	}
///////////////////////
	@Test(timeout=500)
	public void test5() {
		int n=36;
		int expected = 7;
		int actual = Functions.numDividers(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=500)
	public void test6() {
		int n=13;
		int expected = 0;
		int actual = Functions.numDividers(n);
		assertEquals(expected, actual);
	}
	@Test(timeout=500)
	public void test7() {
		int n=14;
		int expected = 2;
		int actual = Functions.numDividers(n);
		assertEquals(expected, actual);
	}
	///////////////
	@Test(timeout=500)
	public void test8() {
		String s = "abcd";
		String expected ="dcba";
		String actual = Functions.reverse(s);
		assertEquals(expected, actual);
	}
	///////////////
	@Test(timeout=500)
	public void test9() {
		String s = "abcde";
		String expected ="edcba";
		String actual = Functions.reverse(s);
		assertEquals(expected, actual);
	}
	@Test(timeout=500)
	public void test10() {
		String s = "a";
		String expected ="a";
		String actual = Functions.reverse(s);
		assertEquals(expected, actual);
	}	
	@Test(timeout=500)
	public void test11() {
		Functions.infinity();
	}
	@Test(timeout=500)
	public void test12() {
		int[]a1 = {1,2,1,5,6,7,0,-1}, expected = {1,5,6,7};
		int []actual = Functions.longestMonotony(a1);
		assertArrayEquals(expected, actual);
	}
	@Test(timeout=500)
	public void test13() {
		int[]a1 = {1,2,5,6,7,0,-1}, expected = {1,2,5,6,7};
		int []actual = Functions.longestMonotony(a1);
		assertArrayEquals(expected, actual);
	}
	@Test(timeout=500)
	public void test14() {
		int[]a1 = {1,2,-1,5,6,7}, expected = {-1,5,6,7};
		int []actual = Functions.longestMonotony(a1);
		assertArrayEquals(expected, actual);
	}
}
