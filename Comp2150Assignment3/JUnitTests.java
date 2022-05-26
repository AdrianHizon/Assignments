import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JUnitTests {

    @Test
    public void test1() 
	{
		Cardable[] cards1 = {new Card(2, Cardable.Suit.CLUB), new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.CLUB), new Card(4, Cardable.Suit.CLUB), new Card(2, Cardable.Suit.DIAMOND)};
		TestableHand th1 = new Hand();
		th1.addCards(cards1);
		
		Cardable[] cards2 = {new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.DIAMOND)};
		TestableHand th2 = new Hand();
		th2.addCards(cards2);
		
		assertTrue(th1.compareTo(th2) < 0, "Straight beats Three of a kind.");
    }
    
    @Test
    public void testStraightFlush()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable straightFlush2[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable straightFlush3[] = {new Card(10, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(12, Cardable.Suit.HEART), new Card(13, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable straightFlush4[] = {new Card(5, Cardable.Suit.CLUB), new Card(6, Cardable.Suit.CLUB), new Card(7, Cardable.Suit.CLUB), new Card(8, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.CLUB)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush2[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.CLUB), new Card(4, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.CLUB), new Card(14, Cardable.Suit.CLUB)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand straightFlushHand = new Hand();
    	straightFlushHand.addCards(straightFlush);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush2);
    	
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a straight flush with a lower high card");
    	
    	testHand = new Hand();
    	testHand.addCards(straightFlush3);
    	assertTrue(straightFlushHand.compareTo(testHand) < 0, "Straight flush loses to a straight flush with a higher high card");
    	
    	testHand = new Hand();
    	testHand.addCards(straightFlush4);
    	assertTrue(straightFlushHand.compareTo(testHand) == 0, "Straight flush ties with straight flush with the same high card");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(straightFlushHand.compareTo(testHand) > 0, "Straight flush beats a high card");
    	

    	//Testing low straight flush
    	TestableHand lowStrFlushHand = new Hand();
    	lowStrFlushHand.addCards(lowStraightFlush);
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush2);
    	assertTrue(lowStrFlushHand.compareTo(testHand) == 0, "Low straight flush ties with another low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(lowStrFlushHand.compareTo(testHand) > 0, "Low straight flush beats a high card");
    }
    
    @Test
    public void testFourOfAKind()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fourOfAKind2[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fourOfAKind3[] = {new Card(5, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand fourHand = new Hand();
    	fourHand.addCards(fourOfAKind);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(fourHand.compareTo(testHand) < 0, "Four of a kind loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(fourHand.compareTo(testHand) < 0, "Four of a kind loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind2);
    	assertTrue(fourHand.compareTo(testHand) < 0, "Four of a kind loses to a four of a kind with higher value");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind3);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a four of a kind with lower value");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(fourHand.compareTo(testHand) > 0, "Four of a kind beats a high card");
    }
    
    @Test
    public void testFullHouse()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse2[] = {new Card(14, Cardable.Suit.CLUB), new Card(14, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable fullHouse3[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand fullHouseHand = new Hand();
    	fullHouseHand.addCards(fullHouse);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(fullHouseHand.compareTo(testHand) < 0, "Full House loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(fullHouseHand.compareTo(testHand) < 0, "Full House loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(fullHouseHand.compareTo(testHand) < 0, "Full House loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse2);
    	assertTrue(fullHouseHand.compareTo(testHand) < 0, "Full House loses a full house with a higher value three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse3);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a full house with a lower value three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(fullHouseHand.compareTo(testHand) > 0, "Full House beats a high card");
    }
    
    @Test
    public void testFlush()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable flush2[] = {new Card(13, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(5, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE)};
    	Cardable flush3[] = {new Card(11, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(5, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE)};
    	Cardable flush4[] = {new Card(12, Cardable.Suit.SPADE), new Card(6, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(5, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE)};
    	Cardable flush5[] = {new Card(12, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(4, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE)};
    	Cardable flush6[] = {new Card(12, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(5, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand flushHand = new Hand();
    	flushHand.addCards(flush);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(flushHand.compareTo(testHand) < 0, "Flush loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(flushHand.compareTo(testHand) < 0, "Flush loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(flushHand.compareTo(testHand) < 0, "Flush loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(flushHand.compareTo(testHand) < 0, "Flush loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush2);
    	assertTrue(flushHand.compareTo(testHand) < 0, "Flush loses to a flush with a higher value card");
    	
    	testHand = new Hand();
    	testHand.addCards(flush3);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a flush with a lower value card");
    	
    	testHand = new Hand();
    	testHand.addCards(flush4);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a flush with a lower value 4th card");
    	
    	testHand = new Hand();
    	testHand.addCards(flush5);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a flush with a lower value 5th card");
    	
    	testHand = new Hand();
    	testHand.addCards(flush6);
    	assertTrue(flushHand.compareTo(testHand) == 0, "Flush ties a flush with the same values");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(flushHand.compareTo(testHand) > 0, "Flush beats a high card");
    }
    
    @Test 
    public void testStraight()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(5, Cardable.Suit.CLUB), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable straight2[] = {new Card(6, Cardable.Suit.CLUB), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART)};
    	Cardable straight3[] = {new Card(5, Cardable.Suit.CLUB), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART)};
    	Cardable straight4[] = {new Card(5, Cardable.Suit.CLUB), new Card(6, Cardable.Suit.DIAMOND), new Card(7, Cardable.Suit.DIAMOND), new Card(8, Cardable.Suit.DIAMOND), new Card(9, Cardable.Suit.DIAMOND)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable lowStraight2[] = {new Card(2, Cardable.Suit.DIAMOND), new Card(3, Cardable.Suit.CLUB), new Card(4, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.CLUB), new Card(14, Cardable.Suit.CLUB)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand straightHand = new Hand();
    	straightHand.addCards(straight);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(straightHand.compareTo(testHand) < 0, "Straight loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(straightHand.compareTo(testHand) < 0, "Straight loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(straightHand.compareTo(testHand) < 0, "Straight loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(straightHand.compareTo(testHand) < 0, "Straight loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(straightHand.compareTo(testHand) < 0, "Straight loses to a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight2);
    	assertTrue(straightHand.compareTo(testHand) < 0, "Straight loses a straight with higher value high card");
    	
    	testHand = new Hand();
    	testHand.addCards(straight3);
    	assertTrue(straightHand.compareTo(testHand) > 0, "Straight beats a straight with a lower value high card");
    	
    	testHand = new Hand();
    	testHand.addCards(straight4);
    	assertTrue(straightHand.compareTo(testHand) == 0, "Straight ties a straight with the same value high card");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(straightHand.compareTo(testHand) > 0, "Straight beats a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(straightHand.compareTo(testHand) > 0, "Straight beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(straightHand.compareTo(testHand) > 0, "Straight beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(straightHand.compareTo(testHand) > 0, "Straight beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(straightHand.compareTo(testHand) > 0, "Straight beats a high card");
    	
    	//Testing low straight
    	TestableHand lowStraightHand = new Hand();
    	lowStraightHand.addCards(lowStraight);
    	
    	testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(lowStraightHand.compareTo(testHand) < 0, "Low straight loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(lowStraightHand.compareTo(testHand) < 0, "Low straight loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(lowStraightHand.compareTo(testHand) < 0, "Low straight loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(lowStraightHand.compareTo(testHand) < 0, "Low straight loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(lowStraightHand.compareTo(testHand) < 0, "Low straight House beats a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(lowStraightHand.compareTo(testHand) < 0, "Low straight loses to a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight2);
    	assertTrue(lowStraightHand.compareTo(testHand) == 0, "Low straight ties with another low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(lowStraightHand.compareTo(testHand) > 0, "Low straight beats a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(lowStraightHand.compareTo(testHand) > 0, "Low straight beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(lowStraightHand.compareTo(testHand) > 0, "Low straight beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(lowStraightHand.compareTo(testHand) > 0, "Low straight beats a high card");
    }
    
    @Test 
    public void testThreeOfAKind()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable threeOfAKind2[] = {new Card(14, Cardable.Suit.CLUB), new Card(14, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable threeOfAKind3[] = {new Card(4, Cardable.Suit.CLUB), new Card(4, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand threeHand = new Hand();
    	threeHand.addCards(threeOfAKind);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind2);
    	assertTrue(threeHand.compareTo(testHand) < 0, "Three of a kind loses to a three of a kind with a higher value");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind3);
    	assertTrue(threeHand.compareTo(testHand) > 0, "Three of a kind beats a three of a kind with a lower value");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(threeHand.compareTo(testHand) > 0, "Three of a kind beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(threeHand.compareTo(testHand) > 0, "Three of a kind beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(threeHand.compareTo(testHand) > 0, "Three of a kind beats a high card");
    }
    
    @Test
    public void testTwoPairs()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable twoPairs2[] = {new Card(13, Cardable.Suit.CLUB), new Card(13, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable twoPairs3[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART)};
    	Cardable twoPairs4[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable twoPairs5[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(2, Cardable.Suit.HEART), new Card(2, Cardable.Suit.HEART)};
    	Cardable twoPairs6[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable twoPairs7[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable twoPairs8[] = {new Card(12, Cardable.Suit.DIAMOND), new Card(12, Cardable.Suit.SPADE), new Card(4, Cardable.Suit.SPADE), new Card(3, Cardable.Suit.SPADE), new Card(3, Cardable.Suit.SPADE)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};

    	TestableHand twoPairHand = new Hand();
    	twoPairHand.addCards(twoPairs);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs2);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a double pair with higher 1st pair value");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs3);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a double pair 2nd pair value");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs4);
    	assertTrue(twoPairHand.compareTo(testHand) > 0, "Double pair beats a double pair with lower 1st pair value");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs5);
    	assertTrue(twoPairHand.compareTo(testHand) > 0, "Double pair beats a double pair with lower 2nd pair value");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs6);
    	assertTrue(twoPairHand.compareTo(testHand) < 0, "Double pair loses to a double pair with higher value 5th card");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs7);
    	assertTrue(twoPairHand.compareTo(testHand) > 0, "Double pair beats a double pair with lower value 5th card");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs8);
    	assertTrue(twoPairHand.compareTo(testHand) == 0, "Double pair ties with a double pair with all cards the same value");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(twoPairHand.compareTo(testHand) > 0, "Double pair beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(twoPairHand.compareTo(testHand) > 0, "Double pair beats a high card");
    }
    
    @Test
    public void testOnePair()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable singlePair2[] = {new Card(7, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable singlePair3[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable singlePair4[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable singlePair5[] = {new Card(6, Cardable.Suit.CLUB), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable singlePair6[] = {new Card(6, Cardable.Suit.DIAMOND), new Card(3, Cardable.Suit.SPADE), new Card(5, Cardable.Suit.SPADE), new Card(7, Cardable.Suit.SPADE), new Card(6, Cardable.Suit.SPADE)};
    	Cardable highCard[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	
    	TestableHand onePairHand = new Hand();
    	onePairHand.addCards(singlePair);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair2);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a single pair with higher value");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair3);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a single pair with higher value 3rd card");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair4);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a single pair with higher value 4th card");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair5);
    	assertTrue(onePairHand.compareTo(testHand) < 0, "Single pair loses to a single pair with higher value 5th card");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair6);
    	assertTrue(onePairHand.compareTo(testHand) == 0, "Single pair ties with a single pair with all cards the same value");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard);
    	assertTrue(onePairHand.compareTo(testHand) > 0, "Single pair beats a high card");
    }
    
    @Test
    public void testHighCard()
    {
    	Cardable straightFlush[] = {new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART)};
    	Cardable lowStraightFlush[] = {new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable fourOfAKind[] = {new Card(9, Cardable.Suit.CLUB), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable fullHouse[] = {new Card(11, Cardable.Suit.CLUB), new Card(11, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable flush[] = {new Card(12, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART)};
    	Cardable straight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable lowStraight[] = {new Card(2, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(14, Cardable.Suit.HEART)};
    	Cardable threeOfAKind[] = {new Card(10, Cardable.Suit.CLUB), new Card(10, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable twoPairs[] = {new Card(12, Cardable.Suit.CLUB), new Card(12, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART), new Card(3, Cardable.Suit.HEART)};
    	Cardable singlePair[] = {new Card(6, Cardable.Suit.CLUB), new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART)};
    	Cardable highCard[] = {new Card(3, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART)};
    	Cardable highCard2[] = {new Card(3, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(12, Cardable.Suit.HEART)};
    	Cardable highCard3[] = {new Card(3, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(10, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART)};
    	Cardable highCard4[] = {new Card(3, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.HEART), new Card(8, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART)};
    	Cardable highCard5[] = {new Card(3, Cardable.Suit.CLUB), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART)};
    	Cardable highCard6[] = {new Card(4, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.HEART), new Card(7, Cardable.Suit.HEART), new Card(9, Cardable.Suit.HEART), new Card(11, Cardable.Suit.HEART)};
    	Cardable highCard7[] = {new Card(3, Cardable.Suit.CLUB), new Card(5, Cardable.Suit.DIAMOND), new Card(7, Cardable.Suit.DIAMOND), new Card(9, Cardable.Suit.DIAMOND), new Card(11, Cardable.Suit.DIAMOND)};
    	
    	TestableHand highHand = new Hand();
    	highHand.addCards(highCard);
    	
    	TestableHand testHand = new Hand();
    	testHand.addCards(straightFlush);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraightFlush);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a low straight flush");
    	
    	testHand = new Hand();
    	testHand.addCards(fourOfAKind);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a four of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(fullHouse);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a full house");
    	
    	testHand = new Hand();
    	testHand.addCards(flush);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a flush");
    	
    	testHand = new Hand();
    	testHand.addCards(straight);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a straight");
    	
    	testHand = new Hand();
    	testHand.addCards(lowStraight);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a low straight");
    	
    	testHand = new Hand();
    	testHand.addCards(threeOfAKind);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a three of a kind");
    	
    	testHand = new Hand();
    	testHand.addCards(twoPairs);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card beats a double pair");
    	
    	testHand = new Hand();
    	testHand.addCards(singlePair);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card beats a single pair");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard2);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a high card loses to high card with higher value");

    	testHand = new Hand();
    	testHand.addCards(highCard3);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a high card with higher value 2nd card");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard4);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a high card with higher value 3rd card");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard5);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a high card with higher value 4th card");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard6);
    	assertTrue(highHand.compareTo(testHand) < 0, "High card loses to a high card wiht higher value 5th card");
    	
    	testHand = new Hand();
    	testHand.addCards(highCard7);
    	assertTrue(highHand.compareTo(testHand) == 0, "High card ties a high card with all cards the same value");
    }
}
