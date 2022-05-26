// CLASS: Deck
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: Create a deck of cards to be used in the poker game
//
//-----------------------------------------

import java.util.LinkedList;
import java.util.Collections;

public class Deck implements Deckable
{
	private LinkedList<Cardable> cards; //= new LinkedList<Card>();
	private Cardable[] cardsArr;
	
	public Deck()
	{
		cards = new LinkedList<Cardable>();
		Cardable newCard;
		for(int i = 2; i <= 14; i++)
		{
//			newCard = new Card(i, Cardable.Suit.HEART);
			cards.add(new Card(i, Cardable.Suit.HEART));
			
		}
		for(int i = 2; i <= 14; i++)
		{
//			newCard = new Card(i, Cardable.Suit.DIAMOND);
			cards.add(new Card(i, Cardable.Suit.DIAMOND));
		}
		
		for(int i = 2; i <= 14; i++)
		{
//			newCard = new Card(i, Cardable.Suit.SPADE);
			cards.add(new Card(i, Cardable.Suit.SPADE));
		}
		
		for(int i = 2; i <= 14; i++)
		{
//			newCard = new Card(i, Cardable.Suit.CLUB);
			cards.add(new Card(i, Cardable.Suit.CLUB));
		}
	}
	

//------------------------------------------------------
// shuffle
//
// PURPOSE: This must shuffle the deck randomly.
//------------------------------------------------------
	public void shuffle()
	{
		Collections.shuffle(cards);
	}

//------------------------------------------------------
// returnToDeck
//
// PURPOSE: TThis must return the cards (Cardables) that were drawn previously (passed as a LinkedList<Cardable> parameter) back to the deck
//------------------------------------------------------
	public void returnToDeck(LinkedList<Cardable> discarded) 
	{
		Cardable topDiscarded;
		for(int i = 0; i < discarded.size(); i++)
		{
			topDiscarded = discarded.get(i);
			cards.add(topDiscarded);
		}
	}

//------------------------------------------------------
// drawACard
//
// PURPOSE: This deals the card (Cardable) that is at the top of the deck, either with the face up (true) or down (false).
//------------------------------------------------------
	public Cardable drawACard(boolean faceUp)
	{
		Cardable topCard = cards.pop();
		topCard.setFaceUp(faceUp);
		return topCard;
	}
	
//------------------------------------------------------
// print
//
// PURPOSE: Prints out a string representation of the deck
//------------------------------------------------------
	public void print()
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) instanceof Card)
			{
				System.out.println(((Card)cards.get(i)).getValue() + " " + cards.get(i).getSuit());
			}
		}
	}

}
