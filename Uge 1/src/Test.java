public class Test {
  public static void main(String[] args) {
    int n = args.length;
    System.out.println("antal parametre: " + n);
    for (int i=0; i<args.length; i++) 
      System.out.println(args[i]);
  }
}