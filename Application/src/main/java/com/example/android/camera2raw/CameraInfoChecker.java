package com.example.android.camera2raw;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Environment;
import android.util.Range;
import android.util.Size;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by qwei on 2016/12/21.
 */

public class CameraInfoChecker {
    private CameraManager mCameraManager;//// TODO: 2016/12/21 长期持有CameraManager可能导致泄露问题
    private String[] mCameraIdList;
    private HashMap<String, CameraCharacteristics> mCameraCharacMap = new HashMap<>();
    private HashMap<String, String> mCameraInfo = new HashMap<>();

    private static final String FILE_NAME =  "camera_charac_info.txt";

    public CameraInfoChecker(CameraManager manager) {
        mCameraManager = manager;
    }

    public   void check(){
        initCameraIds();
        initCameraCharacteristics();
        printAllCharacInfoToFile();

    }

    private void printAllCharacInfoToFile() {
        StringBuilder builder = new StringBuilder();
        Set<String> nameSet = mCameraCharacMap.keySet();
        initFileHeader(builder);
        for (String name : nameSet) {
            builder.append("for Camera: " + name + "\n");
            CameraCharacteristics charac = mCameraCharacMap.get(name);
            List<CameraCharacteristics.Key<?>> mKeyList = charac.getKeys();
            for (CameraCharacteristics.Key<?> key : mKeyList) {
                reformatKeys(key, charac.get(key), builder);
            }

        }

        storeInFile(builder.toString());
    }

    private void initFileHeader(StringBuilder builder) {
        builder.append("created by weiqiang on "+ CameraInfoCheckerUtil.getDate() +"\n"
        +"refer android api level: 23 \n"
        +"device: "+ Build.DEVICE+"\n"
        );
    }

    private void reformatKeys(CameraCharacteristics.Key<?> key, Object o, StringBuilder builder) {
        if(o instanceof int[]) {
            builder.append(key.getName() + " : " + CameraInfoCheckerUtil.intArray2String((int[]) o) + "\n");
        }else if(o instanceof Range[]){
            builder.append(key.getName() + " : " + CameraInfoCheckerUtil.rangeArray2String((Range[]) o) + "\n");
        }else if(o instanceof Size[]){
            builder.append(key.getName() + " : " + CameraInfoCheckerUtil.sizeArray2String((Size[]) o) + "\n");
        }else if(o instanceof float[]){
            builder.append(key.getName() + " : " + CameraInfoCheckerUtil.floatArray2String((float[]) o) + "\n");
        }else if(o instanceof boolean[]){
            builder.append(key.getName() + " : " + CameraInfoCheckerUtil.booleanArray2String((boolean[]) o) + "\n");

        }else{
            builder.append(key.getName() + " : " + o.toString() + "\n");
        }
    }

    private void storeInFile(String info) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(),
                    FILE_NAME);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(info.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initCameraCharacteristics() {
        for (String cameraId : mCameraIdList) {
            try {
                mCameraCharacMap.put(cameraId, mCameraManager.getCameraCharacteristics(cameraId));
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void initCameraIds() {
        try {
            mCameraIdList = mCameraManager.getCameraIdList();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
