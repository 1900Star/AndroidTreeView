package com.example.androidtreeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

            }
        });
    }

    private List<NodeBean> getNodeList() {
        List<NodeBean> nodeBeanList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            nodeBeanList.add(new NodeBean(i, i % 2 == 0));
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
