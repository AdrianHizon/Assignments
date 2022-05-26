public class DirectionListTest {
    public static void main(String[] args) {
        //***Direction class***
        try {
            System.out.println("\n*** DirectionList class ***");
            DirectionList d = new DirectionList();
            String s = d.toString();
            System.out.println("Test 4 (should be { } ): " + s);
            d.addDirection(new Direction(1, 0));
            s = d.toString();
            System.out.println("Test 5 (should be {<down>} ): " + s);
            d.addDirection(new Direction(0, -1));
            d.addDirection(new Direction(-1, 1));
            s = d.toString();
            System.out.println("Test 6 (should be {<down>,<left>,<up right>} ): " + s);
            System.out.println("Test 7 (should be 3 ): " + d.length());
            System.out.println("Test 8 (should be <up right> ): " + d.getDirection(2));
            DirectionList x = DirectionList.allDirections();
            System.out.println("Test 9 (should be all 8 directions ): " + x);
        } catch (NoSuchMethodError e) {
            System.out.println("Tests 4-9 failed: Method not named correctly.");
        } catch (Exception e) {
            System.out.println("Tests 4-9 failed: " + e.getMessage());
        }
    }
}
