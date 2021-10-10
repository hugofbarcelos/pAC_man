package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private final int PADDING = 10;
    private Rectangle field;
    private final int CELLSIZE = 60;
    private final int COLS = 13; // includes borders
    private final int ROWS = 13;
    private int width;
    private int height;
    Position[][] positions;
    private int point;


    public Field(){

        width = COLS * CELLSIZE;
        height = ROWS * CELLSIZE;
        this.positions = new Position[COLS][ROWS];
        this.point = 0;

    }

/*    public void createField() {
        field = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        field.setColor(Color.BLACK);

        field.draw();
        createWalls();
        paintField();
    }*/

    public void createWalls(){

        //works for 13 x 13, including walls
        for (int i = 0; i < ROWS; i++) {

            if(i==0 || i == ROWS - 1){
                for (int j = 0; j < COLS; j++) {
                    positions[j][i] = new Position();
                    positions[j][i].setType(PositionObjectType.WALL);
                }
                continue;
            }

            if(i==1 || i == (ROWS/2) || i == ROWS - 2){
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 0, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default: positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if(i==2 || i == ROWS - 3) {
                for (int j = 0; j < COLS; j++) {
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

            if(i==3 || i == ROWS - 4) {
                for (int j = 0; j < COLS; j++) {
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

            if(i==4 || i == ROWS - 5) {
                for (int j = 0; j < COLS; j++) {
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

            if(i==5 || i == ROWS - 6) {
                for (int j = 0; j < COLS; j++) {
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

    public void paintField(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                    paintCell(positions, i, j);
                }
            }
    }

    public void paintCell(Position[][] position, int col, int row){
        position[col][row].setRectangle(new Rectangle(colsToX(col), rowsToY(row), CELLSIZE, CELLSIZE));
        position[col][row].getRectangle().setColor(position[col][row].getType().color);
        position[col][row].getRectangle().fill();
    }

    public void paintInteractiveObject(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(positions[i][j].getType() == PositionObjectType.EMPTY){
                    positions[i][j].setInteractiveType(IsInteractiveObjectType.BEER);
                    paintBeer(positions,i,j);
                }
            }
        }
    }

    public void beerCounter(){
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (positions[i][j].getType() == PositionObjectType.PLAYER && positions[i][j].getInteractiveType() == IsInteractiveObjectType.BEER){
                    positions[i][j].setInteractiveType(IsInteractiveObjectType.EMPTY);
                    paintBeer(positions,i,j);
                    point++;
                    System.out.println(point);
                }
            }
        }
    }

    public void paintBeer(Position[][] position, int col, int row){
        position[col][row].setEllipse(new Ellipse(colsToX(col) + CELLSIZE/4, rowsToY(row) + CELLSIZE/4,CELLSIZE/2,CELLSIZE/2));
        position[col][row].getEllipse().setColor(position[col][row].getInteractiveType().color);
        position[col][row].getEllipse().fill();
    }
    public int getWidth(){
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int colsToX(int cols){
        return cols * CELLSIZE + PADDING;
    }

    public int rowsToY (int rows){
        return rows * CELLSIZE + PADDING;
    }

    public int getCOLS() {
        return COLS;
    }

    public int getROWS() {
        return ROWS;
    }

    public Position[][] getPositions() {
        return positions;
    }
}
