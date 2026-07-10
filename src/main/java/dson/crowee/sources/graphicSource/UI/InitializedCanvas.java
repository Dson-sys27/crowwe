package dson.crowee.sources.graphicSource.UI;

import dson.crowee.globals.Utilities;
import dson.crowee.sources.graphicSource.GraphicCoreManager;

import javax.swing.*;
import java.awt.*;


public class InitializedCanvas extends Canvas{
    private JFrame mainWindow;
    private GraphicCoreManager graphicCoreManager;
    public InitializedCanvas(){
        setUIOnExecution();
    }

    private void setUIOnExecution(){
        graphicCoreManager = GraphicCoreManager.getGraphicCoreManager();
        this.setPreferredSize(new Dimension(Utilities.WINDOW_WIDTH, Utilities.WINDOW_HEIGHT));

        mainWindow = new JFrame("crowee");
        mainWindow.setResizable(Boolean.FALSE);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(new BorderLayout());
        mainWindow.add(this, BorderLayout.CENTER);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.pack();
        mainWindow.setVisible(true);
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        graphicCoreManager.perform();
    }
}
