package com.senierr.senote.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Senierr on 2016/7/27.
 */
public class SystemUtil {

    /**
     * 获取缓存文件
     *
     * @param uniqueName
     * @return 缓存文件地址
     */
    public static File getDiskCacheFile(Context context, String uniqueName) {
        String cachePath;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }
}
