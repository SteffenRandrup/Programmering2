
public class Card implements Comparable<Card>{
	
	Suit suit;
	Rank rank;
	
	public Card(Suit s, Rank r){
		
		suit = s;
		rank = r;
	}

	@Override
	public int compareTo(Card c) {
		
		int svar = 	rank.compareTo(c.getRank());
		if (svar == 0){
			svar = suit.compareTo(c.getSuit());
		}
		return svar;
	}
	
	@Override
	public String toString(){
		
		return suit.toString()+" "+rank.toString();
	}
	
	@Override
	public boolean equals(Object other){
		
		if(this == other) return true;
		if(other == null) return false;
		if(getClass() != other.getClass()) return false;
		
//		if(this.getClass() == other.getClass() && this.compareTo((Card) other)==0){
//			return true;
//		}
//		return false;
		
		if(compareTo((Card) other) == 0) return true;
		
		return false;
		
	}
	
	@Override
	public int hashCode(){
		
//		String s = toString();
//		int hash = 0;
//		for (int i = 0; i<s.length(); i++){
//			hash = 13*rank.hashCode() + 11*suit.hashCode();
//		}
//		return hash;
		
		return 11 * rank.hashCode() + 13 * suit.hashCode();
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public Rank getRank(){
		return rank;
	}
	
}
