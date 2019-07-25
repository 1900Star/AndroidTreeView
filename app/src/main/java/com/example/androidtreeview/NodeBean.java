package com.example.androidtreeview;


/**
 * @author luoshipeng
 * createDate：2019/7/22 0022 17:45
 * className   NodeBean
 * Des：TODO
 */
public class NodeBean {
    private int rank;
    private int parent=255;
    private boolean isOpen;

    public NodeBean(int rank, int parent, boolean isOpen) {
        this.rank = rank;
        this.parent = parent;
        this.isOpen = isOpen;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "NodeBean{" +
                "rank=" + rank +
                ", parent=" + parent +
                ", isOpen=" + isOpen +
                '}';
    }
}
