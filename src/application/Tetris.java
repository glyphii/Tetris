package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


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
    public static int top = 0;
    private static boolean game = true;
    private static Block nextObj = Control.make();
    private static int linesNo = 0;

    public static void main (String[] args) { launch(args);}
    @Override
    public void start(Stage stage) throws Exception {
        for (int[] a: board){
            //fills the empty board
            Arrays.fill(a,0);
        }
        // create score and text
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        Text scoretxt = new Text("Score: ");
        scoretxt.setStyle("-fx-font: 20 arials;");
        scoretxt.setX(XMAX+5);
        scoretxt.setY(50);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arials;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.GREEN);
        gamePane.getChildren().addAll(scoretxt, line, level);

        //Create the first block and the window
        Block a = nextObj;
        gamePane.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        object = a;
        nextObj = Control.make();
        stage.setScene(scene);
        stage.setTitle("T E T R I S");
        stage.show();

        //Timer
        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                // TODO Auto-generated method stub
                Platform.runLater(new Runnable(){
                    public void run(){
                        if(object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0 || object.d.getY() == 0){
                            top++;
                        }
                        else{
                            top=0;
                        }
                        if (top == 2){
                            //gameOver
                            Text over = new Text("GAME OVER");
                            over.setFill(Color.RED);
                            over.setStyle("-fx-font: 70 arials;");
                            over.setY(250);
                            over.setX(10);
                            gamePane.getChildren().add(over);
                            game = false;
                        }
                        if (top == 15) {
                            System.exit(0);
                        }
                        if(game) {
                            MoveDown(object);
                            scoretxt.setText("Score: "+ Integer.toString(score));
                            level.setText("Lines: "+ Integer.toString(linesNo));
                        }
                    }
                });
            }
            
        };
        fall.schedule(task, 0, 300);
    }
    private void moveOnKeyPress (Block block) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case RIGHT: 
                        Control.MoveRight(block);
                        break;
                    case DOWN:
                        MoveDown(block);
                        score++;
                        break;
                    case LEFT:
                        Control.MoveLeft(block);
                        break;
                    case UP:
                        MoveTurn(block);
                        break;
                }
                
            }
        });
    }
    private void MoveTurn(Block block){
        int f = block.orient;
        Rectangle a = block.a;
        Rectangle b = block.b;
        Rectangle c = block.c;
        Rectangle d = block.d;
        switch(block.getName()){
          case 'j':
            if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)){
              MoveRight(block.a);
              MoveDown(block.a);
              MoveDown(block.c);
              MoveLeft(block.c);
              MoveDown(block.d);
              MoveDown(block.d);
              MoveLeft(block.d);
              MoveLeft(block.d);
              block.orientation();
              break;
            }
            if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1)&& cB(d, -2, 2)){
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveLeft(block.c);
              MoveUp(block.c);
              MoveLeft(block.d);
              MoveLeft(block.d);
              MoveUp(block.d);
              MoveUp(block.d);
              block.orientation();
              break;
            }
            if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1)&& cB(d, 2, 2)){
              MoveLeft(block.a);
              MoveUp(block.a);
              MoveUp(block.c);
              MoveRight(block.c);
              MoveUp(block.d);
              MoveUp(block.d);
              MoveRight(block.d);
              MoveRight(block.d);
              block.orientation();
              break;
            }
            if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1)&& cB(d, 2, -2)){
              MoveUp(block.a);
              MoveRight(block.a);
              MoveRight(block.c);
              MoveDown(block.c);
              MoveRight(block.d);
              MoveRight(block.d);
              MoveDown(block.d);
              MoveDown(block.d);
              block.orientation();
              break;
            }
            break;
          case 'l':
            if (f==1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)){
              MoveRight(block.a);
              MoveDown(block.a);
              MoveUp(block.c);
              MoveRight(block.c);
              MoveUp(block.b);
              MoveUp(block.b);
              MoveRight(block.b);
              MoveRight(block.b);
              block.orientation();
              break;
              }
            if (f==2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)){
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveRight(block.b);
              MoveRight(block.b);
              MoveDown(block.b);
              MoveDown(block.b);
              MoveRight(block.c);
              MoveDown(block.c);
              block.orientation();
              break;
              } 
            if (f==3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)){
              MoveLeft(block.a);
              MoveUp(block.a);
              MoveDown(block.c);
              MoveLeft(block.c);
              MoveDown(block.b);
              MoveDown(block.b);
              MoveLeft(block.b);
              MoveLeft(block.b);
              block.orientation();
              break;
              } 
            if (f==3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)){
              MoveLeft(block.a);
              MoveUp(block.a);
              MoveDown(block.c);
              MoveLeft(block.c);
              MoveDown(block.b);
              MoveDown(block.b);
              MoveLeft(block.b);
              MoveLeft(block.b);
              block.orientation();
              break;
              } 
            if (f==4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(b, -1, 1)){
              MoveUp(block.a);
              MoveRight(block.a);
              MoveLeft(block.c);
              MoveLeft(block.c);
              MoveUp(block.b);
              MoveUp(block.b);
              MoveLeft(block.b);
              MoveUp(block.b);
              block.orientation();
              break;
              } 
            break;
          case 'o':
            break;
          case 's':
            if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)){
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveLeft(block.c);
              MoveUp(block.c);
              MoveUp(block.d);
              MoveUp(block.d);
              block.orientation();
              break;
            }
            if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)){
              MoveUp(block.a);
              MoveRight(block.a);
              MoveRight(block.c);
              MoveDown(block.c);
              MoveDown(block.d);
              MoveDown(block.d);
              block.orientation();
              break;
            }
            if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)){
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveLeft(block.c);
              MoveUp(block.c);
              MoveUp(block.d);
              MoveUp(block.d);
              block.orientation();
              break;
            }
            if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)){
              MoveUp(block.a);
              MoveRight(block.a);
              MoveRight(block.c);
              MoveDown(block.c);
              MoveDown(block.d);
              MoveDown(block.d);
              block.orientation();
              break;
            }
            break;
          case 't':
            if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)){
              MoveUp(block.a);
              MoveRight(block.a);
              MoveDown(block.d);
              MoveLeft(block.d);
              MoveLeft(block.c);
              MoveUp(block.c);
              block.orientation();
              break;
            }
            if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)){
              MoveRight(block.a);
              MoveDown(block.a);
              MoveLeft(block.d);
              MoveUp(block.d);
              MoveUp(block.c);
              MoveRight(block.c);
              block.orientation();
              break;
            }
            if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)){
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveUp(block.d);
              MoveRight(block.d);
              MoveRight(block.c);
              MoveDown(block.c);
              block.orientation();
              break;
            }
            if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)){
              MoveLeft(block.a);
              MoveUp(block.a);
              MoveRight(block.d);
              MoveDown(block.d);
              MoveDown(block.c);
              MoveLeft(block.c);
              block.orientation();
              break;
            }
            break;
          case 'z':
            if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)){
              MoveUp(block.b);
              MoveRight(block.b);
              MoveLeft(block.c);
              MoveUp(block.c);
              MoveLeft(block.d);
              MoveLeft(block.d);
              block.orientation();
              break;
            }
            if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)){
              MoveDown(block.b);
              MoveLeft(block.b);
              MoveRight(block.c);
              MoveDown(block.c);
              MoveRight(block.d);
              MoveRight(block.d);
              block.orientation();
              break;
            }
            if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)){
              MoveUp(block.b);
              MoveRight(block.b);
              MoveLeft(block.c);
              MoveUp(block.c);
              MoveLeft(block.d);
              MoveLeft(block.d);
              block.orientation();
              break;
            }
            if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)){
              MoveDown(block.b);
              MoveLeft(block.b);
              MoveRight(block.c);
              MoveDown(block.c);
              MoveRight(block.d);
              MoveRight(block.d);
              block.orientation();
              break;
            }
            break;
          case 'i':
            if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)){
              MoveUp(block.a);
              MoveUp(block.a);
              MoveRight(block.a);
              MoveRight(block.a);
              MoveUp(block.b);
              MoveRight(block.b);
              MoveDown(block.d);
              MoveLeft(block.d);
              block.orientation();
              break;
            }
            if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)){
              MoveDown(block.a);
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveLeft(block.a);
              MoveDown(block.b);
              MoveLeft(block.b);
              MoveUp(block.d);
              MoveRight(block.d);
              block.orientation();
              break;
            }
            if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)){
              MoveUp(block.a);
              MoveUp(block.a);
              MoveRight(block.a);
              MoveRight(block.a);
              MoveUp(block.b);
              MoveRight(block.b);
              MoveDown(block.d);
              MoveLeft(block.d);
              block.orientation();
              break;
            }
            if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)){
              MoveDown(block.a);
              MoveDown(block.a);
              MoveLeft(block.a);
              MoveLeft(block.a);
              MoveDown(block.b);
              MoveLeft(block.b);
              MoveUp(block.d);
              MoveRight(block.d);
              block.orientation();
              break;
            }
            break;
            }
      }
      private void RemoveRows(Pane pane){
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        for (int i = 0; i < board[0].length; i++){
          for (int j = 0; j < board.length; j++){
            if (board[j][i] == 1)
              full++;
          }
          if (full == board.length)
            lines.add(i);
          full = 0;
        }
        if (lines.size()>0)
          do {
                      for (Node node : pane.getChildren()) {
                          if (node instanceof Rectangle)
                              rects.add(node);
                      }
                      score += 50;
                      linesNo++;
      
                      for (Node node : rects) {
                          Rectangle a = (Rectangle) node;
                          if (a.getY() == lines.get(0) * SIZE) {
                              board[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                              pane.getChildren().remove(node);
                          } else
                              newrects.add(node);
                      }
      
                      for (Node node : newrects) {
                          Rectangle a = (Rectangle) node;
                          if (a.getY() < lines.get(0) * SIZE) {
                              board[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                              a.setY(a.getY() + SIZE);
                          }
                      }
                      lines.remove(0);
                      rects.clear();
                      newrects.clear();
                      for (Node node : pane.getChildren()) {
                          if (node instanceof Rectangle)
                              rects.add(node);
                      }
                      for (Node node : rects) {
                          Rectangle a = (Rectangle) node;
                          try {
                              board[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                          } catch (ArrayIndexOutOfBoundsException e) {
                          }
                      }
                      rects.clear();
                  } while (lines.size() > 0);
          }
      
      
      
      private void MoveDown(Rectangle rect) {
              if (rect.getY() + MOVE < YMAX)
                  rect.setY(rect.getY() + MOVE);
      
          }
      
          private void MoveRight(Rectangle rect) {
              if (rect.getX() + MOVE <= XMAX - SIZE)
                  rect.setX(rect.getX() + MOVE);
          }
      
          private void MoveLeft(Rectangle rect) {
              if (rect.getX() - MOVE >= 0)
                  rect.setX(rect.getX() - MOVE);
          }
      
          private void MoveUp(Rectangle rect) {
              if (rect.getY() - MOVE > 0)
                  rect.setY(rect.getY() - MOVE);
          }
      
          private void MoveDown(Block block) {
              if (block.a.getY() == YMAX - SIZE || block.b.getY() == YMAX - SIZE || block.c.getY() == YMAX - SIZE
                      || block.d.getY() == YMAX - SIZE || moveA(block) || moveB(block) || moveC(block) || moveD(block)) {
                  board[(int) block.a.getX() / SIZE][(int) block.a.getY() / SIZE] = 1;
                  board[(int) block.b.getX() / SIZE][(int) block.b.getY() / SIZE] = 1;
                  board[(int) block.c.getX() / SIZE][(int) block.c.getY() / SIZE] = 1;
                  board[(int) block.d.getX() / SIZE][(int) block.d.getY() / SIZE] = 1;
                  RemoveRows(gamePane);
      
                  Block a = nextObj;
                  nextObj = Control.make();
                  object = a;
                  gamePane.getChildren().addAll(a.a, a.b, a.c, a.d);
                  moveOnKeyPress(a);
              }
      
              if (block.a.getY() + MOVE < YMAX && block.b.getY() + MOVE < YMAX && block.c.getY() + MOVE < YMAX
                      && block.d.getY() + MOVE < YMAX) {
                  int movea = board[(int) block.a.getX() / SIZE][((int) block.a.getY() / SIZE) + 1];
                  int moveb = board[(int) block.b.getX() / SIZE][((int) block.b.getY() / SIZE) + 1];
                  int movec = board[(int) block.c.getX() / SIZE][((int) block.c.getY() / SIZE) + 1];
                  int moved = board[(int) block.d.getX() / SIZE][((int) block.d.getY() / SIZE) + 1];
                  if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                      block.a.setY(block.a.getY() + MOVE);
                      block.b.setY(block.b.getY() + MOVE);
                      block.c.setY(block.c.getY() + MOVE);
                      block.d.setY(block.d.getY() + MOVE);
                  }
              }
          }
      
          private boolean moveA(Block block) {
              return (board[(int) block.a.getX() / SIZE][((int) block.a.getY() / SIZE) + 1] == 1);
          }
      
          private boolean moveB(Block block) {
              return (board[(int) block.b.getX() / SIZE][((int) block.b.getY() / SIZE) + 1] == 1);
          }
      
          private boolean moveC(Block block) {
              return (board[(int) block.c.getX() / SIZE][((int) block.c.getY() / SIZE) + 1] == 1);
          }
      
          private boolean moveD(Block block) {
              return (board[(int) block.d.getX() / SIZE][((int) block.d.getY() / SIZE) + 1] == 1);
          }
      
          private boolean cB(Rectangle rect, int x, int y) {
              boolean xb = false;
              boolean yb = false;
              if (x >= 0)
                  xb = rect.getX() + x * MOVE <= XMAX - SIZE;
              if (x < 0)
                  xb = rect.getX() + x * MOVE >= 0;
              if (y >= 0)
                  yb = rect.getY() - y * MOVE > 0;
              if (y < 0)
                  yb = rect.getY() + y * MOVE < YMAX;
              return xb && yb && board[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
          }
      
      }
      

