package com.example.mycommunity.imgService;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.io.File;

public class ImageService {
    public final static int TAKE_PHOTO = 578;
    public final static int LOAD_IMG = 845;
    private Uri imgUri;
    private Context context;

    public ImageService(Context context, Uri imgUri) {
        this.context = context;
        this.imgUri = imgUri;
    }

    public void takePhoto() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
        ((Activity) context).startActivityForResult(intent, TAKE_PHOTO);
    }

    public void loadImg() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(((Activity) context),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    5);
        } else {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            ((Activity)context).startActivityForResult(intent, LOAD_IMG);
        }
    }

}
