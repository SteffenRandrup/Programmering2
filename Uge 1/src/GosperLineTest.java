import java.awt.*;
public class GosperLineTest {
    private static final double SQRT_SEVEN =  2.64575;
    private static Crayon c;
  
    private static void rightGosperLine(int order, double len) {
	if (order == 0) c.move(len);
	else if (order > 0) {
	    rightGosperLine(order-1,len/SQRT_SEVEN); c.turn(60);
	    leftGosperLine(order-1,len/SQRT_SEVEN); c.turn(120);
	    leftGosperLine(order-1,len/SQRT_SEVEN); c.turn(-60);
	    rightGosperLine(order-1,len/SQRT_SEVEN); c.turn(-120);
	    rightGosperLine(order-1,len/SQRT_SEVEN); 
	    rightGosperLine(order-1,len/SQRT_SEVEN); c.turn(-60);
	    leftGosperLine(order-1,len/SQRT_SEVEN); c.turn(60);
	}
    } 
  
    private static void leftGosperLine(int order, double len) {
	if (order == 0) c.move(len);
	else if (order > 0) {
	    c.turn(-60);
            rightGosperLine(order-1,len/SQRT_SEVEN); c.turn(60);
	    leftGosperLine(order-1,len/SQRT_SEVEN);
	    leftGosperLine(order-1,len/SQRT_SEVEN); c.turn(120);
	    leftGosperLine(order-1,len/SQRT_SEVEN); c.turn(60);
	    rightGosperLine(order-1,len/SQRT_SEVEN); c.turn(-120);
	    rightGosperLine(order-1,len/SQRT_SEVEN); c.turn(-60);
	    leftGosperLine(order-1,len/SQRT_SEVEN);
	}
    } 
  
    public static void main(String[] args) {
	c = new Crayon(Color.red,1);
	c.jumpto(250,50);
	rightGosperLine(0,300); //c.turn(120);
	//	kochLine(4,300); c.turn(120);
	//	kochLine(4,300); c.turn(120);
    }
} 