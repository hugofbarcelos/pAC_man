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

        //if theres a beer in position, deletes it
        if(fieldPositions[currentCol][currentRow].getEllipse() != null){
            fieldPositions[currentCol][currentRow].getEllipse().delete();
        }

        beerCounter(currentCol, currentRow);

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

    public void beerCounter(int i, int j){
        if (fieldPositions[i][j].getType() == PositionObjectType.PLAYER && fieldPositions[i][j].getInteractiveType() == IsInteractiveObjectType.BEER){
            fieldPositions[i][j].setInteractiveType(IsInteractiveObjectType.EMPTY);
            field.paintBeer(fieldPositions,i,j);
            points++;
        }
    }

    public boolean checkWin(){
        if(points == field.TARGETPOINTS){
            Rectangle win = new Rectangle(field.getWidth()/2 - 70, field.getHeight()/2 - 50, 200, 100);
            win.setColor(Color.GREEN);
            win.fill();
            Text text = new Text(field. getWidth()/2, field.getHeight()/2 - 10 , "YOU WIN!");
            text.grow(40,10);
            text.setColor(Color.BLACK);
            text.draw();
            return true;

        } else return false;
    }
}
