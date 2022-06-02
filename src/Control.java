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
        String name = "";
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
                name = "j";
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
                name = "l";
                break;
            //o:
            case 2:
                a.setX(XMAX/2 - SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2 - SIZE);
                c.setY(SIZE);
                d.setX(XMAX/2);
                d.setY(SIZE);
                name = "o";
                break;
            //s:
            case 3:
                a.setX(XMAX/2 + SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2);
                c.setY(SIZE);
                d.setX(XMAX/2 - SIZE);
                d.setY(SIZE);
                name = "s";
                break;
            //t
            case 4:
                a.setX(XMAX/2 - SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2);
                c.setY(SIZE);
                d.setX(XMAX/2 + SIZE);
                name = "t";
                break;
            //z
            case 5:
                a.setX(XMAX/2 + SIZE);
                b.setX(XMAX/2);
                c.setX(XMAX/2 + SIZE);
                c.setY(SIZE);
                d.setX(XMAX/2 + SIZE + SIZE);
                d.setY(SIZE);
                name = "z";
                break;
            //i
            case 6:
                a.setX(XMAX/2 - SIZE - SIZE);
                b.setX(XMAX/2 - SIZE);
                c.setX(XMAX/2 + SIZE);
                d.setX(XMAX/2 + SIZE);
                name = "i";
                break;
        }
        return new Block (a, b, c, d, name);

    }
    
}
