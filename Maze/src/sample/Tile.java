package sample;

import java.util.ArrayList;

public class Tile {
    int x;
    int y;

    Wall top;
    Wall bot;
    Wall left;
    Wall right;

    boolean PartOfMaze = false;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Wall> getWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        if (top != null)
            walls.add(top);
        if (bot != null)
            walls.add(bot);
        if (left != null)
            walls.add(left);
        if (right != null)
            walls.add(right);
        return walls;
    }

    public ArrayList<Wall> getWallsNotInMaze() {
        ArrayList<Wall> walls = new ArrayList<>();
        if (top != null)
            if (!top.PartOfMaze)
                walls.add(top);
        if (bot != null)
            if (!bot.PartOfMaze)
                walls.add(bot);
        if (left != null)
            if (!left.PartOfMaze)
                walls.add(left);
        if (right != null)
            if (!right.PartOfMaze)
                walls.add(right);
        return walls;
    }

    int length = -1;

    public ArrayList<Wall> getOutsideWalls() {
        ArrayList<Wall> walls = new ArrayList<>();
        if (top.otherSide(this) == null)
            walls.add(top);
        if (bot.otherSide(this) == null)
            walls.add(bot);
        if (left.otherSide(this) == null)
            walls.add(left);
        if (right.otherSide(this) == null)
            walls.add(right);
        return walls;
    }

    public ArrayList<Tile> adjacentTiles() {
        ArrayList<Tile> tiles = new ArrayList<>();

        for (Wall w: getWalls()
             ) {
            if (w.passage && w.otherSide(this)!= null)
                tiles.add(w.otherSide(this));
        }

        return tiles;


    }

    @Override
    public String toString(){
       return "("+x+","+y+") length: "+ length;
    }
}
