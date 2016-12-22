package com.example.android.camera2raw;

import android.Manifest;
import android.util.SparseIntArray;
import android.view.Surface;

public class StaticInfo {
    /**
     * Conversion from screen rotation to JPEG orientation.
     */
    static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    /**
     * Request code for camera permissions.
     */
    static final int REQUEST_CAMERA_PERMISSIONS = 1;
    /**
     * Permissions required to take a picture.
     */
    static final String[] CAMERA_PERMISSIONS = {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };
    /**
     * Timeout for the pre-capture sequence.
     */
    static final long PRECAPTURE_TIMEOUT_MS = 1000;
    /**
     * Tolerance when comparing aspect ratios.
     */
    static final double ASPECT_RATIO_TOLERANCE = 0.005;
    /**
     * Max preview width that is guaranteed by Camera2 API
     */
    static final int MAX_PREVIEW_WIDTH = 1920;
    /**
     * Max preview height that is guaranteed by Camera2 API
     */
    static final int MAX_PREVIEW_HEIGHT = 1080;

    static {
        StaticInfo.ORIENTATIONS.append(Surface.ROTATION_0, 0);
        StaticInfo.ORIENTATIONS.append(Surface.ROTATION_90, 90);
        StaticInfo.ORIENTATIONS.append(Surface.ROTATION_180, 180);
        StaticInfo.ORIENTATIONS.append(Surface.ROTATION_270, 270);
    }
}