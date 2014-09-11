import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class NumberUtilsTest {

	@Test
	public void binomTest() {
		int n;
		float p;
		n=30;
		p=0.5f;
		//System.out.println(NumberUtils.binomdist(n, p));
	}
	@Test
	public void chooseTest() {
		int n = 4;
		int k = 2;
		BigInteger result = NumberUtils.choose(n, k);
		BigInteger expected = BigInteger.valueOf(6);
		assertEquals(result, expected);
	}
	@Test
	public void testCalcT() {
		int n=70;
		int k=39;
		//System.out.println("t is");
		int t=NumberUtils.calcT(n, k);
		//System.out.println(t);
	}

 	@Test
	public void bscTest() {
		BSC b=new StateBSC(30, 100, 0.05, 0.2, 0.1, 0.9);
		b.getInfo();
		b.simulation(1000000);
				}
}
