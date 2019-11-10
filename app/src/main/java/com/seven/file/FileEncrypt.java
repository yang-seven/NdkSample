package com.seven.file;

import android.os.Environment;

import java.io.File;

/**
 * Time:2019/11/10
 * <p>
 * Author:seven
 * <p>
 * Description: 文件加解密
 */
public class FileEncrypt {

    public static final String NORMAL_PATH= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator
            +"liuyan.png";

    public static final String ENCRYPT_PATH=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator
            +"liuyanecry.png";


    public static final String DECRYPT_PATH=Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator
            +"liuyandecry.png";

    static {
        System.loadLibrary("encrypt");
    }

    /**
     * 文件加密
     * @param normalPath 原始路径
     * @param enCryptPath 加密路径
     */
    public static native void encypt(String normalPath, String enCryptPath);

    /**
     *  文件解密
     * @param enCryptPath 加密路径
     * @param deCryptPath 解密路径
     */
    public static native void deEncrypt(String enCryptPath, String deCryptPath);

}
