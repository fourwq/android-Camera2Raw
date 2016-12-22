package com.example.android.camera2raw;

import android.util.Range;
import android.util.Size;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraInfoCheckerUtil {
    public CameraInfoCheckerUtil() {
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

    static String sizeArray2String(Size[] sizeArray) {
        StringBuilder builder = new StringBuilder();
        for (Size size : sizeArray) {
            builder.append(size.toString() + "  ");
        }
        return builder.toString();
    }

    static String rangeArray2String(Range[] rangeArray) {
        StringBuilder builder = new StringBuilder();
        for (Range range : rangeArray) {
            builder.append(range.toString() + "  ");
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