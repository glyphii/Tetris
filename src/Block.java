import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Block {
  Rectangle a;
  Rectangle b; 
  Rectangle c;
  Rectangle d;
  Color color;
  private String name;
  public int orient = 1;
  
  public Block(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name){
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
      this.name = name;
  }

  public void Orientation(){
      if (orient !=4){
          orient ++;
      }
      else{
          orient = 1;
      }
  }
  public void colorSet(){
      
  }
}
