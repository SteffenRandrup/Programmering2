import java.util.Scanner;


public class Test2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Indsæt to tal? ");
    int talEt = in.nextInt();
    int talTo = in.nextInt();
    System.out.println("Summen af dine tal er " + (talEt+talTo));
  }
  
}