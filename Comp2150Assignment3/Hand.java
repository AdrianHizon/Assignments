// CLASS: Card
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: Create a hand of cards to be used in the poker game
//
//-----------------------------------------

import java.util.LinkedList;

public class Hand implements TestableHand
{
	private Cardable handArr[]; // = new Hand[HAND_SIZE];
	private int handValue;
	private int tiebreakers[];
	
	public Hand()
	{
		handArr = new Cardable[HAND_SIZE];
	}
	
	public Hand(Deckable deck, boolean faceUp)
	{
		handArr = new Cardable[HAND_SIZE];
		for(int i = 0; i < HAND_SIZE; i++)
		{
			handArr[i] = null;
		}
		draw(deck, faceUp);
		evaluateHand();
	}
	
	
	//------------------------------------------------------
    // compareTo
    //
    // PURPOSE: Compares this hand to another hand
    // PARAMETERS: Receives another hand to be compared to
    // Returns: Returns -1 if this hand is worth less than the other hand.
	//			Returns 1 if this hand is worth more than the other hand.
	//			Returns 0 if both hands are of equal value
    //------------------------------------------------------
	public int compareTo(Handable otherHand) 
	{
		int comparison = 0;
		if(otherHand instanceof Hand)
		{
			int otherValue = ((Hand)otherHand).handValue;
			int otherTiebreakers[] = ((Hand)otherHand).tiebreakers;
			if(this.handValue < otherValue)
			{
				comparison = -1;
			}
			else if(handValue > otherValue)
			{
				comparison = 1;
			}
			else
			{
				if(this.tiebreakers[0] < otherTiebreakers[0])
				{
					comparison = -1;
				}
				else if(this.tiebreakers[0] > otherTiebreakers[0])
				{
					comparison = 1;
				}
				else
				{
					if(this.tiebreakers[1] < otherTiebreakers[1])
					{
						comparison = -1;
					}
					else if(this.tiebreakers[1] > otherTiebreakers[1])
					{
						comparison = 1;
					}
					else
					{
						if(this.tiebreakers[2] < otherTiebreakers[2])
						{
							comparison = -1;
						}
						else if(this.tiebreakers[2] > otherTiebreakers[2])
						{
							comparison = 1;
						}
						else
						{
							if(this.tiebreakers[3] < otherTiebreakers[3])
							{
								comparison = -1;
							}
							else if(this.tiebreakers[3] > otherTiebreakers[3])
							{
								comparison = 1;
							}
							else
							{
								if(this.tiebreakers[4] < otherTiebreakers[4])
								{
									comparison = -1;
								}
								else if(this.tiebreakers[4] > otherTiebreakers[4])
								{
									comparison = 1;
								}
								else
								{
									comparison = 0;
								}
							}
						}
					}
				}
			}
		}
		return comparison;
	}
	
	//------------------------------------------------------
    // getCard
    //
    // PURPOSE: Returns the ith Cardable element of the hand.
    //------------------------------------------------------
	public Cardable getCard(int i) 
	{
		return handArr[i];
	}
	
	//------------------------------------------------------
    // draw
    //
    // PURPOSE: This should be called after the discard method (see below), 
	//			and replace all discarded cards with cards drawn from the Deckable 
	//			sent as a parameter (faceUp determines if the drawn cards should have the face up or down). 
    //------------------------------------------------------
	public void draw(Deckable d, boolean faceUp) 
	{
		for(int i = 0; i < HAND_SIZE; i++)
		{
			if(handArr[i] == null)
			{
				handArr[i] = d.drawACard(faceUp);
			}
		}
	}

	//------------------------------------------------------
    // showAllCards
    //
    // PURPOSE: Flips all cards (Cardables) of the hand so that they face up
    //------------------------------------------------------
	public void showAllCards() 
	{
		for(int i = 0; i < HAND_SIZE; i++)
		{
			handArr[i].setFaceUp(true);
		}
		
	}
	
	//------------------------------------------------------
    // discard
    //
    // PURPOSE: This method discards from the hand all the Cardables 
	// 			that have been selected  (that have selected state = true). 
	//			The method returns a LinkedList<Cardable> containing 
	//			all the cards that have been discarded from this hand.
    //------------------------------------------------------
	public LinkedList<Cardable> discard() 
	{
		LinkedList<Cardable> discarded = new LinkedList<Cardable>();
		for(int i = 0; i < HAND_SIZE; i++)
		{
			if(handArr[i].getSelected() == true)
			{
				handArr[i].resetSelected();
				discarded.add(handArr[i]);
				handArr[i] = null;
			}
		}
		return discarded;
	}

	//------------------------------------------------------
    // returnCards
    //
    // PURPOSE: This method will be called at the end of a round to empty the hand 
	//			(discard the full hand, not considering the selected state). 
	//			It returns a LinkedList<Cardable> containing all the cards that were in the hand
    //------------------------------------------------------
	public LinkedList<Cardable> returnCards() 
	{
		LinkedList<Cardable> returning = new LinkedList<Cardable>();
		for(int i = 0; i < HAND_SIZE; i++)
		{
			handArr[i].resetSelected();
			returning.add(handArr[i]);
			handArr[i] = null;
		}
		return returning;
	}
	
	//------------------------------------------------------
    // orderedCopy
    //
    // PURPOSE: Creates a copy of this hand that's ordered from lowest value to highest value
    // Returns: Returns the ordered copy of this hand
    //------------------------------------------------------
	public Cardable[] orderedCopy()
	{
		Cardable copy[] = new Cardable[HAND_SIZE];
		for(int i = 0; i < HAND_SIZE; i++)
		{
			copy[i] = handArr[i];
		}
		for(int i = 1; i < HAND_SIZE; i++)
		{
			int j = i - 1;
			if(copy[i] instanceof Card && copy[j] instanceof Card)
			{
				Cardable currCard = copy[i];
				int currVal = ((Card)currCard).getValue();
				while(j >= 0 && ((Card)copy[j]).getValue() > currVal)
				{
					copy[j + 1] = copy[j];
					j--;
				}
				copy[j + 1] = currCard;
			}
		}
		return copy;
	}

	//------------------------------------------------------
    // evaluateHand
    //
    // PURPOSE: This method evaluates what is in the hand,
	//			and returns a String description of 
	//			the best poker hand that can be made with these cards.
    //------------------------------------------------------
	public String evaluateHand() 
	{
		handValue = 0;
		tiebreakers = new int[HAND_SIZE];
		Cardable orderedHand[] = orderedCopy();
		String bestHand = null;
		if(findStraight(orderedHand))
		{
			bestHand = "Straight, " + cardValToString(tiebreakers[0]) + " high";
			if(findFlush(orderedHand))
			{
				bestHand = "Straight Flush, " + cardValToString(tiebreakers[0]) + " high";
			}
		}
		else if(findFour(orderedHand))
		{
			bestHand = "Four of a kind, " + cardValToString(tiebreakers[0]);
		}
		else if(findThree(orderedHand) && findPairs(orderedHand) == 3)
		{
			bestHand = "Full House, " + cardValToString(tiebreakers[0]);
		}
		else if(findFlush(orderedHand))
		{
			bestHand = "Flush, high " + cardValToString(tiebreakers[0]);
		}
		else if(findThree(orderedHand))
		{
			bestHand = "Three of a kind, " + cardValToString(tiebreakers[0]);
		}
		else if(findPairs(orderedHand) == 2)
		{
			bestHand  = "Two pairs, " + cardValToString(tiebreakers[1]) + " and " + cardValToString(tiebreakers[0]);
		}
		else if(findPairs(orderedHand) == 1)
		{
			bestHand = "One pair, " + cardValToString(tiebreakers[0]);
		}
		else
		{
			if(orderedHand[0] instanceof Card && orderedHand[1] instanceof Card && orderedHand[2] instanceof Card && orderedHand[3] instanceof Card && orderedHand[4] instanceof Card)
			{
				for(int i = 0; i < HAND_SIZE; i++)
				{
					tiebreakers[i] = ((Card)orderedHand[(HAND_SIZE - 1) - i]).getValue();
				}
			}
			bestHand = "High card, " + cardValToString(tiebreakers[0]);
		}
		return bestHand;
	}
	
	//------------------------------------------------------
    // cardValToString
    //
    // Returns: Returns a string representation of a given card's value
    //------------------------------------------------------
	private String cardValToString(int val)
	{
		String cardVal = "";
		if(val == 11)
		{
			cardVal = "J";
		}
		else if(val == 12)
		{
			cardVal = "Q";
		}
		else if(val == 13)
		{
			cardVal = "K";
		}
		else if(val == 14)
		{
			cardVal = "A";
		}
		else
		{
			cardVal = String.valueOf(val);
		}
		return cardVal;
	}
	
	//------------------------------------------------------
    // findFlush
    //
    // PURPOSE: Will attempt to find a flush or straight flush in a given hand
    // PARAMETERS: The received hand is expected to be ordered
	//			   from cards of lowest value to highest value
    // Returns: Returns true if a flush or straight flush is found
	// 			and properly sets this hand's value and any needed tiebreakers
    //------------------------------------------------------
	private boolean findFlush(Cardable copy[])
	{
		boolean flush = true;
		Cardable.Suit prevSuit = copy[0].getSuit();
		Cardable.Suit currSuit;
		for(int i = 1; i < HAND_SIZE; i++)
		{
			currSuit = copy[i].getSuit();
			if(currSuit != prevSuit)
			{
				flush = false;
			}
			prevSuit = currSuit;
		}
		if(flush == true)
		{
			if(handValue == 5)
			{
				handValue = 10;
			}
			else if(handValue == 4)
			{
				handValue = 9;
			}
			else
			{
				handValue = 6;
				if(copy[4] instanceof Card && copy[3] instanceof Card && copy[2] instanceof Card && copy[1] instanceof Card && copy[0] instanceof Card)
				{
					for(int i = 0; i < HAND_SIZE; i++)
					{
						tiebreakers[i] = ((Card)copy[(HAND_SIZE - 1) - i]).getValue();
					}
				}
			}
		}
		return flush;
	}
	
	//------------------------------------------------------
    // findStraight
    //
    // PURPOSE: Will attempt to find a straight in a given hand
    // PARAMETERS: The received hand is expected to be ordered
	//			   from cards of lowest value to highest value
    // Returns: Returns true if a straight is found
	// 			and properly sets this hand's value and any needed tiebreakers
    //------------------------------------------------------
	private boolean findStraight(Cardable copy[])
	{
		boolean straight = true;
		boolean lowStraight = false;
		int currValue = 0;
		int prevValue = 0;
		if(copy[0] instanceof Card)
		{
			prevValue = ((Card)copy[0]).getValue();
		}
		for(int i = 1; i < HAND_SIZE; i++)
		{
			if(copy[i] instanceof Card)
			{
				currValue = ((Card)copy[i]).getValue();
			}
			
			if(i == 4 && currValue == 14 && straight == true && prevValue == 5)
			{
				lowStraight = true;
			}
			
			if(currValue != (prevValue + 1))
			{
				straight = false;
			}
			
			prevValue = currValue;
		}
		if(straight == true)
		{
			handValue = 5;
			if(straight == true)
			{
				if(copy[HAND_SIZE - 1] instanceof Card)
				{
					tiebreakers[0] = ((Card)copy[HAND_SIZE - 1]).getValue();
				}
			}
		}
		if (lowStraight == true)
		{
			handValue = 4;
			if(copy[HAND_SIZE - 2] instanceof Card)
			{
				tiebreakers[0] = ((Card)copy[HAND_SIZE - 2]).getValue();
			}
		}
		return straight || lowStraight;
	}
	
	//------------------------------------------------------
    // findFour
    //
    // PURPOSE: Will attempt to find a four of a kind in a given hand
    // PARAMETERS: The received hand is expected to be ordered
	//			   from cards of lowest value to highest value
    // Returns: Returns true if a four of a kind is found
	// 			and properly sets this hand's value and any needed tiebreakers
    //------------------------------------------------------
	private boolean findFour(Cardable copy[])
	{
		boolean four = false;
		for(int i = 3; i < HAND_SIZE; i++)
		{
			if(copy[i] instanceof Card && copy[i - 1] instanceof Card && copy[i - 2] instanceof Card && copy[i - 3] instanceof Card)
			{
				if(((Card)copy[i]).getValue() == ((Card)copy[i - 1]).getValue() && ((Card)copy[i]).getValue() == ((Card)copy[i - 2]).getValue() && ((Card)copy[i]).getValue() == ((Card)copy[i - 3]).getValue())
				{
					four = true;
					tiebreakers[0] = ((Card)copy[i]).getValue();
				}
			}
		}
		if(four == true)
		{
			handValue = 8;
		}
		return four;
	}
	
	//------------------------------------------------------
    // findThree
    //
    // PURPOSE: Will attempt to find a three of a kind in a given hand
    // PARAMETERS: The received hand is expected to be ordered
	//			   from cards of lowest value to highest value
    // Returns: Returns true if a three of a kind is found
	// 			and properly sets this hand's value and any needed tiebreakers
    //------------------------------------------------------
	private boolean findThree(Cardable copy[])
	{
		boolean three = false;
		for(int i = 2; i < HAND_SIZE; i++)
		{
			if(copy[i] instanceof Card && copy[i - 1] instanceof Card && copy[i - 2] instanceof Card)
			{
				if(((Card)copy[i]).getValue() == ((Card)copy[i - 1]).getValue() && ((Card)copy[i]).getValue() == ((Card)copy[i - 2]).getValue())
				{
					three = true;
					tiebreakers[0] = ((Card)copy[i]).getValue();
				}
			}
		}
		if(three == true)
		{
			handValue = 3;
		}
		return three;
	}
	
	//------------------------------------------------------
    // findPairs
    //
    // PURPOSE: Will attempt to find pairs in a given hand
    // PARAMETERS: The received hand is expected to be ordered
	//			   from cards of lowest value to highest value.
    // Returns: Returns the number of pairs found
	// 			and properly sets this hand's value and any needed tiebreakers
    //------------------------------------------------------
	private int findPairs(Cardable copy[])
	{
		int pairs = 0;
		int pair1Index = 0;
		int pair2Index = 0;
		for(int i = 1; i < HAND_SIZE; i++)
		{
			if(copy[i] instanceof Card && copy[i - 1] instanceof Card)
			{
				if(((Card)copy[i]).getValue() == ((Card)copy[i - 1]).getValue())
				{
					pairs++;
					if(pairs == 1)
					{
						pair1Index = i;
					}
					else if(pairs == 2)
					{
						pair2Index = i;
					}
				}
			}
		}
		if(pairs == 1)
		{
			handValue = 1;
			if(copy[pair1Index] instanceof Card)
			{
				tiebreakers[0] = ((Card)copy[pair1Index]).getValue();
			}
			int j = 1;
			for(int i = HAND_SIZE - 1; i >= 0; i--)
			{
				if(i != pair1Index && i != (pair1Index - 1) && copy[i] instanceof Card)
				{
					tiebreakers[j] = ((Card)copy[i]).getValue();
					j++;
				}
			}
		}
		else if(pairs == 2)
		{
			handValue = 2;
			if(copy[pair1Index] instanceof Card && copy[pair2Index] instanceof Card)
			{
				tiebreakers[0] = ((Card)copy[pair2Index]).getValue();
				tiebreakers[1] = ((Card)copy[pair1Index]).getValue();
			}
			for(int i = 0; i < HAND_SIZE; i++)
			{
				if(i != pair1Index && i != (pair1Index - 1) && i != pair2Index && i != (pair2Index - 1))
				{
					if(copy[i] instanceof Card)
					{
						tiebreakers[2] = ((Card)copy[i]).getValue();
					}
				}
			}
		}
		else if(pairs == 3 && handValue == 3)
		{
			handValue = 7;
		}
		return pairs;
	}
	

	//------------------------------------------------------
    // addCards
    //
    // PURPOSE: Will add all the Cardables in the array to the hand.
	public void addCards(Cardable[] cards) 
	{
		for(int i = 0; i < HAND_SIZE; i++)
		{
			handArr[i] = cards[i];
		}
		evaluateHand();
	}
	
	public int getHandVal()
	{
		return handValue;
	}
	
	public int[] getTiebreakers()
	{
		return tiebreakers;
	}

	//------------------------------------------------------
    // print
    //
    // PURPOSE: Will print to the console a string representation of the Hand
    //------------------------------------------------------
	public void print()
	{
		for(int i = 0; i < HAND_SIZE; i++)
		{
			if(handArr[i] instanceof Card)
			{
				System.out.println(((Card)handArr[i]).getValue() + " " + handArr[i].getSuit());
			}
		}
	}
}
