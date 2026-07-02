package dson.crowee.obj.objects.UI;

import dson.crowee.obj.objects.UI.Util;
import dson.crowee.sources.UIManager;

import javax.swing.*;
import java.awt.*;


public class Canva extends Canvas{
    private JFrame mainWindow;
    public Canva(){
        setUIOnExecution();
    }

    private void setUIOnExecution(){
        this.setPreferredSize(new Dimension(Util.WINDOW_WIDTH, Util.WINDOW_HEIGHT));

        mainWindow = new JFrame("crowee");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new BorderLayout());
        mainWindow.add(this, BorderLayout.CENTER);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics){

    }
}
