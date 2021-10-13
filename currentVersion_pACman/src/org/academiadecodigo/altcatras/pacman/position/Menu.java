package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Menu implements KeyboardHandler {

    Rectangle rectangle1;

    private static boolean startFlag = false;

    public Menu(int width, int height) {
        rectangle1 = new Rectangle(10, 10, width, height);
        rectangle1.setColor(Color.BLUE);
        rectangle1.fill();


        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);


    }





    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            System.out.println("space");
            startFlag = true;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isStart() {
        return startFlag;
    }

    public void changeFlag(){
        this.startFlag = false;
    }
}
