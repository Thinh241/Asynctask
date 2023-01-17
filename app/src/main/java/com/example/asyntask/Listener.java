package com.example.asyntask;

import android.graphics.Bitmap;

public interface Listener {
    void onImageDownload(Bitmap bitmap);
    void onError();
}
