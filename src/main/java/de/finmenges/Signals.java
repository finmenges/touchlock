package de.finmenges;

public class Signals {
    static boolean run = false;
    public static void blinkingButton() {
        run = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Frame.setSignalColorRed();
                        Thread.sleep(1000);
                        Frame.setSignalColorStandart();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (run==false) {
                        break;
                    }
                }
            }

        });
        thread.start();
    }
    public static void stopBlinkingButton(){
        run = false;
    }
}
