package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Color;

public enum PositionObjectType {

    WALL (Color.BLACK),
    SPAWNER(Color.PINK),
    PLAYER(Color.GREEN),
    GHOST(Color.BLUE),
    EMPTY(Color.WHITE);

    Color color;

    PositionObjectType(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
