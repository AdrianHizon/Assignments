// CLASS: Card
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: Handles the game states of the poker game
/// 		and how to proceed the game at each state
//
//-----------------------------------------

import java.util.LinkedList;

public class GameLogic implements GameLogicable{
	private Deckable gameDeck;
	private Handable humanHand;
	private Handable cpuHand;
	private LinkedList<Cardable> humanDiscarded;
	private LinkedList<Cardable> cpuDiscarded;
	private int currState;
	private int gameNum;
	private int humanWins;
	private int cpuWins;
	private GameAI cpuAI;
	
	public GameLogic()
	{
		gameDeck = new Deck();
		gameDeck.shuffle();
		humanHand = new Hand(gameDeck, true);
		cpuHand = new Hand(gameDeck, false);
		currState = 0;
		gameNum = 1;
		humanWins = 0;
		cpuWins = 0;
		//Uncomment the AI that you want to test
		cpuAI = new RandomAI(); 
//		cpuAI = new SmartAI(); 
		
	}
	
	//------------------------------------------------------
	// getCpuHand
	//
	// PURPOSE: Returns the hand (Handable) of the CPU player.
	//------------------------------------------------------
	public Handable getCPUHand()
	{
		return cpuHand;
	}

	//------------------------------------------------------
	// getHumanHand
	//
	// PURPOSE: Returns the hand (Handable) of the human player.
	//------------------------------------------------------
	public Handable getHumanHand() 
	{
		return humanHand;
	}

	//------------------------------------------------------
	// nextState
	//
	// PURPOSE: The GUI will call this method to proceed to the next stage/state of the game. 
	//          The String[] parameter is an empty array, which the method can fill up with messages 
	//          that will be displayed in the GUI to describe the current state of the game. 
	//          The size of this array is determined by the number of lines that can be displayed in the GUI, 
	//          and this is stored in PokerTableDisplay.NUM_MESSAGE_ROWS. It is set to 4 for this assignment (4 lines max). 
	//			Leaves empty rows (where nothing should be displayed) to null.
	// 			The method returns a boolean that indicates if the proceed button in the GUI should be enabled (return true) or not (return false). 
	//			This was done to get more flexibility in the GUI, but is not really useful currently. You can just return true all the time.
	//------------------------------------------------------
	public boolean nextState(String[] messages) 
	{
		if(currState == 0)
		{
			humanHand.showAllCards();
			for(int i = 0; i < Handable.HAND_SIZE; i++)
			{
				humanHand.getCard(i).resetSelected();
			}
			messages[0] = "Beggining of game #" + gameNum;
			messages[1] = "Player 1, choose which cards to discard";
			messages[2] = "and click on the proceed button";
			messages[3] = null;
			currState++;
		}
		else if(currState == 1)
		{
			humanDiscarded = humanHand.discard();
			messages[0] = "Player 1 has discarded cards";
			messages[1] = cpuAI.getName() + " is thinking";
			messages[2] = null;
			messages[3] = null;
			for(int i = 0; i < Handable.HAND_SIZE; i++)
			{
				cpuHand.getCard(i).resetSelected();
			}
			cpuAI.selectCards(cpuHand);
			currState++;
		}
		else if(currState == 2)
		{
			cpuDiscarded = cpuHand.discard();
			messages[0] = cpuAI.getName() + " has discarded Cards";
			messages[1] = "Each player will be dealt the same number of cards they discarded";
			messages[2] = null;
			messages[3] = null;
			currState++;
		}
		else if(currState == 3)
		{
			humanHand.draw(gameDeck, true);
			cpuHand.draw(gameDeck, false);
			messages[0] = "Each player has been dealt new cards";
			messages[1] = "Click on proceed to see the winner";
			messages[2] = null;
			messages[3] = null;
			currState++;
		}
		else if(currState == 4)
		{
			cpuHand.showAllCards();
			messages[0] = cpuAI.getName() + " has: " + cpuHand.evaluateHand();
			messages[1] = "Player 1 has: " + humanHand.evaluateHand();
			int result = humanHand.compareTo(cpuHand);
			if(result == 1)
			{
				messages[2] = "Player 1 wins!!!";
				humanWins++;
			}
			else if(result == -1)
			{
				messages[2] = cpuAI.getName() + " wins!!!";
				cpuWins++;
			}
			else
			{
				messages[2] = "Message 3";
			}
			
			messages[3] = "Player 1 has won " + humanWins + " games. " + cpuAI.getName() + " has won " + cpuWins + " games.";
			currState++;
		}
		else if(currState == 5)
		{
			gameDeck.returnToDeck(humanHand.returnCards());
			gameDeck.returnToDeck(cpuHand.returnCards());
			gameDeck.returnToDeck(humanDiscarded);
			gameDeck.returnToDeck(cpuDiscarded);
			gameDeck.shuffle();
			humanHand.draw(gameDeck, false);
			cpuHand.draw(gameDeck, false);
			messages[0] = "Click on proceed to play a new game!";
			messages[1] = null;
			messages[2] = null;
			messages[3] = null;
			currState = 0;
			gameNum++;
		}
		return true;
	}

}
