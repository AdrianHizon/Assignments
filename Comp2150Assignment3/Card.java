// CLASS: Card
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: Create a card to be used in the poker game
//
//-----------------------------------------
public class Card implements Cardable
{
	private int value;
	private Suit currSuit;
	private boolean faceUp;
	private boolean selected;
	
	public Card(int value, Suit currSuit)
	{
		this.value = value;
		this.currSuit = currSuit;
		this.faceUp = false;
		this.selected = false;
	}
	
	public boolean getSelected() 
	{
		return selected;
	}

	public boolean getFaceUp() 
	{
		return faceUp;
	}

	public Cardable.Suit getSuit() 
	{
		return currSuit;
	}

	public void switchSelectedState() 
	{
		if(selected == false)
		{
			selected = true;
		}
		else
		{
			selected = false;
		}
	}

	public void resetSelected() 
	{
		this.selected = false;
	}

	public void setFaceUp(boolean faceUp) 
	{
		this.faceUp = faceUp;
	}
	
//------------------------------------------------------
// toString
//
// PURPOSE: Returns a string representation of the card
//------------------------------------------------------
	public String toString()
	{
		String cardNum;
		if(value == 11)
		{
			cardNum = "J";
		}
		else if(value == 12)
		{
			cardNum = "Q";
		}
		else if(value == 13)
		{
			cardNum = "K";
		}
		else if(value == 14)
		{
			cardNum = "A";
		}
		else
		{
			cardNum = String.valueOf(value);
		}
		char suitChar = 0;
		if(currSuit == Suit.HEART)
		{
			suitChar = '\u2665';
		}
		else if(currSuit == Suit.DIAMOND)
		{
			suitChar = '\u2666';
		}
		else if(currSuit == Suit.SPADE)
		{
			suitChar = '\u2660';
		}
		else if(currSuit == Suit.CLUB)
		{
			suitChar = '\u2663';
		}
		String str = cardNum + " " + suitChar;
		return str;
	}

	public int getValue()
	{
		return value;
	}
}
