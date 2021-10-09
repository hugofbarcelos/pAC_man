import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private static final int PADDING = 10;
    private Rectangle boarderWall;
    private Rectangle field;
    private static final int CELLSIZE = 50;
    private int cols;
    private int rows;
    private int width;
    private int height;


    public Field(){
        cols = 13; // includes borders
        rows = 13;
        width = cols * CELLSIZE;
        height = rows * CELLSIZE;

    }

    public void createField() {
        field = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        field.setColor(Color.WHITE);
        field.draw();
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }


}
