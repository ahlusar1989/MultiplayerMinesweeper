
package minesweeper;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
/**
 */
public class BoardTest {

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testConstructor() {
        Board board = new Board(3, 3,
                Arrays.asList(new Point(0, 0), new Point(2, 2)));
        System.out.println(board);

        Point p00 = new Point(0, 0);
        Point p01 = new Point(0, 1);
        Point p22 = new Point(2, 2);
        Assert.assertTrue(board.getBoard().get(p00).isContainBomb() &&
                board.getBoard().get(p22).isContainBomb());
        Assert.assertFalse(board.getBoard().get(p01).isContainBomb());


        board.setSquareDug(p00);
        System.out.println(board);
       Assert.assertTrue(board.getBoard().get(p00).isDug());
        Assert.assertFalse(board.getBoard().get(p00).isUntouched());


        board.setSquareFlagged(p01, true);
        System.out.println(board);
        Assert.assertTrue(board.getBoard().get(p01).isFlagged());

        board.removeBomb(p00);
        System.out.println(board);
        Assert.assertTrue(board.getBoard().get(p00).isContainBomb());
    }

    @Test
    public void testSquare() {
        Point p11 = new Point(1, 1);
        Square s1 = new Square(p11, false);
        Square s2 = new Square(p11, true);
        Square s3 = new Square(p11, true);
        s3.setDug();
        Square s4 = new Square(p11, false);
        s4.setFlagged(true);

        Assert.assertEquals("-", s1.toString());
        Assert.assertEquals("-", s2.toString());
        Assert.assertEquals("B", s3.toString());
        Assert.assertEquals("F", s4.toString());
    }

    @Test
    public void testPoint() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(0, 0);

        Assert.assertTrue(p1.equals(p2));
        Assert.assertFalse(p1.equals(p3));

        Assert.assertTrue(p1.hashCode() == p2.hashCode());
        Assert.assertFalse(p1.hashCode() == p3.hashCode());

        Assert.assertEquals("(1,1)", p1.toString());

    }

    @Test
    public void testBuildBoardFromFile() {

        String fileName = "test/resources/boards/board5";
        Board b = new Board(fileName);
        System.out.println(b.getBoardXSize() + ":" + b.getBoardYSize());
        System.out.println(b.getBoard());
        System.out.println(b.printBoard());

    }
}
