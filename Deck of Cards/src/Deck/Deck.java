package Deck;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;


//pages.cs.wisc.edu/~hasti/cs302/examples/Deck/Deck.java

public class Deck extends JFrame{
	public static final int DECK_SIZE = 52;
	public static Card[] cards; // array holding all 52 cards
	private int cardsInDeck; // the current number of cards in the deck
	public static ArrayList<Integer>  pCards = new ArrayList<>();//player cards
	public static ArrayList<Integer>  dCards = new ArrayList<>();//dealer cards
	public static String pHand = "";
	public static String dHand = "";
	public static boolean pWin = true;
	public static int pAces = 0;
	public static int dAces = 0;

	public Deck() {
		cards = new Card[DECK_SIZE];
		cardsInDeck = DECK_SIZE;
		for (int i = 0; i < 13; i++) {
			cards[i] = new Card(i + 1, Card.DIAMONDS);
			cards[i + 13] = new Card(i + 1, Card.CLUBS);
			cards[i + 26] = new Card(i + 1, Card.HEARTS);
			cards[i + 39] = new Card(i + 1, Card.SPADES);
		}
	}
	
	public void Reset() {
		for (int i = 0; i < 13; i++) {
			cards[i] = new Card(i + 1, Card.DIAMONDS);
			cards[i + 13] = new Card(i + 1, Card.CLUBS);
			cards[i + 26] = new Card(i + 1, Card.HEARTS);
			cards[i + 39] = new Card(i + 1, Card.SPADES);
		}
	}	
	
	public Card deal() {
		if (cardsInDeck>0) {
		pHand = pHand + cards[0] + ", " ;
		Card TEMPCard = cards[0];
		if(cards[0].cNumber>10){
			cards[0].cNumber = 10;
			pCards.add(cards[0].cNumber);
		}else if(cards[0].cNumber==1){
			cards[0].cNumber = 11;
			pAces ++;
			pCards.add(cards[0].cNumber);
			}
		else {
			pCards.add(cards[0].cNumber);
		}
		for(int i=0;i<cardsInDeck;i++) {
			if (!(i==51)) {	
			cards[i] = cards[i+1];
			}
		}
		cards[cardsInDeck-1] = new Card(0,0);
		cardsInDeck--;
		return TEMPCard;}
		else {
		System.out.println("ERROR: No More Cards");
		return new Card(0,0);
		}
	}
	
	public Card Dealerdeal() {
		dHand = dHand + cards[0] + ", " ;
		Card TEMPCard = cards[0];
		if(cards[0].cNumber>10)
		{
			cards[0].cNumber = 10;
			dCards.add(cards[0].cNumber);
		}else if(cards[0].cNumber==1){
			cards[0].cNumber = 11;
			dAces ++;
			dCards.add(cards[0].cNumber);
			}
		else{
			dCards.add(cards[0].cNumber);
		}
		for(int i=0;i<cardsInDeck;i++) {
			if (!(i==51)) {
			cards[i] = cards[i+1];
			}
			}
		cards[cardsInDeck-1] = new Card(0,0);
		cardsInDeck--;
		return TEMPCard;
	}
	
	public static void swapCards(Card[] a, int i, int swapped) {
		Card swapper = a[i];
        a[i] = a[swapped];
        a[swapped] = swapper;
	}
	
	public void shuffle(Card[] a) {
		int n = a.length;
		Random random = new Random();
		random.nextInt(52);
		for (int i = 0; i<n; i++) {
		int swapped = i + random.nextInt(n - i);
		swapCards(a, i, swapped);
		}
	}

	public static int pSum() {
		int sum = 0;
		for(int i=0;i<pCards.size();i++) {
			sum = sum + pCards.get(i);
		}
		while (sum>21 && pAces>0){
			sum -= 10;
			pAces --;
		}
			
		return sum;
	}
	
	public int dSum() {
		int sum = 0;
		for(int i=0;i<dCards.size();i++) {
			sum = sum + dCards.get(i);
		}
		while (sum>21 && dAces>0){
			sum -= 10;
			dAces --;
		}
		return sum;
	}

	public void play() {
		System.out.println("hit? stay?");
		Scanner choice = new Scanner(System.in);
		String yourChoice = choice.nextLine();
		switch(yourChoice) {
		case "hit": hitMe(); break;
		case "stay": stay(); break;
		case "split": break;
		}
	}
	
	public void hitMe () {
		deal();
		System.out.println("your hand is now " + pHand);
		System.out.println("your total is now " + pSum());
		int bust = pSum();
		if(bust > 22) {
			System.out.println("Bust! you lose!");
			pWin = false;
		}else {
			play();
		}
	}
	
	public void stay() {

		boolean dPlay = true;
		while (dPlay) {
			if(dSum()< 17) {
				Dealerdeal();
				System.out.println("The dealer's hand is " + dHand);
			}else {
				dPlay = false;
				System.out.println("The dealer's hand is " + dHand);
			}
		}
		
		System.out.println("The dealer's total is " + dSum());
		if(dSum()>=pSum() && dSum()<=21) {
			System.out.println("The dealer wins!");
			pWin = false;
		}else {
			System.out.println("Dealer Busts! You win!");
			pWin = true;
		}
	}
	
	
}
