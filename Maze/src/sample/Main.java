package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    static int scale = 50;

    Maze m;

    @Override
    public void start(Stage primaryStage) throws Exception{
        m = new Maze(20,20);
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(scale*m.width, scale*m.length);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {


        m.primsAlgorithm();

        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);

        for (Wall w:m.walls
             ) {
            if (!w.passage)
            gc.strokeLine(scale*w.x1,scale*w.y1,scale*w.x2,scale*w.y2);
        }


        gc.setFill(Color.GREEN);
        gc.fillRect(m.start.otherSide(null).x* scale+ scale*0.1,m.start.otherSide(null).y*scale+ scale*0.1,scale*0.8,scale*0.8);


        gc.setFill(Color.DODGERBLUE);
        gc.fillRect(m.end.otherSide(null).x* scale+ scale*0.1,m.end.otherSide(null).y*scale+ scale*0.1,scale*0.8,scale*0.8);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
