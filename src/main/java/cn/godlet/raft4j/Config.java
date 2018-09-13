package cn.godlet.raft4j;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Config {

    @Expose
    private int commitIndex;

    @Expose
    private List<Peer> peers ;

    public Config(int commitIndex, List<Peer> peers) {
        this.commitIndex = commitIndex;
        this.peers = peers;
    }

    public int getCommitIndex() {
        return commitIndex;
    }

    public void setCommitIndex(int commitIndex) {
        this.commitIndex = commitIndex;
    }

    public List<Peer> getPeers() {
        return peers;
    }

    public void setPeers(List<Peer> peers) {
        this.peers = peers;
    }
}
