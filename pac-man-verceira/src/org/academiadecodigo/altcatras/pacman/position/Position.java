package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private PositionObjectType type;
    private Rectangle rectangle;

    public Position(){
        this.type = PositionObjectType.EMPTY;
    }

    public Position(PositionObjectType type){
        this.type = type;
    }

    public void setType(PositionObjectType type) {
        this.type = type;
    }

    public PositionObjectType getType() {
        return type;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
