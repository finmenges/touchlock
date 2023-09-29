package de.finmenges;

public class Signals {
    static boolean run = false;
    public static void blinkingButton() {
        run = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    try {
                        Frame.setSignalColorRed();
                        Thread.sleep(1000);
                        Frame.setSignalColorStandard();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } while (run);
            }

        });
        thread.start();
    }
    public static void stopBlinkingButton(){
        run = false;
    }
}
