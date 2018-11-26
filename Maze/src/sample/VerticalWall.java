package sample;

public class VerticalWall extends Wall {

    Tile left;
    Tile right;

    public VerticalWall(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2, "Vertical");
    }

    public void setLeft(Tile left) {
        this.left = left;
        if (left != null)
            left.right = this;
    }

    public void setRight(Tile right) {
        this.right = right;
        if (right != null)
            right.left = this;
    }

    @Override
    Tile notPartOfMaze() {
        if (left != null)
            if (!left.PartOfMaze)
                return left;
        if (right != null)
            if (!right.PartOfMaze)
                return right;
        return null;
    }

    @Override
    boolean isOutside() {
        return (left == null || right == null);

    }

    public String toString() {
        return super.toString() + "left" + left + "right" + right;
    }

    @Override
    public Tile otherSide(Tile t) {
        if (t == right)
            return left;
        else
            return right;
    }
}
