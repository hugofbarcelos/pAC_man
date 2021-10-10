package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.IsInteractiveObjectType;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Player extends MovableObject implements IsMovable {

    PlayerKeyboardHandler pkh;
    private int points;
    private final int MAXPOINTS = 79;
    public Player(Field field){

        super(field);

        this.currentCol = 6;
        this.currentRow = 11;
        this.type = PositionObjectType.PLAYER;
        pkh = new PlayerKeyboardHandler(this);
        this.points = 0;

    }

    @Override
    public void move() {

        //moves on direction set by keyboard

        super.move();
        beerCounter();

    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void beerCounter(){
        for (int i = 0; i < field.getROWS(); i++) {
            for (int j = 0; j < field.getCOLS(); j++) {
                if (fieldPositions[i][j].getType() == PositionObjectType.PLAYER && fieldPositions[i][j].getInteractiveType() == IsInteractiveObjectType.BEER){
                    fieldPositions[i][j].setInteractiveType(IsInteractiveObjectType.EMPTY);
                    field.paintBeer(fieldPositions,i,j);
                    points++;


                }
            }
        }
    }


    public boolean win(){

        if(points == MAXPOINTS){
            Rectangle rectangle = new Rectangle(field.getWidth()/2,field.getHeight()/2,200,100);
            rectangle.setColor(Color.GREEN);
            rectangle.fill();
            Text text = new Text(field.getWidth()/4, field.getHeight()/4, "You Won!!!");

            text.setColor(Color.BLACK);
            text.draw();


            return true;
        }
        return false;
    }
}
