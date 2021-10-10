package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.movables.IsMovable;
<<<<<<< HEAD

public class Ghost implements IsMovable {
=======
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

>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b

    @Override
    public void move() {

<<<<<<< HEAD
=======
        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        field.paintCell(fieldPositions, currentCol, currentRow);
        currentRow++;
        fieldPositions[currentCol][currentRow].setType(PositionObjectType.GHOST);



>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
    }
}
