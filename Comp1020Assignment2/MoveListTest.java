public class MoveListTest {
    public static void main(String[] args) {
        try{
            System.out.println("\n*** MoveList class ***");
            MoveList ml = new MoveList();
            String s = ml.toString();
            System.out.println("Test 12 (should be no moves printed ):\n"+s);
            System.out.println("Test 13 (should be true ):"+ml.isEmpty());
            DirectionList d = new DirectionList();
            d.addDirection(new Direction(1,0));
            Move m = new Move(2,3,d);
            ml.addMove(m);
            s = ml.toString();
            System.out.println("Test 14 (should be one move printed} ):\n"+s);
            System.out.println("Test 15 (should be false ):"+ml.isEmpty());
            d = new DirectionList();
            d.addDirection(new Direction(0,1));
            m = new Move(1,0,d);
            ml.addMove(m);
            d = new DirectionList();
            d.addDirection(new Direction(-1,1));
            m = new Move(4,5,d);
            ml.addMove(m);
            d = new DirectionList();
            d.addDirection(new Direction(0,-1));
            m = new Move(6,3,d);
            ml.addMove(m);
            s = ml.toString();
            System.out.println("Test 16 (should be 4 different moves printed} ):\n"+s);
            System.out.println("Test 17 (should be 6 of the above moves at random)} ):");
            for(int i=0; i<6; i++)
                System.out.println(ml.randomMove());
        }
        catch(NoSuchMethodError e){
            System.out.println("Tests 12-17 failed: Method not named correctly.");}
        catch(Exception e){
            System.out.println("Tests 12-17 failed: "+e.getMessage());
        }
    }
}
