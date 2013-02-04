import java.util.TreeSet;


public class Hand {
	// TreeSet ser ud til at være et godt valg, fordi det har metoder, der returnerer true og false
	// på sammen måde som der kræves i opgaven. Og resten bliver ret nemt at løse
	
	private TreeSet<Card> ts = new TreeSet<Card>();
	
	public boolean add(Card c){	
		return ts.add(c);
	}
	
	public boolean remove(Card c){	
		return ts.remove(c);
	}
	
	public String toString(){
		// TreeSet sorterer efter naturlig orden. Ellers kan jeg vel kalde ts = new TreeSet<Card>(ts); for at få den sorteret
		
		String streng = "";
		
		for(Card c : ts){
			streng = streng + " " + c.toString();
		}
		
		return streng;
	}
	
	@Override
	public boolean equals(Object other){
		
		if(this == other) return true;
		if(other == null) return false;
		if(getClass() != other.getClass()) return false;
		Hand h = (Hand) other;
		return h.ts.equals(ts);
	}
	
	public int hashCode(){
		int hashCode = 0;
		for(Card c : ts){
			hashCode += c.hashCode();
		}
		return hashCode;
	}
	
}
