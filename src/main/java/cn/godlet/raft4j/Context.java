package cn.godlet.raft4j;

/**
 * Context represents the current state of the server.
 */
public class Context {

    protected RaftServer server;

    protected int currentTerm ;

    protected int currentIndex;

    protected int commitIndex ;

    public Context(){

    }

    public Context(RaftServer server, int currentTerm, int currentIndex, int commitIndex) {
        this.server = server;
        this.currentTerm = currentTerm;
        this.currentIndex = currentIndex;
        this.commitIndex = commitIndex;
    }

    /**
     * return the server
     */
    public RaftServer getServer(){
        return server;
    }

    /**
     * return the current Term
     */
    public int getCurrentTerm(){
        return currentTerm;
    }

    /**
     * return the current log index
     */
    public int getCurrentIndex(){
        return currentIndex;
    }

    /**
     * return the current committed index
     */
    public int getCommitIndex(){
        return commitIndex;
    }
}
