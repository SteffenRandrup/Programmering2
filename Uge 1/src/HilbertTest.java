import java.awt.*;

public class HilbertTest {
	private static Crayon pencil = new Crayon(Color.black, 1);

	private static void west(int n, double len) {
		if (n > 0) {
			south(n - 1, len);
			pencil.turnto(180);
			pencil.move(len);
			west(n - 1, len);
			pencil.turnto(90);
			pencil.move(len);
			west(n - 1, len);
			pencil.turnto(0);
			pencil.move(len);
			north(n - 1, len);
		}
	}

	private static void north(int n, double len) {
		if (n > 0){
			
			west(n-1, len);
			pencil.turnto(270);
			pencil.move(len);
			north(n-1,len);
			pencil.turnto(0);
			pencil.move(len);
			north(n-1,len);
			pencil.turnto(90);
			pencil.move(len);
			east(n-1,len);
			
		}
		
	}

	private static void east(int n, double len) { 
		if (n > 0){
			
			north(n-1, len);
			pencil.turnto(20);
			pencil.move(len);
			east(n-1,len);
			pencil.turnto(-90);
			pencil.move(len);
			east(n-1,len);
			pencil.turnto(180);
			pencil.move(len);
			south(n-1,len);
			
		}
		
	}

	private static void south(int n, double len) {
		if (n > 0){
			
			east(n-1, len);
			pencil.turnto(90);
			pencil.move(len);
			south(n-1,len);
			pencil.turnto(-180);
			pencil.move(len);
			south(n-1,len);
			pencil.turnto(270);
			pencil.move(len);
			west(n-1,len);
			
		}
	}

	public static void main(String[] args) {
		pencil.jumpto(100, 50);
		west(1, 80 / (2 - 1));
		pencil.jumpto(200, 50);
		west(2, 80 / (4 - 1));
		pencil.jumpto(300, 50);
		west(3, 80 / (8 - 1));
		pencil.jumpto(400, 50);
		west(4, 80 / (16 - 1));
	}
}