public class MoveTest {
    public static void main(String[] args) {
        try{
            System.out.println("\n*** Move class ***");
            DirectionList d = new DirectionList();
            d.addDirection(new Direction(1,-1));
            Move m = new Move(2,3,d);
            String s = m.toString();
            System.out.println("Test 10 (should be (2,3) flips directions {<down left>} ):\n      "+s);
            d.addDirection(new Direction(0,1));
            s = m.toString();
            System.out.println("Test 11 (should be (2,3) flips directions {<down left>,<right>} ):\n      "+s);
        }
        catch(NoSuchMethodError e){
            System.out.println("Tests 10-11 failed: Method not named correctly.");}
        catch(Exception e){
            System.out.println("Tests 10-11 failed: "+e.getMessage());
        }
    }
}
