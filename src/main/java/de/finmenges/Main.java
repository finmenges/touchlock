package de.finmenges;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.util.prefs.Preferences;

public class Main {
     public static Preferences preferences = Preferences.userRoot();
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.out.println("Init of Laf failed");
        }
        Frame frame = new Frame();
        Frame.setSignalColorStandard();
    }
}