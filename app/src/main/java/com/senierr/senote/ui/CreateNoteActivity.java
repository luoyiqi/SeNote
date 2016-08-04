package com.senierr.senote.ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.senierr.senote.R;
import com.senierr.senote.util.RecordUtil;
import com.senierr.senote.util.SystemUtil;

public class CreateNoteActivity extends AppCompatActivity {

    private EditText contentView;
    private Button voiceBtn;
    private ImageView[] gridImages;
    private ImageButton cameraBtn;
    private ImageButton localBtn;
    private Button recordBtn;

    private ArrayAdapter<String> arrayAdapter;
    private List<String> mMusicList = new ArrayList<>();// 录音文件列表

    private RecordUtil recordUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        initView();
        recordUtil = new RecordUtil(SystemUtil.getDiskCacheFile(this, "Recorder_" + System.currentTimeMillis() + ".amr"));
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        contentView = (EditText) findViewById(R.id.tv_content);
        voiceBtn = (Button) findViewById(R.id.btn_voice);
        cameraBtn = (ImageButton) findViewById(R.id.btn_camera);
        localBtn = (ImageButton) findViewById(R.id.btn_local);
        recordBtn = (Button) findViewById(R.id.btn_record);
        ImageView gridImage1 = (ImageView) findViewById(R.id.tl_iv_1);
        ImageView gridImage2 = (ImageView) findViewById(R.id.tl_iv_2);
        ImageView gridImage3 = (ImageView) findViewById(R.id.tl_iv_3);
        ImageView gridImage4 = (ImageView) findViewById(R.id.tl_iv_4);
        ImageView gridImage5 = (ImageView) findViewById(R.id.tl_iv_5);
        ImageView gridImage6 = (ImageView) findViewById(R.id.tl_iv_6);
        ImageView gridImage7 = (ImageView) findViewById(R.id.tl_iv_7);
        ImageView gridImage8 = (ImageView) findViewById(R.id.tl_iv_8);
        ImageView gridImage9 = (ImageView) findViewById(R.id.tl_iv_9);
        gridImages = new ImageView[9];
        gridImages[0] = gridImage1;
        gridImages[1] = gridImage2;
        gridImages[2] = gridImage3;
        gridImages[3] = gridImage4;
        gridImages[4] = gridImage5;
        gridImages[5] = gridImage6;
        gridImages[6] = gridImage7;
        gridImages[7] = gridImage8;
        gridImages[8] = gridImage9;


    }

    /* 播放录音文件 */
    private void playMusic(String fileName) {
        try{
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(fileName);
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                }
            });
        }catch(IOException e){
            Log.e("playMusic", "播放失败");
        }
    }

}