package application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Block {
  Rectangle a;
  Rectangle b; 
  Rectangle c;
  Rectangle d;
  Color color;
  public char name;
  public int orient = 1;
  
  public Block(Rectangle a, Rectangle b, Rectangle c, Rectangle d, char name){
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
      this.name = name;
      //colorset
      switch(name){
        case 'j':
            color = Color.MEDIUMAQUAMARINE; break;
        case 'l':
            color = Color.DARKGOLDENROD; break;
        case 'o':
            color = Color.INDIANRED; break;
        case 's':
            color = Color.GHOSTWHITE; break;
        case 't':
            color = Color.CADETBLUE; break;
        case 'z':
            color = Color.HOTPINK; break;
        case 'i':
            color = Color.CORAL; break;
        }
    
        this.a.setFill(color);
        this.b.setFill(color);
        this.c.setFill(color);
        this.d.setFill(color);
  }

  public void orientation(){
      if (orient !=4){
          orient ++;
      }
      else{
          orient = 1;
      }
    }
  
  

    public char getName(){
        return name;
    }
}
