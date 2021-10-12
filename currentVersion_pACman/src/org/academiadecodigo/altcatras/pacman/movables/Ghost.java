package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.movables.IsMovable;
import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

import org.academiadecodigo.altcatras.pacman.position.SuperField;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ghost extends MovableObject implements IsMovable {

    public Ghost(SuperField field){


        super(field);
        this.currentCol = 7;
        this.currentRow = 3;
        this.currentDir = randomDir();
        this.type = PositionObjectType.GHOST;
        this.picture = new Picture(field.colsToX(7), field.rowsToY(3), "resources/jorge.png");
        this.picture.draw();

    }


    @Override
    public void move() {

        currentDir = chooseDirectionIntersection(currentDir);

        super.move();

    }
}
