package org.academiadecodigo.altcatras.pacman.position;

<<<<<<< HEAD
=======
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private PositionObjectType type;
    private Rectangle rectangle;
<<<<<<< HEAD
=======
    private IsInteractiveObjectType interactiveType;
    private Ellipse ellipse;
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b

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

<<<<<<< HEAD
=======
    public void setInteractiveType(IsInteractiveObjectType interactiveType) {
        this.interactiveType = interactiveType;
    }

    public IsInteractiveObjectType getInteractiveType(){
        return interactiveType;
    }

>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

<<<<<<< HEAD
    public Rectangle getRectangle() {
        return rectangle;
    }
=======

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
}
