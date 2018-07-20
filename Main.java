package Deck;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Deck{

	//Player Wallet
	public static int pWallet = 200;
	public static int pBet = 0;
	public int pSum;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deck playingCards = new Deck();
		Main actions = new Main();
		 
		/* #########################Testing Testing##########################
		shuffles and displays all cards
				playingCards.shuffle(cards);
			    for (Card i : cards) {
			          System.out.println(i);
			     }
				
				Dealing Tester
				int choice = 1;
			    while(choice==1) {
			    	System.out.println(playingCards.deal());
			    	Scanner yourDeal = new Scanner(System.in);
			    	System.out.println("Deal? 1=Deal");
			    	choice = yourDeal.nextInt();
			    	System.out.println(cardsInDeck);
			}
			***************************Testing Testing************************ */
		playingCards.shuffle(cards);
		boolean playOn = true;
		

		System.out.println("Welcome to Black Jack. You start with $200");
		
		while(playOn=true) {
			
			System.out.println("How much money would you like to bet?");
			Scanner yourBet = new Scanner(System.in);
			pBet = yourBet.nextInt();
		
			//Dealer's starting hand
			playingCards.Dealerdeal(); 
			System.out.println("The Dealer's exposed card is " + playingCards.Dealerdeal());
			
			System.out.println("your cards are " + playingCards.deal() + " and " + playingCards.deal());
			
			playingCards.play();
			if(pWin) {
				pWallet += pBet;
				System.out.println("you have $" + pWallet + " left.");
			}else {
				pWallet -= pBet;
				System.out.println("you have $" + pWallet + " left.");
			}
			System.out.println("Play Again? (yes or no)");
			Scanner yourChoice = new Scanner(System.in);
			String choice = yourChoice.nextLine();
			switch(choice) {
			case "yes": break;
			case "no": System.out.println("Game Over"); playOn = false; break;
			}
			
		}

}
}