public class RomanNumeral {
	/**
	 * INVARIANT (1) one of romanValueValid and characterSetValid is always true
	 * 
	 * (2) if romanValueValid and characterSetValid are both true then
	 * romanValue and the combination of ones,fives,tens,...,thousands represent
	 * the same roman numeral
	 * 
	 * (3) ones is string of 'I's fives is string of 'V's tens is string of 'X's
	 * fifties is string of 'L's hundreds is string of 'C's fivehundreds is
	 * string of 'D's thousands is string of 'M's
	 */
	private boolean romanValueValid = false;
	private String romanValue = "";
	private boolean characterSetValid = false;
	private String ones = "";
	private String fives = "";
	private String tens = "";
	private String fifties = "";
	private String hundreds = "";
	private String fivehundreds = "";
	private String thousands = "";

	/**
	 * Constructor for objects of class RomanNumeral
	 */
	public RomanNumeral(String s) {
		romanValue = s;
		romanValueValid = true;
	}

	private RomanNumeral(String ones, String fives, String tens,
			String fifties, String hundreds, String fivehundreds,
			String thousands) {
		this.ones = ones;
		this.fives = fives;
		this.tens = tens;
		this.fifties = fifties;
		this.hundreds = hundreds;
		this.fivehundreds = fivehundreds;
		this.thousands = thousands;
		characterSetValid = true;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public RomanNumeral add(RomanNumeral other) {
		if (!characterSetValid)
			convertRoman2CharacterSet();
		if (!other.characterSetValid)
			other.convertRoman2CharacterSet();
		return new RomanNumeral(ones + other.ones, fives + other.fives, tens
				+ other.tens, fifties + other.fifties, hundreds
				+ other.hundreds, fivehundreds + other.fivehundreds, thousands
				+ other.thousands);
	}

	///////////////////////  Aflevering  //////////////////////////// 
	// Ideen er at lægge tallene sammen det antal gange, de ganges. Dvs. at 2*3 = 2+2+2
	
	public RomanNumeral multiply(RomanNumeral other) {
		if (!characterSetValid)
			convertRoman2CharacterSet();
		if (!other.characterSetValid)
			other.convertRoman2CharacterSet();
		
		int antal = other.ones.length()+other.fives.length()*5+other.tens.length()*10+other.fifties.length()*50+other.hundreds.length()*100+other.fivehundreds.length()*500+other.thousands.length()*1000;
		RomanNumeral result = new RomanNumeral("");
		for(int i = 0; i < antal; i++){
			result = result.add(this);
		}
		return result;
	}

	
	////////////////////////////////////////////////////////////////
	
	public String toString() {
		if (!romanValueValid)
			convertCharacterSet2Roman();
		return romanValue;
	}

	private void convertRoman2CharacterSet() {
		ones = "";
		fives = "";
		tens = "";
		fifties = "";
		hundreds = "";
		fivehundreds = "";
		thousands = "";
		int index = 0;
		while (index < romanValue.length()) {
			switch (romanValue.charAt(index++)) {
			case 'M':
				thousands += "M";
				break;
			case 'D':
				fivehundreds += "D";
				break;
			case 'C':
				if (index < romanValue.length()
						&& (romanValue.charAt(index) == 'M' || romanValue
								.charAt(index) == 'D')) {
					if (romanValue.charAt(index) == 'M')
						fivehundreds += "D";
					hundreds += "CCCC";
					index++;
				} else
					hundreds += "C";
				break;
			case 'L':
				fifties += "L";
				break;
			case 'X':
				if (index < romanValue.length()
						&& (romanValue.charAt(index) == 'C' || romanValue
								.charAt(index) == 'L')) {
					if (romanValue.charAt(index) == 'C')
						fifties += "L";
					tens += "XXXX";
					index++;
				} else
					tens += "X";
				break;
			case 'V':
				fives += "V";
				break;
			case 'I':
				if (index < romanValue.length()
						&& (romanValue.charAt(index) == 'X' || romanValue
								.charAt(index) == 'V')) {
					if (romanValue.charAt(index) == 'X')
						fives += "V";
					ones += "IIII";
					index++;
				} else
					ones += "I";
				break;
			default:
				throw new RuntimeException("Illegal roman numeral: "
						+ romanValue);
			}
		}
		characterSetValid = true;
	}

	private void convertCharacterSet2Roman() {
		while (ones.length() >= 5) {
			fives += "V";
			ones = ones.substring(5);
		}
		while (fives.length() >= 2) {
			tens += "X";
			fives = fives.substring(2);
		}
		while (tens.length() >= 5) {
			fifties += "L";
			tens = tens.substring(5);
		}
		while (fifties.length() >= 2) {
			hundreds += "C";
			fifties = fifties.substring(2);
		}
		while (hundreds.length() >= 5) {
			fivehundreds += "D";
			hundreds = hundreds.substring(5);
		}
		while (fivehundreds.length() >= 2) {
			thousands += "M";
			fivehundreds = fivehundreds.substring(2);
		}
		romanValue = thousands;
		if (hundreds.length() == 4) {
			if (fivehundreds.length() == 1)
				romanValue += "CM";
			else
				romanValue += "CD";
		} else
			romanValue += fivehundreds + hundreds;
		if (tens.length() == 4) {
			if (fifties.length() == 1)
				romanValue += "XC";
			else
				romanValue += "XL";
		} else
			romanValue += fifties + tens;
		if (ones.length() == 4) {
			if (fives.length() == 1)
				romanValue += "IX";
			else
				romanValue += "IV";
		} else
			romanValue += fives + ones;
	}

}