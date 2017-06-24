
package minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 *
 */
public class Board {


    // Rep invariant:
    //   board as a grid of squares. Each square is either flagged , dug , or untouched .
    //   Each square also either contains a bomb, or does not contain a bomb.
    // Abstraction Function:
    //   represents a board for Minesweeper
    // Safety from rep exposure:
    //   All fields are private and elements of fields are immutable,
    //   methods will return a defensive copy.


    private static double BOMB_PROBABILITY = .25;
    private static String BOMB_SYMBOL = "1";

    private int boardXSize;
    private int boardYSize;
    private ConcurrentHashMap<Point, Boolean> bombs;
    private ConcurrentHashMap<Point, Square> board;

    public Board() {
        this(0, 0, new ArrayList<Point>());
    }

    public Board(String fileName) {
        buildBoardFromFile(fileName);
    }

    public Board(int boardXSize, int boardYSize, List<Point> bombsList) {
        this.boardXSize = boardXSize;
        this.boardYSize = boardYSize;
        buildBombsFromList(bombsList);
        buildBoardUsingSizeAndBombList();
    }

    private void buildBombsFromList(List<Point> bomblist){

    }

    private void buildBoardFromFile(String inputFile){

    }


    private void buildBoardUsingSizeAndBombList(){

    }

    private void getBombsFromLine(String line, int y){

    }

    public int getBoardXSize(){
        return boardXSize;
    }

    public int getBoardYSize(){
        return boardYSize;
    }
    // -------------- main --------------------------

    public static void main(String[] args) {

        String line = "0 1 0 1 0 1";
        int y = 5;
        Board b = new Board();
        b.getBombsFromLine(line, y);

    }
}
