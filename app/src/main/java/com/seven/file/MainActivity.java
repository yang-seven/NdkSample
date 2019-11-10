package com.seven.file;

import android.Manifest;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accessPermission();
        Log.d(TAG, "encrypt: " + FileEncrypt.NORMAL_PATH);
    }

    private void accessPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 0x21);
        }

    }

    public void encrypt(View view) {
        Log.d(TAG, "encrypt: " + FileEncrypt.NORMAL_PATH);
        FileEncrypt.encypt(FileEncrypt.NORMAL_PATH, FileEncrypt.ENCRYPT_PATH);
        Toast.makeText(this, "加密成功！", Toast.LENGTH_SHORT).show();

    }

    public void decrypt(View view) {
        FileEncrypt.deEncrypt(FileEncrypt.ENCRYPT_PATH, FileEncrypt.DECRYPT_PATH);
        Toast.makeText(this, "解密成功！", Toast.LENGTH_SHORT).show();
    }
}
