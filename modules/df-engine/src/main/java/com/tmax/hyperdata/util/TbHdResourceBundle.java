package com.tmax.hyperdata.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class TbHdResourceBundle {
    private ResourceBundle bundle;

    public TbHdResourceBundle(String file) {
        bundle = ResourceBundle.getBundle(file, Locale.US);
    }

    public static String getKey(int code) {
        return Integer.toString(code);
    }

    public String getValue(int code) {
        return bundle.getString(getKey(code));
        
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}