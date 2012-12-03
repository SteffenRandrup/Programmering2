// review 1 og 2. Den virker også i opgave 1
import java.util.Scanner;

public class potens {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Indsæt to tal? ");
		int x = in.nextInt();
		int n = in.nextInt();
		System.out.println("Har nu beregnet " + x + "^" + n + " til: "
				+ pot(x, n));
	}

	public static double pot(double x, int n) {
		double svar;
		if (n % 2 == 0) {
			svar = Math.pow(pot(x,n/2), 2);
		} else {
			if (n == 1) {
				return x;
			}
			svar = x * pot(x, n - 1);
		}
		return svar;
	}
}
