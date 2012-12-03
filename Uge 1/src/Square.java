//import java.util.Arrays;	//Bruges i afsnittet gammelt
import java.util.Scanner;

public class Square {

	public static void main(String[] args){
		// Bed om og husk input
		Scanner in = new Scanner(System.in);
		System.out.println("Intast et tal, n");
		int n = in.nextInt();
		
		// placer indtastede tal i Array
		int[] tal = new int[n];
		System.out.println("Godt, indtast nu "+n+" heltal");
		
		// Beder om n tal, hvor n er tidligere specificeret
		for(int i=0; i<n; i++){
			System.out.println("Indtast tal nummer "+(i+1));
			tal[i] = in.nextInt();				
		}
		
		/*
		Gammelt
		
		// Gå igennem alle indtastede tal og kvadrer dem. Der laves et nyt Array, så det gamle stadig er tilgængeligt, selvom det i dette tilfælde ikke er nødvendigt
		int[] kvadreret = new int[n];
		for(int i=0; i<n; i++){
			kvadreret[i] = (int) Math.pow(tal[i], 2);			
		}
		
		// Udskrivning 1
		// Benytter Arrays toString metode til at skrive ud. Svaret kommer i [] med værdier adskildt af kommaer
		System.out.println("Kvadratet på de indtastede tal er: "+Arrays.toString(kvadreret));
		
		String text = ""; //hvis der ikke bruges "" får jeg fejl om måske ikke initialized
		
		// Udskrivning 2
		// Indsæt alle kvadrerede værdier i en tekststreng, så de kan udskrives på en linje
		for(int i = 0; i<n; i++){
			text = text + kvadreret[i]+ " ";			
		}
		System.out.println("kvadratet på de indtastede tal er: "+text);
		*/
		
		
		// ny kortere og mere komprimeret version
		String text = "";
		for(int i=0; i<n; i++){
			text = text + " " +((int) Math.pow(tal[i], 2));
		}
		System.out.println("Kvadratet på de indtastede tal er: "+text);
	}
}
