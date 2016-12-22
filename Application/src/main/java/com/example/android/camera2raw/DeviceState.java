package com.example.android.camera2raw;

public class DeviceState {
    /**
     * Camera state: Device is closed.
     */
    static final int STATE_CLOSED = 0;
    /**
     * Camera state: Device is opened, but is not capturing.
     */
    static final int STATE_OPENED = 1;
    /**
     * Camera state: Showing camera preview.
     */
    static final int STATE_PREVIEW = 2;
    /**
     * Camera state: Waiting for 3A convergence before capturing a photo.
     */
    static final int STATE_WAITING_FOR_3A_CONVERGENCE = 3;
}