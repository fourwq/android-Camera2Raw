package com.example.android.camera2raw;

import android.util.Size;

import java.util.Comparator;

/**
 * Created by camera1 on 2016/12/21.
 */
public class CompareSizesByArea implements Comparator<Size> {
    /**
     * Comparator based on area of the given {@link Size} objects.
     */

        @Override
        public int compare(Size lhs, Size rhs) {
            // We cast here to ensure the multiplications won't overflow
            return Long.signum((long) lhs.getWidth() * lhs.getHeight() -
                    (long) rhs.getWidth() * rhs.getHeight());
        }


}
