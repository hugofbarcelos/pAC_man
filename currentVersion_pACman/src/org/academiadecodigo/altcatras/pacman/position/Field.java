package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field extends SuperField {


    /*    public void createField() {
            field = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
            field.setColor(Color.BLACK);

            field.draw();
            createWalls();
            paintField();
        }*/

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
                continue;
            }


        }

    }


<<<<<<< HEAD
=======
    public void paintCell(Position[][] position, int col, int row) {
        if (position[col][row].getType() != PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/ground.png"));
            position[col][row].getPicture().draw();
            return;
        } else if (position[col][row].getType() == PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/wall.png"));
            position[col][row].getPicture().draw();
            return;
        }
       /* position[col][row].setRectangle(new Rectangle(colsToX(col), rowsToY(row), CELLSIZE, CELLSIZE));
        position[col][row].getRectangle().setColor(position[col][row].getType().color);
        position[col][row].getRectangle().fill();*/
>>>>>>> e145953861150895db6c6be247c45f13f8e168dc










}
