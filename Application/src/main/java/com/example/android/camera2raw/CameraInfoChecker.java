package com.example.android.camera2raw;

import android.hardware.camera2.CameraManager;

/**
 * Created by camera1 on 2016/12/21.
 */

public class CameraInfoChecker {
    private CameraManager mCameraManager;//// TODO: 2016/12/21 长期持有CameraManager可能导致泄露问题
    public CameraInfoChecker(CameraManager manager) {
        mCameraManager = manager;
    }

    public  static  void check(){

    }
}
