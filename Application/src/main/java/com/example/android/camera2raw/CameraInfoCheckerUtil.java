package com.example.android.camera2raw;

import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Range;
import android.util.Size;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraInfoCheckerUtil {
    public CameraInfoCheckerUtil() {
    }

    static <T> String objectArray2String(T[] array){
        StringBuilder builder = new StringBuilder();
        for (T item : array) {
            builder.append(item.toString() + "  ");
        }
        return builder.toString();
    }


    static String booleanArray2String(boolean[] booleanArray) {
        StringBuilder builder = new StringBuilder();
        for (boolean b : booleanArray) {
            builder.append(b + "  ");
        }
        return builder.toString();
    }

    static String floatArray2String(float[] floatArray) {
        StringBuilder builder = new StringBuilder();
        for (float f : floatArray) {
            builder.append(f + "  ");
        }
        return builder.toString();
    }

    static String intArray2String(int[] intArray) {
        StringBuilder builder = new StringBuilder();
        for (int i : intArray) {
            builder.append(i + "  ");
        }
        return builder.toString();
    }

    static String getDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
        String date = sDateFormat.format(new Date());
        return date;
    }
}