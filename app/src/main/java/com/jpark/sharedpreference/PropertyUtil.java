package com.jpark.sharedpreference;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private String PROP_FILE = "sp.properties";
    private String internalStorage;
    private static PropertyUtil instatace = null;
    private static Context context;
    private PropertyUtil() {
        internalStorage = context.getFilesDir().getAbsolutePath();
    }
    public static PropertyUtil getInstatace(Context ctx) {
        context = ctx;
        if(instatace == null) {
            instatace = new PropertyUtil();
        }
        return instatace;
    }

    public void saveProperty(String key, String value) {
        Properties prop = new Properties();
        prop.put(key,value);
        try {
            FileOutputStream fos = new FileOutputStream(internalStorage+"/"+PROP_FILE);
            prop.store(fos, "comment");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getProperty(String key) {
        String value = "";
        Properties prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(internalStorage+"/"+PROP_FILE);
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        value = prop.getProperty(key);

        return value;
    }
}

