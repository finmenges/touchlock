package de.finmenges;

import javax.swing.*;
import java.awt.*;

import static de.finmenges.Main.preferences;

public class Frame extends JFrame {
    static JButton signal = new JButton();
    String _standardTextConfigFolderPathInput = "Pfad für Configfolder hier einfügen...";
    public Frame() {

        if (!preferences.get("configPath", "").isEmpty()) {
            _standardTextConfigFolderPathInput = preferences.get("configPath", "");
        }

        //creating the window
        this.setSize(470, 380);
        this.setLayout(null);
        this.setTitle("remotelocker");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);

        //create lock option for tusch
        JLabel tuschText = new JLabel("Tusch");
        tuschText.setBounds(20,55,70,35);
        this.add(tuschText);

        JTextField pathInput = new JTextField(_standardTextConfigFolderPathInput);
        pathInput.setBounds(10,20,300,25);
        this.add(pathInput);

        JButton renewPath = new JButton("R");
        renewPath.setBounds(420,20,25,25);
        this.add(renewPath);

        JButton confirmPathChange = new JButton("Bestätigen");
        confirmPathChange.setBounds(320,20,90,25);
        this.add(confirmPathChange);

        //radiobuttons for Tuschfernbedienung
        JRadioButton option1_lock = new JRadioButton("Tuschfernbedienung deaktiviert");
        JRadioButton option1_unlock = new JRadioButton("Tuschfernbedienung aktiviert");
        this.add(option1_lock); this.add(option1_unlock);

        option1_lock.setBounds(19,80,200,35);
        option1_unlock.setBounds(219,80,200,35);


        ButtonGroup tuschGroup = new ButtonGroup();

        tuschGroup.add(option1_lock);
        tuschGroup.add(option1_unlock);

        JLabel nachichtText = new JLabel("TP Benachichtigungen");
        nachichtText.setBounds(20,115,200,35);
        this.add(nachichtText);

        // radiobuttons for TP Benarichtigungen
        JRadioButton option2_deactivate = new JRadioButton("TP Benachichtigungen deaktiviert");
        JRadioButton option2_activate = new JRadioButton("TP Benachichtigungen aktiviert");
        this.add(option2_deactivate); this.add(option2_activate);

        option2_deactivate.setBounds(19,140,200,35);
        option2_activate.setBounds(219,140,200,35);

        ButtonGroup tpmessagesGroup = new ButtonGroup();
        tpmessagesGroup.add(option2_deactivate);
        tpmessagesGroup.add(option2_activate);

        //textarea for messages
        JTextArea messageArea = new JTextArea("Currently no message.");
        messageArea.setBounds(19,180,400,100);
        this.add(messageArea);

        //signalbutton
        signal.setBounds(19,300,400,30);
        this.add(signal);

        //make window visible after loading
        this.setVisible(true);


        //listeners
        renewPath.addActionListener(a -> {
            pathInput.setEnabled(true);
        });
        confirmPathChange.addActionListener(a -> {
            if (!pathInput.getText().equals("Pfad für Configfolder hier einfügen...")) {
                ConfWriter.createConfigFolder(pathInput.getText());
                pathInput.setEnabled(false);
            }
        });
        signal.addActionListener(a -> {
            Signals.stopBlinkingButton();
            messageArea.setText("Currently no message");
        });

    }
    //some methods to set color of signal
    public static void setSignalColorGreen(){
        signal.setBackground(Color.GREEN);
    }
    public static void setSignalColorRed() {
        signal.setBackground(Color.RED);
        signal.setText("Press");
    }
    public static void setSignalColorStandard() {
        signal.setBackground(Color.darkGray);
    }
}
