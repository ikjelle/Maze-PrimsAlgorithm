package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze {

    int width;
    int length;
    ArrayList<Wall> walls = new ArrayList<>();
    Tile[][] tiles;
    int longest;

    Wall start;
    Wall end;

    public Maze(int width, int length) {

        this.width = width;
        this.length = length;

        tiles = new Tile[width][length];

        generate();
    }

    public void generate() {
        for (int j = 0; j < length + 1; j++) {
            for (int i = 0; i < width; i++) {
                Tile top = getTile(i, j - 1);
                Tile bot = getTile(i, j);
                HorizontalWall w = new HorizontalWall(i, j, i + 1, j);
                w.setTop(top);
                w.setBot(bot);
                walls.add(w);
            }
        }

        for (int i = 0; i < width + 1; i++) {
            for (int j = 0; j < length; j++) {
                Tile left = getTile(i - 1, j);
                Tile right = getTile(i, j);
                VerticalWall w = new VerticalWall(i, j, i, j + 1);
                w.setLeft(left);
                w.setRight(right);
                walls.add(w);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 | x >= width | y < 0 | y >= length) return null;
        Tile t = tiles[x][y];
        if (t == null) {
            t = new Tile(x, y);
            tiles[x][y] = t;
        }
        return t;
    }

    public void primsAlgorithm() {
        this.primsAlgorithm(-1, -1);
    }

    public void primsAlgorithm(int x, int y) {
        ArrayList<Wall> outsideWalls = new ArrayList<>();
        for (Wall w : walls
        ) {
            if (w.isOutside())
                outsideWalls.add(w);
        }

        start = outsideWalls.get((int) (Math.random() * outsideWalls.size()));

        outsideWalls.remove(start);


        start.passage = true;
        start.PartOfMaze = true;

        Tile t = start.notPartOfMaze();

        ArrayList<Wall> wallsOfMaze = new ArrayList<>();

        wallsOfMaze.addAll(t.getWallsNotInMaze());

        while (!wallsOfMaze.isEmpty()) {
            Wall w = wallsOfMaze.get((int) (Math.random() * wallsOfMaze.size()));

            t = w.notPartOfMaze();

            if (t != null) {
                w.passage = true;
                t.PartOfMaze = true;

                wallsOfMaze.addAll(t.getWallsNotInMaze());
            }
            w.PartOfMaze = true;
            wallsOfMaze.remove(w);
        }

        int lenght = 0;
        Tile last = findLongestWay(start.otherSide(null));
        for (Tile xtiles[] : tiles
        ) {
            for (Tile tile : xtiles
            ) {
                if (lenght < tile.length) {
                    if (tile.getOutsideWalls().size() > 0) {
                        lenght = tile.length;
                        last = tile;
                    }
                }
            }
        }

        System.out.println(last);
        end = last.getOutsideWalls().get(0);


        end.passage = true;
        end.PartOfMaze = true;


    }

    private Tile findLongestWay(Tile start) {
        Queue<Tile> tiles = new Queue<>();

        tiles.enqueue(start);

        start.length = 0;
        Tile end = null;

        while (tiles.front != null) {
            System.out.println(tiles.length());
            Tile tile = tiles.dequeue();
            for (Tile t : tile.adjacentTiles()
            ) {
                if (t.length == -1) {
                    t.length = tile.length + 1;
                    tiles.enqueue(t);
                    longest = t.length;
                }
            }
            end = tile;
            System.out.println(tile);

        }


        return end;


    }

}
