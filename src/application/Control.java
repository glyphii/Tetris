package application;
import javafx.scene.shape.*;

public class Control {
    //Instance Variables:
     public static final int MOVE = Tetris.MOVE;
     private static final int SIZE = Tetris.SIZE;
     private static final int XMAX = Tetris.XMAX;
     public static final int YMAX = Tetris.YMAX;
     public static int[][] board = Tetris.board;
    //Methods:

    
    public static Block make(){
        int block = (int)(Math.random()*7);
        char name = ' ';
        Rectangle a = new Rectangle(SIZE-1, SIZE-1);
        Rectangle b = new Rectangle(SIZE-1, SIZE-1);
        Rectangle c = new Rectangle(SIZE-1, SIZE-1);
        Rectangle d = new Rectangle(SIZE-1, SIZE-1);

        switch(block){
            //j:
            case 0:
                a.setX(XMAX/2 - SIZE);
                b.setX(XMAX/2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX/2);
                c.setY(SIZE);
                d.setX(XMAX/2 + SIZE);
                d.setY(SIZE);
                name = 'j';
                break;
            //l:
            case 1:
                a.setX(XMAX/2 + SIZE);
                b.setX(XMAX/2 - SIZE);
                b.setY(SIZE);
                c.setX(XMAX/2);
                c.setY(SIZE);
                d.setX(XMAX/2 + SIZE);
                d.setY(SIZE);
                name = 'l';
                break;
            //o:
            case 2:
                a.setX(XMAX/2 - SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2 - SIZE);
                c.setY(SIZE);
                d.setX(XMAX/2);
                d.setY(SIZE);
                name = 'o';
                break;
            //s:
            case 3:
                a.setX(XMAX/2 + SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2);
                c.setY(SIZE);
                d.setX(XMAX/2 - SIZE);
                d.setY(SIZE);
                name = 's';
                break;
            //t
            case 4:
                a.setX(XMAX/2 - SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2);
                c.setY(SIZE);
                d.setX(XMAX/2 + SIZE);
                name = 't';
                break;
            //z
            case 5:
                a.setX(XMAX/2 + SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2 + SIZE);
                c.setY(SIZE);
                d.setX(XMAX/2 + SIZE + SIZE);
                d.setY(SIZE);
                name = 'z';
                break;
            //i
            case 6:
                a.setX(XMAX/2 - SIZE - SIZE);
                b.setX(XMAX/2 - SIZE);
                c.setX(XMAX/2);
                d.setX(XMAX/2 + SIZE);
                name = 'i';
                break;
        }
        return new Block (a, b, c, d, name);

    }

    public static void MoveRight (Block block){
        if (block.a.getX() + MOVE <= XMAX - SIZE && block.b.getX()+MOVE <= XMAX - SIZE && block.c.getX()+MOVE <= XMAX - SIZE && block.d.getX()+MOVE <= XMAX - SIZE){
            //int movea = board[((int)block.a.getX())+1][((int)block.a.getY()/SIZE)];
            //int moveb = board[((int)block.b.getX())+1][((int)block.b.getY()/SIZE)];
            //int movec = board[((int)block.c.getX())+1][((int)block.c.getY()/SIZE)];
            //int moved = board[((int)block.d.getX())+1][((int)block.d.getY()/SIZE)];
            //if (movea == 0 &&  moveb == 0 && movec == 0 && moved == 0){
                block.a.setX(block.a.getX()+MOVE);
                block.b.setX(block.b.getX()+MOVE);
                block.c.setX(block.c.getX()+MOVE);
                block.d.setX(block.d.getX()+MOVE);
            //}
        }
    }
    public static void MoveLeft (Block block){
        if (block.a.getX() - MOVE >= 0 && block.b.getX()-MOVE >= 0 && block.c.getX()-MOVE >= 0 && block.d.getX()-MOVE >= 0){
            //int movea = board[((int)block.a.getX())-1][((int)block.a.getY()/SIZE)];
            //int moveb = board[((int)block.b.getX())-1][((int)block.b.getY()/SIZE)];
            //int movec = board[((int)block.c.getX())-1][((int)block.c.getY()/SIZE)];
            //int moved = board[((int)block.d.getX())-1][((int)block.d.getY()/SIZE)];
            //if (movea == 0 &&  moveb == 0 && movec == 0 && moved == 0){
                block.a.setX(block.a.getX()-MOVE);
                block.b.setX(block.b.getX()-MOVE);
                block.c.setX(block.c.getX()-MOVE);
                block.d.setX(block.d.getX()-MOVE);
            //}
        }
    }
}
