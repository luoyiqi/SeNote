package com.senierr.senote.util;

import android.media.MediaRecorder;

import java.io.File;
import java.io.IOException;

/**
 * Created by Senierr on 2016/7/27.
 */
public class RecordUtil {

    private static final int SAMPLE_RATE_IN_HZ = 8000;
    private MediaRecorder recorder = new MediaRecorder();
    // 录音的路径
    private File file;

    public RecordUtil(File file) {
        this.file = file;
    }

    /**
     * 开始录音
     *
     * @throws IOException
     */
    public void start() {
        try {
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setAudioSamplingRate(SAMPLE_RATE_IN_HZ);
            recorder.setOutputFile(file.getPath());
            recorder.prepare();
            recorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束录音
     *
     * @throws IOException
     */
    public void stop() {
        recorder.stop();
        recorder.release();
    }

    /**
     * 获取录音时间
     *
     * @return
     */
    public double getAmplitude() {
        if (recorder != null) {
            return (recorder.getMaxAmplitude());
        }
        return 0;
    }

    /**
     * 获取录音文件
     *
     * @return
     */
    public File getRecordFile() {
        return file;
    }
}
