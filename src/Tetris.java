/*import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;*/

public class Tetris {
    //Initial values and variables:
    public static final int SIZE = 25;
    public static final int MOVE = 25;
    public static final int XMAX = SIZE * 12;
    public static final int YMAX = SIZE * 24;
    public static final int [][] board = new int [12][24];
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
