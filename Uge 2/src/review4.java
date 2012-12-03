// Overholder implementationen metodens kontrakt?
public class review4 {
	/**
	  @param n integer
	  @precondition n >= 1
	  @return r: integer part of base 2 logarithm of n
	  @postcondition 2^r <= n && n < 2^(r+1)
	 */
	
	public int base2Log(int n) {
	  int m = n;
	  int r = 1; 
	  while (m>1) {r++; m = m/2;}
	  return r;
	}
}
/*
Den overholder ikke, for hvis n=1 er m=1 hvilket i løkken fører til at r bliver lig 2, så er 2^r=4 hvilket er > n
og derfor ikke overholder postcondition. Det er en overtrædelse, hvorfor kontrakten ikke er opfyldt.


*/