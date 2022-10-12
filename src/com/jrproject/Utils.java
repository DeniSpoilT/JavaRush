package com.jrproject;

public class Utils {
    public static String addOperationToFileName(String path, String operation) { // переписать чтоб менял с последнего символа;
        StringBuilder sb = new StringBuilder(path);
        sb.insert(sb.lastIndexOf("."),  operation);
        return sb.toString();
    }
}
