package de.finmenges;

import java.io.File;
import java.io.PrintWriter;
import java.util.prefs.Preferences;

import static de.finmenges.Main.preferences;

public class ConfWriter {
    private String path;
    private final static String touchConf = "TOUCHLOCK-CONFIG";
    public static void createConfigFolder(String path) {
        System.out.println(path.length());
        if (!((path.charAt(path.length()-1))=='/')) {
            path = path + "/";
        }
        if ((path.charAt(path.length()-1))=='/') {
            path = path + touchConf;
        }


        File configPath = new File(path);
        if (!configPath.exists()) configPath.mkdirs();
        preferences.put("configPath", path.replace("TOUCHLOCK-CONFIG", ""));
        System.out.println(path);

    }
}
