package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends MovableObject implements IsMovable {

    PlayerKeyboardHandler pkh;
    private int points;

    public Player(SuperField field) {

        super(field);

        this.currentCol = 6;
        this.currentRow = 11;
        this.type = PositionObjectType.PLAYER;
        this.points = 0;
        this.picture = new Picture(field.colsToX(6), field.rowsToY(11), "resources/gustas.png");

        pkh = new PlayerKeyboardHandler(this);


    }

    public void draw(){
        this.picture.draw();
    }

    @Override
    public void move() {

        //moves on direction set by keyboard
        super.move();
        fieldPositions[currentCol][currentRow].getPicture().delete();


        //if theres a beer in position, deletes it
        beerCounter(currentCol, currentRow);
    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

    public void beerCounter(int i, int j) {
        if (fieldPositions[i][j].getType() == PositionObjectType.PLAYER && fieldPositions[i][j].getInteractiveType() == IsInteractiveObjectType.BEER) {
            fieldPositions[i][j].setInteractiveType(IsInteractiveObjectType.EMPTY);
            points++;
        }
    }

    public boolean checkWin() {
        if (points == field.getTargetPoints()) {
            Rectangle win = new Rectangle(field.getWidth() / 2 - 70, field.getHeight() / 2 - 50, 200, 100);
            win.setColor(Color.GREEN);
            win.fill();
            Text text = new Text(field.getWidth() / 2, field.getHeight() / 2 - 10, "YOU WIN!");
            text.grow(40, 10);
            text.setColor(Color.BLACK);
            text.draw();
            return true;

        } else return false;

    }
}


