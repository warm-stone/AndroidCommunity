package com.example.mycommunity.mine.userImg;

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bumptech.glide.Glide;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.example.mycommunity.MyPopWheel;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.imgService.ReturnImgMsg;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class SelectUserImgActivity extends AppCompatActivity {

    private static final int TAKE_PHOTO = 0;
    private static final int CHOOSE_PHOTO = 1;
    private static int action = -1;
    private static int which = -1;
    private Uri imgUri;
    private ImageView userBackground;
    private CircleImageView userImg;
    private File imgHolder;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            ReturnImgMsg imgMsg = null;
            String url = null;
            try {
                imgMsg = new Gson().fromJson((String) msg.obj, ReturnImgMsg.class);
                url = imgMsg.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (msg.what) {
                case 0:
                    if (which == 1) {
                        Glide.with(SelectUserImgActivity.this).load(url).placeholder(R.drawable.ic_error_ic).into(userImg);
                    } else if (which == 2) {
                        Glide.with(SelectUserImgActivity.this).load(url).placeholder(R.drawable.ic_error_ic).into(userBackground);
                    }
                    which = -1;
                    break;
                case 1:
                    UserNotice.showToast(SelectUserImgActivity.this, UserNotice.NETWORK_CONNECT_FAILURE);
                    break;
                case 2:
                    UserNotice.showToast(SelectUserImgActivity.this, UserNotice.USER_AUTHENTICATION_FAILURE);
                    break;
                case 3:
                    netRequest();
                    break;
                case 4:
                    UserNotice.showToast(SelectUserImgActivity.this, imgMsg.getMessage());
                    break;
                default:
                    UserNotice.showToast(SelectUserImgActivity.this, UserNotice.UNEXPECTED_STATE);
            }
            return false;
        }
    });

    private void takePhoto() {
        imgHolder = new File(getExternalFilesDir(MediaStore.Images.Media.MIME_TYPE), "output_img.jpg");
        imgUri = FileProvider.getUriForFile(SelectUserImgActivity.this, "com.example.selectuserimg.fileprovider", imgHolder);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
        startActivityForResult(intent, TAKE_PHOTO);
    }

    private void choosePhoto() {
        if (ContextCompat.checkSelfPermission(SelectUserImgActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SelectUserImgActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            openAlbum();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user_img);
        initView();
    }

    private void initView() {
        userImg = findViewById(R.id.user_img_user_ic);
        userBackground = findViewById(R.id.user_img_background);
        final MyPopWheel myPopWheel = new MyPopWheel(this);
        View view = myPopWheel.getSelector();
        TextView selectCancel = view.findViewById(R.id.wheel_item_select_cancel);
        TextView selectConfirm = view.findViewById(R.id.wheel_item_select_confirm);
        WheelView wheelView = view.findViewById(R.id.wheel_item_wheel);
        selectCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = -1;
                myPopWheel.popOut();
            }
        });
        selectConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPopWheel.popOut();
                if (action == TAKE_PHOTO) {
                    takePhoto();
                } else if (action == CHOOSE_PHOTO) {
                    choosePhoto();
                }
            }
        });
        wheelView.setCyclic(false);
        wheelView.setAdapter(new ArrayWheelAdapter<>(new ArrayList<String>(Arrays.asList("拍照", "相册选取"))));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                action = index;
            }
        });
        userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                which = 1;
                myPopWheel.popIn(v);
            }
        });
        userBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                which = 2;
                myPopWheel.popIn(v);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        switch (requestCode) {
            case 1:
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    UserNotice.showToast(this, "请允许应用访问相册");
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imgUri));
                    } catch (FileNotFoundException e) {
                        Log.w("test", e);
                    }
                }
                break;
            case CHOOSE_PHOTO:
                if (resultCode == RESULT_OK) {
                    String path = handleImgOnKitKat(data);
                    imgHolder = new File(path);
                }
                break;
            default:
                imgHolder = null;
        }
        if (imgHolder != null) {
            netRequest();
        }


    }

    private String handleImgOnKitKat(Intent data) {
        String imgPath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String select = MediaStore.Images.Media._ID + "=" + id;
                imgPath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, select);
            } else if ("com.android.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                getImagePath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imgPath = getImagePath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            imgPath = uri.getPath();
        }
        return imgPath;
    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, CHOOSE_PHOTO);
    }

    private String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }

        return path;
    }

    private void netRequest() {
        new NetworkModule().postImg("/file/uploads", "jpg", imgHolder, handler, this);
    }

}
