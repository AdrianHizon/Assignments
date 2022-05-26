// CLASS: GameAI
//
// Author: Adrian Hizon, #7867173
//
// REMARKS: Abstract class that represents the AI that will
// 			be played against during the poker game
//
//-----------------------------------------
public abstract class GameAI 
{
	private String name;
	public abstract void selectCards(Handable hand);
	
	public GameAI(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
