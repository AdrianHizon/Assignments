// CLASS: RandomAI
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: AI that makes random choices during the poker game
//
//-----------------------------------------
public class RandomAI extends GameAI
{
	public RandomAI()
	{
		super("Dumb CPU");
	}
	
	//------------------------------------------------------
    // selectCards
    //
    // PURPOSE: Selects cards to discard at random
    // PARAMETERS: Receives the hand that it has during the poker game
    //------------------------------------------------------
	public void selectCards(Handable hand)
	{
		int selectChance;
		for(int i = 0; i < Handable.HAND_SIZE; i++)
		{
			selectChance = (int)(Math.random() * 2);
			if(selectChance == 1)
			{
				hand.getCard(i).switchSelectedState();
			}
		}
	}
}
