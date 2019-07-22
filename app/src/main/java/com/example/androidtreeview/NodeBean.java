package com.example.androidtreeview;

/**
 * @author luoshipeng
 * createDate：2019/7/22 0022 17:45
 * className   NodeBean
 * Des：TODO
 */
public class NodeBean {
    private int rank;
    private boolean isOpen;

    public NodeBean(int rank, boolean isOpen) {
        this.rank = rank;
        this.isOpen = isOpen;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
