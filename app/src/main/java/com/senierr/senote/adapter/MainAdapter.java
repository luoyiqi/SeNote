package com.senierr.senote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.senierr.senote.R;
import com.senierr.senote.mode.Note;

import java.util.List;

/**
 * Created by zhouchunjie on 2016/07/08.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    // 单击事件
    private OnItemClickListener onItemClickListener;
    // 长按事件
    private OnItemLongClickListener onItemLongClickListener;

    private Context context;
    private LayoutInflater mInflater;

    private List<Note> noteList;

    public MainAdapter(Context context, List<Note> noteList) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.noteList = noteList;
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(noteList.get(position).getTitle());
    }

    public interface OnItemClickListener {
        void onItemClick(ViewHolder viewHolder, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(ViewHolder viewHolder, int position);
    }

    /**
     * 设置点击事件
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 设置长按点击事件
     * @param onItemLongClickListener
     */
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 普通布局
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            textView = (TextView) view.findViewById(R.id.tv_title);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this, getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLongClick(this, getLayoutPosition());
                return true;
            }
            return false;
        }
    }
}
