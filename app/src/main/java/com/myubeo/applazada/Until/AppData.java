package com.myubeo.applazada.Until;

public class AppData {
    public final static String LOCALE_VI_VN = "vi-VN";
    public final static String LOCALE_VI = "vi";
    public final static String LOCALE_EN = "en";
    public static String language = LOCALE_VI_VN;
    private static AppData instance = new AppData();

    public static AppData getInstance() {
        return instance;
    }
}
