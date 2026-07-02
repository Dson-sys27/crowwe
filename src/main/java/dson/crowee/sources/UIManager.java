package dson.crowee.sources;

import dson.crowee.obj.objects.UI.Canva;

import java.util.List;

public class UIManager implements Runnable{

    private static Thread graphicsControllerThread;
    private static volatile Boolean onExecution;
    private static List<Canva> canvasList;

    private static UIManager UIManager;

    public UIManager(){

    }

    public static synchronized void beginUIThread(){
        canvasList.add(new Canva());
        onExecution = Boolean.TRUE;
        startCroweeThread();
    }

    @Override
    public void run(){
        long updateReference = System.nanoTime();
        double spentTime;
        double delta = 0;
        while(onExecution)
        {
            final long loopInit = System.nanoTime();
            spentTime = loopInit - updateReference;
            updateReference = loopInit;
            delta += spentTime/Util.NS_PER_FRAME;
            while(delta <= 1){
                update();
                delta--;
            }
            perform();
        }
    }

    private void update(){

    }

    private void perform(){}

    private static void startCroweeThread(){
        if(UIManager == null)
            UIManager = new UIManager();
        graphicsControllerThread = new Thread(UIManager, "game");
        graphicsControllerThread.start();
    }

    public void stopUIThread() throws InterruptedException {
        onExecution = Boolean.FALSE;

        graphicsControllerThread.join();
    }

    public static Boolean getOnExecution(){
        return onExecution;
    }
}
