package dson.crowee.sources.keyboardHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private static boolean[] keyCatalogue;
    private static KeyboardListener keyboardListener;

    public static void initializeKeyboardListener(){
        keyboardListener = new KeyboardListener();
        keyCatalogue = new boolean[Util.LARGEST_KEY_CODE];
        for(int i = 0; i < Util.LARGEST_KEY_CODE; i++)
            keyCatalogue[i] = Boolean.FALSE;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyCatalogue[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyCatalogue[e.getKeyCode()] = false;
    }

    public static boolean getKey(int keyCode){
        return keyCatalogue[keyCode];
    }

    public static KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }
}
