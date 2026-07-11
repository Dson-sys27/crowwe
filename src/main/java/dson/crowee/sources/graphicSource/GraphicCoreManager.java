package dson.crowee.sources.graphicSource;

import dson.crowee.globals.LogViews;
import dson.crowee.globals.Utilities;
import dson.crowee.obj.objects.PlayerCharacter;
import dson.crowee.sources.colliderSystem.CollisionManager;
import dson.crowee.sources.graphicSource.UI.InitializedCanvas;
import dson.crowee.sources.graphicSource.singleGraphicManagers.PlayerCharacterGraphicsController;
import dson.crowee.sources.graphicSource.singleGraphicManagers.PropsGraphicsController;
import dson.crowee.sources.graphicSource.singleGraphicManagers.UIGraphicsManager;
import dson.crowee.sources.graphicSource.singleGraphicManagers.WorldMapGraphicsManager;
import dson.crowee.sources.keyboardHandler.KeyboardListener;
import dson.crowee.sources.entityControllers.PlayerEventManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicCoreManager implements Runnable{

    private static GraphicCoreManager graphicCoreManager;
    private static Thread graphicsControllerThread;
    private static volatile Boolean onExecution;
    private static InitializedCanvas canvas;

    public GraphicCoreManager(){

    }

    public static void setGraphicCoreManagerOnWork(){
        if(graphicCoreManager == null)
            graphicCoreManager = new GraphicCoreManager();
        beginUIThread();
    }

    private static synchronized void beginUIThread(){
        //TODO: UI Builds
        canvas = new InitializedCanvas();

        onExecution = Boolean.TRUE;

        graphicsControllerThread = new Thread(graphicCoreManager, "game");
        graphicsControllerThread.start();
    }

    public synchronized void stopUIThread() throws InterruptedException {
        onExecution = Boolean.FALSE;
        graphicsControllerThread.join();
    }

    @Override
    public void run(){
        long updateReference = System.nanoTime();
        double spentTime;
        double delta = 0;

        canvas.addKeyListener(KeyboardListener.getKeyboardListener());
        canvas.requestFocus();

        while(onExecution)
        {
            final long loopInit = System.nanoTime();
            spentTime = loopInit - updateReference;
            updateReference = loopInit;
            delta += spentTime/ Utilities.NS_PER_FRAME;
            while(delta >= 1){
                update();
                delta--;
            }
            perform();
        }
    }

    private void update(){
        //All game updates
        PlayerEventManager.updatePlayerAction();
        CollisionManager.processSignals();
    }

    public void perform(){     //To manage what the screen shows

        if(canvas.getBufferStrategy() == null)
            canvas.createBufferStrategy(3);
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();

        PlayerCharacter player = PlayerCharacterGraphicsController.getPlayerCharacter();

        int camX = player.getX() - (Utilities.SCREEN_WIDTH / 2) + (Utilities.SPRITE_SIZE / 2);
        int camY = player.getY() - (Utilities.SCREEN_HEIGHT / 2) + (Utilities.SPRITE_SIZE / 2);

        AffineTransform originalCameraPosition = graphics.getTransform();

        graphics.translate(-camX, -camY);

        WorldMapGraphicsManager.drawWorldMap(graphics);
        PlayerCharacterGraphicsController.drawObject(graphics);
        PropsGraphicsController.drawObjects(graphics);

        graphics.setTransform(originalCameraPosition);

        UIGraphicsManager.drawUIObjects(graphics);

        graphics.dispose();
        bufferStrategy.show();

        graphics.clearRect(0, 0, Utilities.SCREEN_WIDTH, Utilities.SCREEN_HEIGHT);
    }

    //getters / setters

    public static Boolean getOnExecution(){
        return onExecution;
    }

    public static GraphicCoreManager getGraphicCoreManager(){
        return graphicCoreManager;
    }
}
