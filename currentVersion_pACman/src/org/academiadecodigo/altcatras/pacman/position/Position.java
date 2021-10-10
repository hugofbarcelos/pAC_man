package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private PositionObjectType type;
    private Rectangle rectangle;
    private IsInteractiveObjectType interactiveType;
    private Ellipse ellipse;

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

    public void setInteractiveType(IsInteractiveObjectType interactiveType) {
        this.interactiveType = interactiveType;
    }

    public IsInteractiveObjectType getInteractiveType(){
        return interactiveType;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }


    public Rectangle getRectangle() {
        return rectangle;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }
}
