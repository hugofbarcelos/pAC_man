package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

public class PlayerKeyboardHandler implements KeyboardHandler {

    Player player;

    public PlayerKeyboardHandler(Player player) {

        this.player = player;

        //keyboard is deaf
        Keyboard keyboard = new Keyboard(this);

        //create event
        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(down);
        keyboard.addEventListener(up);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if(player.fieldPositions[player.currentCol+1][player.currentRow].getType() == PositionObjectType.WALL) return;
                player.setCurrentDir(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                if(player.fieldPositions[player.currentCol-1][player.currentRow].getType() == PositionObjectType.WALL) return;
                player.setCurrentDir(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_DOWN:
                if(player.fieldPositions[player.currentCol][player.currentRow+1].getType() == PositionObjectType.WALL) return;
                player.setCurrentDir(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_UP:
                if(player.fieldPositions[player.currentCol][player.currentRow-1].getType() == PositionObjectType.WALL) return;
                player.setCurrentDir(Direction.UP);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
