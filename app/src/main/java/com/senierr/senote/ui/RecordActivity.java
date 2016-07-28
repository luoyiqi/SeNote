package com.senierr.senote.ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.senierr.senote.R;
import com.senierr.senote.util.RecordUtil;
import com.senierr.senote.util.SystemUtil;

public class RecordActivity extends AppCompatActivity {
    private Button startBtn;
    private Button stopBtn;
    private ListView listView;

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
        startBtn = (Button) findViewById(R.id.btn_start);
        stopBtn = (Button) findViewById(R.id.btn_stop);

        /*按钮状态*/
        startBtn.setEnabled(true);
        stopBtn.setEnabled(false);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordUtil.start();
                startBtn.setEnabled(false);
                stopBtn.setEnabled(true);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordUtil.stop();
                startBtn.setEnabled(true);
                stopBtn.setEnabled(false);

                mMusicList.add(recordUtil.getRecordFile().getPath());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mMusicList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playMusic(mMusicList.get(position));
            }
        });

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