package sample;

public abstract class Wall {
   int x1;
   int y1;
   int x2;
   int y2;
   
   String side;

   boolean passage = false;
   boolean PartOfMaze = false;
   
   
   public Wall(int x1, int y1, int x2,int y2, String side){
     this.x1 = x1;
     this.y1 =y1;
     
     this.x2=x2;
     this.y2=y2;
     
     this.side = side;
   }

   abstract Tile notPartOfMaze();

   abstract boolean isOutside();
   
   public String toString(){
     return "("+x1+","+y1+")"+"("+x2+","+y2+") class="+ side;
   }

    public abstract Tile otherSide(Tile tile);
}
