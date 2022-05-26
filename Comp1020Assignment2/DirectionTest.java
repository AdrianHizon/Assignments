public class DirectionTest {

    public static void main(String[] args) {
        //***Direction class***
        try {
            System.out.println("*** Direction class ***");
            Direction d = new Direction(1, -1);
            String s = d.toString();
            System.out.println("Test 1 (should be <down left>): " + s);
            d = new Direction(-1, 0);
            s = d.toString();
            System.out.println("Test 2 (should be <up>): " + s);
            d = new Direction(0, 1);
            s = d.toString();
            System.out.println("Test 3 (should be <right>): " + s);
        } catch (NoSuchMethodError e) {
            System.out.println("Tests 1-3 failed: Method not named correctly.");
        } catch (Exception e) {
            System.out.println("Tests 1-3 failed: " + e.getMessage());
        }
    }
}


