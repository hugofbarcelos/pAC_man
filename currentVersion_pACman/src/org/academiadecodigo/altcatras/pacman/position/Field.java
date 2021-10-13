package org.academiadecodigo.altcatras.pacman.position;

public class Field extends SuperField {

    public Field(){
        super(81);
    }

    //Create the walls for the map
    @Override
    public void createWalls() {

        //works for 13 x 13, including walls
        for (int i = 0; i < getROWS(); i++) {
            if (i == 0 || i == getROWS() - 1) {
                for (int j = 0; j < getROWS(); j++) {
                    positions[j][i] = new Position();
                    positions[j][i].setType(PositionObjectType.WALL);
                }
                continue;
            }

            if (i == 1 || i == (getROWS() / 2) || i == getROWS() - 2) {
                for (int j = 0; j < getCOLS(); j++) {
                    switch (j) {
                        case 0, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);

                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if (i == 2 || i == getROWS() - 3) {
                for (int j = 0; j < getCOLS(); j++) {
                    switch (j) {
                        case 1, 4, 8, 11:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                    }
                }
                continue;
            }

            if (i == 3 || i == getROWS() - 4) {
                for (int j = 0; j < getROWS(); j++) {
                    switch (j) {
                        case 0, 2, 6, 10, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if (i == 4 || i == getROWS() - 5) {
                for (int j = 0; j < getCOLS(); j++) {
                    switch (j) {
                        case 0, 4, 6, 8, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if (i == 5 || i == getROWS() - 6) {
                for (int j = 0; j < getCOLS(); j++) {
                    switch (j) {
                        case 1, 5, 7, 11:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                    }
                }
            }


        }

    }


    @Override
    public void paintField() {
        Picture background = new Picture(colsToX(0), rowsToY(0), "resources/backgroup.png"); //defines the background image for this field
        background.draw();
        super.paintField();
    }

    @Override
    public void paintCell(Position[][] position, int col, int row) {
        if (position[col][row].getType() == PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/wall.png")); //defines the wall image for this field
            position[col][row].getPicture().draw();
            return;
        }
    }


}
