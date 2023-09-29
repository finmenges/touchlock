package de.finmenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.prefs.Preferences;

import static de.finmenges.Main.preferences;

public class ConfWriter {
    private static String globalPath;
    private final static String touchConf = "TOUCHLOCK-CONFIG";
    public static void createConfigFolder(String path) {
        System.out.println(path.length());
        if (!((path.charAt(path.length()-1))=='/')) {
            path = path + "/";
        }
        if ((path.charAt(path.length()-1))=='/') {
            path = path + touchConf + "/";
        }
        globalPath = path;

        File configPath = new File(path);
        if (!configPath.exists()) configPath.mkdirs();
        preferences.put("configPath", path);
        preferences.putBoolean("alreadyConfigured", true);
        System.out.println(path);

    }

    public static void createConfigFiles() {
        try {
            PrintWriter tuschfernbedienung = new PrintWriter(globalPath+"tuschfernbedienung-tl.txt", "UTF-8");
            tuschfernbedienung.close();
            PrintWriter tpbenachichtigungen = new PrintWriter(globalPath+"tpbenachichtigungen-tl.txt", "UTF-8");
            tpbenachichtigungen.close();
            PrintWriter messagesfromtp = new PrintWriter(globalPath+"messagesfromtp-tl.txt", "UTF-8");
            messagesfromtp.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ignored){}
    }

}
