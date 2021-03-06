import java.math.BigInteger;
import java.util.Random;

public class NumberUtils {
	/**
	 * Draws a random number from the binomial distribution. 
	 * @param n The number of triles; bits in the message 
	 * @param errorRate The probability of success; the error-rate
	 * @return (int) A random number of successes; the number of errors in this message
	 */

public static int binomdist(final int n, final double errorRate) {
		float x;
		int s=0;
		int i=0;
		Random rand = new Random();
		while (i < n) {
			x = rand.nextFloat();
			if (x < errorRate) {
				s++;
			}
			i++;
		}
		return s;
	}

	public static BigInteger choose (final int N, final int K) {
		BigInteger ret = BigInteger.ONE;
		for (int k = 0; k < K; k++) {
			ret = ret.multiply(BigInteger.valueOf(N-k)).divide(BigInteger.valueOf(k+1));
		}
		return ret;
	}

	public static int calcT(int n, int k) {
int i=0;
BigInteger t=new BigInteger("0");
BigInteger  result = BigInteger.valueOf(2);
result=result.pow((n-k));
BigInteger temp;
while (t.compareTo(result) != 1) {
	i+=1;
	temp=NumberUtils.choose(n, i);
		t=t.add(temp);
}
return i-1;

	}

}
