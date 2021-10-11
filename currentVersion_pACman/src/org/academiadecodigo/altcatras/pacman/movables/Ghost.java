package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.movables.IsMovable;
import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

public class Ghost extends MovableObject implements IsMovable {


    public Ghost(Field field){

        super(field);
        this.currentCol = 7;
        this.currentRow = 3;
        this.currentDir = randomDir();
        this.type = PositionObjectType.GHOST;

    }


    @Override
    public void move() {

        currentDir = chooseDirectionIntersection(currentDir);

        super.move();

    }
}
