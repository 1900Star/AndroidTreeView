package com.example.androidtreeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<NodeBean> mNodeList = getNodeList();
        TreeViewAdatper treeViewAdatper = new TreeViewAdatper(this, mNodeList);
        mRecyclerView.setAdapter(treeViewAdatper);
        treeViewAdatper.setListener(new TreeViewAdatper.OnItemClickListener() {
            @Override
            public void itemClick(NodeBean bean) {
                Log.d("lsp", bean.toString());
            }
        });
    }

    private List<NodeBean> getNodeList() {
        List<NodeBean> nodeBeanList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            nodeBeanList.add(new NodeBean(1, 1,false));
        }
        for (int i = 0; i < 8; i++) {
            nodeBeanList.add(new NodeBean(2, 1,i % 2 == 0));
        }
        for (int i = 0; i < 10; i++) {
            nodeBeanList.add(new NodeBean(3, 1,i % 2 == 0));
        }
        for (int i = 0; i < 6; i++) {
            nodeBeanList.add(new NodeBean(4, 1,i % 2 == 0));
        }
        return nodeBeanList;
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(divider);
    }
}
