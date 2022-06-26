
//assertTrue(boolean condition), 
//assertEquals(String expected, String actual), 
//assertFalse(boolean condition),
//assertNotNull(object)
//assertNull(object)

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
public class TestFunctions {
	@Test
	public void testIsPrime() {
		assertEquals(false, Functions.isPrime(25));
		assertEquals(true, Functions.isPrime(13));
		assertTrue(Functions.isPrime(1000003));
	}

	@Test
	public void testNumDividers() {
		assertEquals(1, Functions.numDividers(25));
		assertEquals(7, Functions.numDividers(36));
	}

	@Test
	public void testReverse() {
		assertEquals(Functions.reverse("abcd"), "dcba");
		assertEquals(Functions.reverse("abcd"), "dcba");		
	}
	@Test(timeout=1000)
	public void testInfinity(){
		Functions.infinity();
	}
	@Test
	public void testLongestMonotony() {
		int[]a1 = {1,2,1,5,6,7,0,-1}, a1Ans = {1,5,6,7};
		int[]a2 = {1,2,5,6,7,0,-1}, a2Ans = {1,2,5,6,7};
		int[]a3 = {1,2,-1,5,6,7}, a3Ans = {-1,5,6,7};
		assertEquals(Arrays.equals(a1Ans, Functions.longestMonotony(a1)), true);
		assertEquals(Arrays.equals(a2Ans, Functions.longestMonotony(a2)), true);
		assertEquals(Arrays.equals(a3Ans, Functions.longestMonotony(a3)), true);
	}
}
