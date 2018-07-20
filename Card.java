package Deck;

public class Card{
	
	public static final int DIAMONDS = 1;
	public static final int CLUBS = 2;
	public static final int HEARTS = 3;
	public static final int SPADES = 4;
	
	int cNumber;
	int cSuit;
	
	public Card(int number, int suit) {
		this.cNumber = number;
		this.cSuit = suit;
	}
	
	public int cNumber() {
		return cNumber;
	}
	
	public int cSuit() {
		return cSuit;
	}
	
	public String toString() {
		String s = "";
		switch (cNumber) {
			case 1: s+= "A"; break;
			case 2: s+= "2"; break;
			case 3: s+= "3"; break;
			case 4: s+= "4"; break;
			case 5: s+= "5"; break;
			case 6: s+= "6"; break;
			case 7: s+= "7"; break;
			case 8: s+= "8"; break;
			case 9: s+= "9"; break;
			case 10: s+= "10"; break;
			case 11: s+= "J"; break;
			case 12: s+= "Q"; break;
			case 13: s+= "K"; break;
		}
		switch (cSuit) {
		case DIAMONDS: s += " of Diamonds"; break;
		case CLUBS: s+= " of Clubs"; break;
		case HEARTS: s+= " of Hearts"; break;
		case SPADES: s+= " of Spades"; break;
		}
		return s;
	}
	public static void main(String[] args)  {
	
		
	}

}
