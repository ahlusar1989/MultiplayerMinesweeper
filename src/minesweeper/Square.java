package minesweeper;

/**
 * Created by saranahluwalia on 6/24/17.
 */
public class Square {
    private final Point point;

    private boolean containsBomb;

    private boolean isUnTouched = true;
    private boolean isDug = false;
    private boolean isFlagged = false;

    public Square (Point point, boolean containsBomb){
        this.point = point;
        this.containsBomb = containsBomb;
    }

    private void checkRep() {
        if (isUnTouched) { assert !isDug; }
        if (isDug) { assert !isUnTouched && !isFlagged; }
    }

    public Square removeBomb() {
        this.containsBomb = false;
        return this;
    }

    public Square setDug() {
        this.isDug = true;
        this.isUnTouched = false;
        this.isFlagged = false;
        checkRep();
        return this;
    }

    public Square setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
        checkRep();
        return this;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isContainBomb() {
        return containsBomb;
    }

    public int getBombCount() {
        return containsBomb ? 1 : 0;
    }

    public boolean isUntouched() {
        return containsBomb;
    }

    public boolean isDug() {
        return isDug;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    @Override
    public String toString() {
        if (isFlagged) return "F";
        else if (isDug && containsBomb) return "B";
        else if (isDug && !containsBomb) return " ";
        else if (isUnTouched && !isFlagged) return "-";
        else throw new RuntimeException("Invalid Square");

    }
}
