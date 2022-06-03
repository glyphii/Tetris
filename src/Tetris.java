import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.scene.shape.Line;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;


public class Tetris extends Application{
    //Initial values and variables:
    public static final int SIZE = 25;
    public static final int MOVE = 25;
    public static final int XMAX = SIZE * 12;
    public static final int YMAX = SIZE * 24;
    public static final int [][] board = new int [12][24];
    private static Pane gamePane = new Pane();
    private static Block object;
    private static Scene scene = new Scene(gamePane, XMAX + 150, YMAX);
    public static int score = 0;
    private static boolean game = true;
    private static Block nextObj = Control.make();

    public void main (String[] args) { launch(args);}
    @Override
    public void start(Stage arg0) throws Exception {
        for (int[] a: board){
            //fills the empty board
            Arrays.fill(a,0);
        }
        // create score and text
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretxt = new Text("Score: ");
    }
    // public static void main(String[] args) throws Exception {
    //     System.out.println("Hello, World!");
    // }
}
