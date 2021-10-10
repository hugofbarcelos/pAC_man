package org.academiadecodigo.altcatras.pacman.position;


import org.academiadecodigo.simplegraphics.graphics.Color;

public enum IsInteractiveObjectType {

    BEER(Color.YELLOW),
    POWERUP(Color.MAGENTA),
    EMPTY(Color.RED);

    Color color;

    IsInteractiveObjectType(Color color){
        this.color = color;
    }
}
