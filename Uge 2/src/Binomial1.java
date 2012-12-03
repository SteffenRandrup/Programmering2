public class Binomial1 {
	
	public long binomial(int n, int k) {
		//assert(0 <= k && k <= n && n <= 60);
		long result = 0;
		
		if (k == 0 || n == k) {
			result = 1;
		}else{
			result = binomial(n,k-1)*(n-k+1)/k;
		}
		return result;
	}
}