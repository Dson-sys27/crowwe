package dson.crowee.sources.graphicSource;

import dson.crowee.globals.LogViews;
import dson.crowee.obj.objects.UI.InitializedCanvas;
import dson.crowee.sources.keyboardHandler.KeyboardListener;
import dson.crowee.sources.entityControllers.PlayerKeyEventManager;

import javax.imageio.ImageIO;
import java.awt.*;
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
            delta += spentTime/ Util.NS_PER_FRAME;
            while(delta >= 1){
                update();
                delta--;
            }
            perform();
        }
    }

    private void update(){
        //TODO
        //KeyEvents
        PlayerKeyEventManager.updatePlayerAction();
    }

    public void perform(){     //To manage what the screen shows

        int spriteSize = Util.SPRITE_SIZE * Util.SCALE_SIZE;

        if(canvas.getBufferStrategy() == null)
            canvas.createBufferStrategy(3);
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        BufferedImage image = null;
        BufferedImage player = null;
        try{
            image = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\euclideus_floor.png"));
            player = ImageIO.read(new File("C:\\Users\\david\\Documents\\Java Projects\\croww\\src\\main\\resources\\sprites\\bg\\player\\davdrak.png"));
        }catch(IOException e){
            LogViews.dropGraphicsCoreWarning("");
        }

        for(int i = 0; i < Util.SCREEN_HEIGHT; i += Util.SPRITE_SIZE)
            for(int j = 0; j < Util.SCREEN_WIDTH; j += Util.SPRITE_SIZE)
                graphics.drawImage(image, j, i, spriteSize, spriteSize, null);

        graphics.drawImage(player, (int)PlayerKeyEventManager.getX(), (int)PlayerKeyEventManager.getY(), spriteSize, spriteSize, null);

        graphics.dispose();
        bufferStrategy.show();
    }

    //getters / setters

    public static Boolean getOnExecution(){
        return onExecution;
    }

    public static GraphicCoreManager getGraphicCoreManager(){
        return graphicCoreManager;
    }
}
