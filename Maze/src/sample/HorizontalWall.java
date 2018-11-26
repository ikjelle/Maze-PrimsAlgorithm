package sample;

public class HorizontalWall extends Wall {

    Tile bot;
    Tile top;

    public HorizontalWall(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2, "Horizontal");
    }

    public void setTop(Tile top) {
        this.top = top;
        if (top != null)
            top.bot = this;
    }

    public void setBot(Tile bot) {
        this.bot = bot;
        if (bot != null)
            bot.top = this;
    }

    @Override
    Tile notPartOfMaze() {
        if (bot != null)
            if (!bot.PartOfMaze)
                return bot;
        if (top != null)
            if (!top.PartOfMaze)
                return top;
        return null;
    }

    @Override
    boolean isOutside() {
        return (bot == null || top == null);

    }

    @Override
    public Tile otherSide(Tile t) {
        if (t == top)
            return bot;
        else
            return top;
    }
    public String toString() {
        return super.toString() + "top" + top + "bot" + bot;
    }
}