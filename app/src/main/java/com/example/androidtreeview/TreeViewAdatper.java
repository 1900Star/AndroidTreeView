package com.example.androidtreeview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author luoshipeng
 * createDate：2019/7/22 0022 17:43
 * className   TreeViewAdatper
 * Des：TODO
 */
public class TreeViewAdatper extends RecyclerView.Adapter<TreeViewAdatper.TreeViewHolder> {
    private Context mContext;
    private List<NodeBean> mNodeBeanList;

    public TreeViewAdatper(Context context, List<NodeBean> nodeBeanList) {
        mContext = context;
        mNodeBeanList = nodeBeanList;
    }

    @NonNull
    @Override
    public TreeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_tree_view, viewGroup, false);
        return new TreeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TreeViewHolder treeViewHolder, int i) {
        final NodeBean nodeBean = mNodeBeanList.get(i);
        treeViewHolder.mIv.setImageResource(nodeBean.isOpen() ? R.drawable.tree_open : R.drawable.tree_close);
        treeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.itemClick(nodeBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNodeBeanList != null ? mNodeBeanList.size() : 0;
    }

    class TreeViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;
        private final TextView mTextView;

        public TreeViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv_close);
            mTextView = itemView.findViewById(R.id.tv);
        }
    }

    private OnItemClickListener mListener;

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        void itemClick(NodeBean bean);


    }

}
