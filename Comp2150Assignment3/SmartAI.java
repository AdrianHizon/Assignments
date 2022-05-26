// CLASS: SmartAI
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: AI that makes slightly informed decisions
//			during the poker game
//
//-----------------------------------------

public class SmartAI extends GameAI
{
	public SmartAI()
	{
		super("Smart CPU");
	}
	
	//------------------------------------------------------
    // selectCards
    //
    // PURPOSE: Will select cards to discard while trying to 
	// 			keep pairs or three of a kinds intact
    // PARAMETERS: Receives the hand that it has during the poker game
    //------------------------------------------------------
	public void selectCards(Handable hand)
	{
		if(hand instanceof Hand)
		{
			hand.evaluateHand();
			int handValue = ((Hand)hand).getHandVal();
			int tiebreakers[] = ((Hand)hand).getTiebreakers();
			if(handValue == 0 || handValue == 1 || handValue == 3)
			{
				for(int i = 0; i < Handable.HAND_SIZE; i++)
				{
					if(hand.getCard(i) instanceof Card && ((Card)hand.getCard(i)).getValue() !=  tiebreakers[0])
					{
						hand.getCard(i).switchSelectedState();
					}
				}
			}
			else if(handValue == 2)
			{
				for(int i = 0; i < Handable.HAND_SIZE; i++)
				{
					if(hand.getCard(i) instanceof Card && ((Card)hand.getCard(i)).getValue() !=  tiebreakers[0] && ((Card)hand.getCard(i)).getValue() !=  tiebreakers[1])
					{
						hand.getCard(i).switchSelectedState();
					}
				}
			}
		}
	}
}
