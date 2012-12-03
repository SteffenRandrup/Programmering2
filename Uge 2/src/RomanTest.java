public class RomanTest
{
    public static void main(String[] args)
    {
        
        RomanNumeral a = new RomanNumeral("XXXI");
        System.out.println("a: "+a);
        RomanNumeral b = a.add(a.add(a.add(a)));
        System.out.println("b: "+b);
        assert b.toString().equals("CXXIV");
        RomanNumeral c = b.add(b.add(b.add(b)));
        System.out.println("c: "+c);
        assert c.toString().equals("CDXCVI");
        RomanNumeral d = c.add(c.add(c.add(c)));
        System.out.println("d: "+d);
        assert d.toString().equals("MCMLXXXIV");
        RomanNumeral e = d.add(d.add(d.add(d)));
        System.out.println("e: "+e);
        assert e.toString().equals("MMMMMMMCMXXXVI");
        
        System.out.println(" ");
        RomanNumeral f = new RomanNumeral("IV");
        System.out.println("f: "+f); 
        RomanNumeral g = f.multiply(f);
        System.out.println("g: "+g);
        assert g.toString().equals("XVI");
        RomanNumeral h = g.multiply(new RomanNumeral("CXIV"));
        System.out.println("h: "+h);
        assert h.toString().equals("MDCCCXXIV");

	try {
	    assert false;
	    System.out.println("Please enable assertions!");
	}
	catch(AssertionError error) {
	    System.out.println("Success!");
	}
    }
}
