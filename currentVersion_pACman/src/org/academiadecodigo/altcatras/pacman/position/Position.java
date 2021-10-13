package org.academiadecodigo.altcatras.pacman.position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private PositionObjectType type;
    private IsInteractiveObjectType interactiveType;
    private Picture picture;

    public Position(){
        this.type = PositionObjectType.EMPTY;
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

    public void setPicture(Picture picture){
        this.picture = picture;
    }

    public Picture getPicture() {
        return this.picture;
    }

}
