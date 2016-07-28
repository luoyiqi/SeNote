package com.senierr.senote.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.senierr.senote.R;
import com.senierr.senote.adapter.MainAdapter;
import com.senierr.senote.base.BaseActivity;
import com.senierr.senote.mode.Note;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private TextView indexTv;

    private MainAdapter mainAdapter;
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        indexTv = (TextView) findViewById(R.id.tv_index);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        noteList = new ArrayList<>();
        mainAdapter = new MainAdapter(this, noteList);
        recyclerView.setAdapter(mainAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                indexTv.setText("Position: " + firstPosition);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            Note note = new Note();
            note.setTitle("title: " + i);
            noteList.add(note);
            mainAdapter.notifyItemInserted(i);
        }
    }

}