package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PositionObjectType {

    WALL (Color.BLACK),
    SPAWNER(Color.PINK),
    PLAYER(Color.GREEN),
    GHOST(Color.BLUE),
    EMPTY(Color.WHITE);

    Color color;
    Picture picture;


    PositionObjectType(Color color){
        this.color = color;

    }

    PositionObjectType(Picture picture){
        this.picture = picture;
    }

    public Color getColor() {
        return color;
    }
}
