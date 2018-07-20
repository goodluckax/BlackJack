package Deck;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Main extends Deck implements ActionListener{

	//Player Wallet
	public static int pWallet = 200;
	public static int pBet = 0;
	public int pSum;
	
    int cash = 0;
	
	private static final long serialVersionUID = 1L;
    //default serial version ID no idea what it does but I think i need it???
	
    public int getStartingAmmt() {  //starting money can change according to andrew's values
    	int amnt = 200;
    	return amnt; 
    }
    
    public Main() {  // main frame
        super(); // title of tab thing
        setSize (800 ,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // default stuff
        
        //home screen stuff
        
        JPanel MainPanel = new JPanel();
        MainPanel.setSize(800, 600);
        MainPanel.setLocation(0, 0);
        MainPanel.setLayout(null);
        MainPanel.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(MainPanel); 
        
        JLabel title = new JLabel("BlackJack", JLabel.CENTER);
        title.setSize(150,70);
        title.setLocation(320,110); // i hate coordinates
        title.setFont(new Font("Serif", Font.PLAIN, 30));
        MainPanel.add (title);
        
        JButton play = new JButton("Play");
        play.setActionCommand("startPlay"); //unnecessary for now may be useful later
        play.addActionListener(this);
        play.setSize(120,20);
        play.setLocation(335,250);
        MainPanel.add (play); 
        
        JButton setting = new JButton("Settings"); 
        setting.setActionCommand("goSetting"); 
        setting.addActionListener(this);
        setting.setSize(120,20);
        setting.setLocation(335,300);
        MainPanel.add (setting); 
        
        JButton instruction = new JButton("Instructions"); 
        instruction.setActionCommand("goInstructions"); 
        instruction.addActionListener(this);
        instruction.setSize(120,20);
        instruction.setLocation(335,350);
        MainPanel.add (instruction); 
        
        JButton close = new JButton("Exit"); 
        close.setActionCommand("quit"); 
        close.addActionListener(this);
        close.setSize(120,20);
        close.setLocation(335,400);
        MainPanel.add (close); 

    }
        
    //action listener stuff
    
    @Override     //implemented from action listener
    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        
        //play
        
        if (name.equals("startPlay")) {
           
        	System.out.println("Playing.");  //debug
            Container containPInt;  
            containPInt = getContentPane();
            containPInt.removeAll();
            JPanel GamePanel = new JPanel();
            GamePanel.setSize(800, 600);
            GamePanel.setLocation(0, 0); 
            GamePanel.setLayout(null);
            GamePanel.setBackground(Color.LIGHT_GRAY);
            containPInt.add(GamePanel);
            setVisible(true); 
            
            JButton newGame = new JButton("New Game"); 
            newGame.setActionCommand("startGame"); 
            newGame.addActionListener(this);
            newGame.setSize(100,20);
            newGame.setLocation(335,250);
            GamePanel.add (newGame); 
            
            JButton back = new JButton("Back"); 
            back.setActionCommand("back"); 
            back.addActionListener(this);
            back.setSize(100,20);
            back.setLocation(335,450);
            GamePanel.add (back); 
        }
        
        //Settings
        
        else if (name.equals("goSetting")) {
            
        	System.out.println("In settings."); //debug
            Container containS;  
            containS = getContentPane();
            containS.removeAll();
            JPanel SettingPanel = new JPanel();
            SettingPanel.setSize(800, 600);
            SettingPanel.setLocation(0, 0); 
            SettingPanel.setLayout(null);
            SettingPanel.setBackground(Color.LIGHT_GRAY);
            containS.add(SettingPanel);
            setVisible(true); 
            
            JLabel setting = new JLabel("Settings", JLabel.CENTER);
            setting.setSize(100,70);
            setting.setLocation(335,110);
            setting.setFont(new Font("Serif", Font.PLAIN, 30));
            SettingPanel.add (setting); 
            
            JCheckBox music = new JCheckBox("Music", true);
            music.setActionCommand("musicToggle");
            music.setSize(100,20);
            music.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
            music.setBackground(Color.LIGHT_GRAY);
            music.setLocation(335,250);
            SettingPanel.add (music);
            
            JCheckBox sound = new JCheckBox("Sound Effects", true);
            sound.setActionCommand("soundToggle");
            sound.setSize(200,20);
            sound.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
            sound.setBackground(Color.LIGHT_GRAY);
            sound.setLocation(335,310);
            SettingPanel.add (sound);
            
            JButton back = new JButton("Back"); 
            back.setActionCommand("back"); 
            back.addActionListener(this);
            back.setSize(100,20);
            back.setLocation(335,450);
            SettingPanel.add (back); 
        } 
        
        //instructions panel
        
        else if (name.equals("goInstructions")) {
            
            Container containI;  
            containI = getContentPane();
            containI.removeAll();
        	System.out.println("Instructions."); //debug
            JPanel InstructionPanel = new JPanel();
            InstructionPanel.setSize(800, 600);
            InstructionPanel.setLocation(0, 0); 
            InstructionPanel.setLayout(null);
            InstructionPanel.setBackground(Color.LIGHT_GRAY);
            containI.add(InstructionPanel);
            setVisible(true); 
            
            JLabel instructionTitle = new JLabel("Instructions");
            instructionTitle.setSize(140,40);
            instructionTitle.setLocation(320,70);
            instructionTitle.setFont(new Font("Serif", Font.PLAIN, 30));
            InstructionPanel.add (instructionTitle); 
            
            JLabel i1 = new JLabel("Premise");
            i1.setSize(140,40);
            i1.setLocation(40,120);
            i1.setFont(new Font("Serif", Font.PLAIN, 16));
            InstructionPanel.add (i1); 
            
            JLabel i2 = new JLabel("The basic premise of the game is that you want to have a hand value that is closer to 21 than that of the dealer, without");
            i2.setSize(700,40);
            i2.setLocation(40,140);
            i2.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i2); 
            
            JLabel i2a = new JLabel("going over 21");
            i2a.setSize(700,40);
            i2a.setLocation(40,155);
            i2a.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i2a); 
            
            JLabel i3 = new JLabel("Values");
            i3.setSize(140,40);
            i3.setLocation(40,195);
            i3.setFont(new Font("Serif", Font.PLAIN, 16));
            InstructionPanel.add (i3); 
            
            JLabel i4 = new JLabel("The cards from 2 through 9 are valued at their face value, ace can count as 1 or 11, and all other cards count as 10.");
            i4.setSize(700,40);
            i4.setLocation(40,215);
            i4.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i4); 
            
            JLabel i5 = new JLabel("Playing");
            i5.setSize(140,40);
            i5.setLocation(40,255);
            i5.setFont(new Font("Serif", Font.PLAIN, 16));
            InstructionPanel.add (i5); 
            
            JLabel i6 = new JLabel("You and the dealer are dealt two cards and then have the option to hit or stand. If you hit, you will be dealt another card.");
            i6.setSize(700,40);
            i6.setLocation(40,275);
            i6.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i6); 
            
            JLabel i6a = new JLabel("If you stand, you will not be dealt anymore cards and the dealer will proceed with his turn.");
            i6a.setSize(700,40);
            i6a.setLocation(40,290);
            i6a.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i6a); 
            
            JLabel i7 = new JLabel("Dealer");
            i7.setSize(140,40);
            i7.setLocation(40,330);
            i7.setFont(new Font("Serif", Font.PLAIN, 16));
            InstructionPanel.add (i7); 
            
            JLabel i8 = new JLabel("The dealer is dealt a faceup card and a facedown card. After you stand, the dealer will reveal his facedown card. The");
            i8.setSize(700,40);
            i8.setLocation(40,350);
            i8.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i8); 
            
            JLabel i8a = new JLabel("dealer keeps on hitting until his hand is greater than or equal to 17.");
            i8a.setSize(700,40);
            i8a.setLocation(40,365);
            i8a.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i8a); 
            
            JLabel i9 = new JLabel("Winning and Losing");
            i9.setSize(140,40);
            i9.setLocation(40,395);
            i9.setFont(new Font("Serif", Font.PLAIN, 16));
            InstructionPanel.add (i9); 
            
            JLabel i10 = new JLabel("If you draw a card that makes your hand total go over 21, you bust and lose. If the dealer busts then you ");
            i10.setSize(700,40);
            i10.setLocation(40,415);
            i10.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i10); 
            
            JLabel i10a = new JLabel("autoatically win your bet. If neither the player or dealer busts, they compare hands and whoever has the higher hand wins.");
            i10a.setSize(700,40);
            i10a.setLocation(40,430);
            i10a.setFont(new Font("Serif", Font.PLAIN, 14));
            InstructionPanel.add (i10a); 
            
            JButton back = new JButton("Back"); 
            back.setActionCommand("back"); 
            back.addActionListener(this);
            back.setSize(100,20);
            back.setLocation(335,520);
            InstructionPanel.add (back); 
        }
        
        //exit 
        
        else if (name.equals("quit")) {
            dispose(); //does what it sounds 
        }
        
        //listener for back button command this is a lot of stupid code
        
        else if (name.equals("back")) {
            Container containSBack; 
        	
            JPanel MainPanel = new JPanel();
            MainPanel.setSize(800, 600);
            MainPanel.setLocation(0, 0);
            MainPanel.setLayout(null);
            MainPanel.setBackground(Color.LIGHT_GRAY);
            this.getContentPane().add(MainPanel); 
            
            JLabel title = new JLabel("BlackJack", JLabel.CENTER);
            title.setSize(150,70);
            title.setLocation(320,110); 
            title.setFont(new Font("Serif", Font.PLAIN, 30));
            MainPanel.add (title);
            
            JButton play = new JButton("Play");
            play.setActionCommand("startPlay"); 
            play.addActionListener(this);
            play.setSize(120,20);
            play.setLocation(335,250);
            MainPanel.add (play); 
            
            JButton setting = new JButton("Settings"); 
            setting.setActionCommand("goSetting"); 
            setting.addActionListener(this);
            setting.setSize(120,20);
            setting.setLocation(335,300);
            MainPanel.add (setting); 
            
            JButton instruction = new JButton("Instructions"); 
            instruction.setActionCommand("goInstructions"); 
            instruction.addActionListener(this);
            instruction.setSize(120,20);
            instruction.setLocation(335,350);
            MainPanel.add (instruction); 
            
            JButton close = new JButton("Exit"); 
            close.setActionCommand("quit"); 
            close.addActionListener(this);
            close.setSize(120,20);
            close.setLocation(335,400);
            MainPanel.add (close);  
                       
            containSBack = getContentPane();
            containSBack.removeAll();
            containSBack.add(MainPanel);
            setVisible(true);  
           
        }
        

        
        
        /* actual important stuff
         * 
         * 
         * 
         * 
         * 
         * 
         * yes
         * i do need it this visible
         */
        
        else if(name.equals("startGame")) {
        	System.out.println("Game Started.");  //debug
            Container containG;  
            containG = getContentPane();
            containG.removeAll();
            setVisible(true);
            buildTable();
            repaint();
            getContentPane().setBackground(Color.GREEN);
        }
        
    }        
    
    public void buildTable() {
    	
    	System.out.println("building table"); //debug
    	
    	JButton buttonDeal, buttonHit, buttonStay, buttonDoubleDown, buttonSplit; 
    	JPanel userPane, dealerPane, userCardPane;
    	JLabel labelMoney, labelBet, labelHand, labelDealerHand;
    	
    	//dealer interface at top
    	
    	dealerPane = new JPanel(new GridLayout(2,4));
    	Border dealerStuff = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Dealer");
    	dealerPane.setBorder(dealerStuff);
    	dealerPane.setBackground(Color.gray);
    	buttonDeal = new JButton("Deal"); 
    	labelDealerHand = new JLabel("0");
        dealerPane.add(buttonDeal);
    	dealerPane.add(new JLabel(""));
    	dealerPane.add(new JLabel(""));
    	dealerPane.add(new JLabel(""));
    	dealerPane.add(new JLabel("Dealer Hand Value: "));
    	dealerPane.add(labelDealerHand);
    	dealerPane.add(new JLabel(""));
    	dealerPane.add(new JLabel(""));
//        buttonDeal.addActionListener(new Dealer());
    	
    	//cards, middle of the screen
    	
    	userCardPane = new JPanel(new GridLayout(3,7));
    	userCardPane.setBackground(Color.green);    
    	
    	//user, bottom of the screen
    	
    	userPane = new JPanel(new GridLayout(4,4));
    	Border userStuff = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "You");
    	userPane.setBorder(userStuff);
    	userPane.setBackground(Color.gray);
    	buttonHit = new JButton("Hit");
    	buttonStay = new JButton("Stand");
    	buttonDoubleDown = new JButton("Double Down");
    	buttonDoubleDown.setEnabled(false);
    	buttonSplit = new JButton("Split");
    	buttonSplit.setEnabled(false);
    	labelBet = new JLabel("0");
    	labelMoney = new JLabel("0");
    	labelHand = new JLabel("0");
    	userPane.add(new JLabel("Your Hand Value:"));
    	userPane.add(labelHand);
    	userPane.add(new JLabel("")); //honestly i am stupid but it works lol
    	userPane.add(new JLabel(""));
    	userPane.add(new JLabel("Your Total Money: "));
    	userPane.add(labelMoney);
    	userPane.add(new JLabel(""));
    	userPane.add(new JLabel(""));
    	userPane.add(new JLabel("Your Bet: "));
    	userPane.add(labelBet);
    	userPane.add(new JLabel(""));
    	userPane.add(new JLabel(""));
    	userPane.add(buttonHit);
    	userPane.add(buttonStay);
    	userPane.add(buttonDoubleDown);
    	userPane.add(buttonSplit);
    	buttonHit.addActionListener(new HitMe());
    	buttonStay.addActionListener(new Stay());
    	
    	
    	// begins card test, this is temp dunno if i will continue using
    	

    	JLabel cardLabel1;
    	cardLabel1 = new JLabel(""); 
    	Image card1 = new ImageIcon(this.getClass().getResource("/10D.png")).getImage().getScaledInstance(70, 107, 100);
    	cardLabel1.setIcon(new ImageIcon(card1));
    	userCardPane.add(cardLabel1);
    	
    	JLabel cardLabel2;
    	cardLabel2 = new JLabel(""); 
    	Image card2 = new ImageIcon(this.getClass().getResource("/2S.png")).getImage().getScaledInstance(70, 107, 100);
    	cardLabel2.setIcon(new ImageIcon(card2));
    	userCardPane.add(cardLabel2);
    	
    	JLabel cardLabel3;
    	cardLabel3 = new JLabel(""); 
    	Image card3 = new ImageIcon(this.getClass().getResource("/3H.png")).getImage().getScaledInstance(70, 107, 100);
    	cardLabel3.setIcon(new ImageIcon(card3));
    	userCardPane.add(cardLabel3);
    	
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	userCardPane.add(new JLabel(""));
    	
    	
    	//end card test
    	
    	
    	add(dealerPane, BorderLayout.NORTH);
    	add(userPane, BorderLayout.SOUTH);
    	add(userCardPane, BorderLayout.CENTER);
    	setVisible (true);
    	
    	//money, change according to andrew
    	
    	cash = getStartingAmmt();
    	labelMoney.setText(Integer.toString(cash));
    	
    	//bet, change according to andrew
    	
    	int bet = 10;
    	labelBet.setText(Integer.toString(bet));  
    }
    
    // hit stuff, change according to andrew
    
    class HitMe implements ActionListener{
    	
    	public void actionPerformed(ActionEvent arg0) {
    		
    	}
    }
    
    // stay stuff, change according to andrew
    
    class Stay implements ActionListener{
			
    	public void actionPerformed(ActionEvent arg0) {
				
		}
    		
    }
	
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
		
		while(playOn) {
			
			//Bet Amount, if Bet Amount > your Wallet, Request again
			boolean eMoney = true;
			while (eMoney) {
			System.out.println("How much money would you like to bet?");
			Scanner yourBet = new Scanner(System.in);
			pBet = yourBet.nextInt();
				if (pBet>pWallet)
					System.out.println("not enough money");
				if (pBet<=pWallet)
					eMoney = false;
			}
		
			//Dealer's starting hand
			playingCards.Dealerdeal(); 
			System.out.println("The Dealer's exposed card is " + playingCards.Dealerdeal());
			
			//Your Starting Hand
			System.out.println("your cards are " + playingCards.deal() + " and " + playingCards.deal());
			
			//Method for Playing
			playingCards.play();
			if(pWin) {
				pWallet += pBet;
				System.out.println("you have $" + pWallet + " left.");
			}else {
				pWallet -= pBet;
				System.out.println("you have $" + pWallet + " left.");
			}
			
			//Clear All Values from previous games
			pHand = ""; dHand=""; pCards.clear(); dCards.clear();
			
			//Scanner for Choice Whether to Play Again
			System.out.println("Play Again? (yes or no)");
			Scanner yourChoice = new Scanner(System.in);
			String choice = yourChoice.nextLine();
			
			//Loop GameOn or not 
			switch(choice) {
			case "yes": break;
			case "no": System.out.println("Game Over"); playOn = false; break;
			}
			
		}

}
}
