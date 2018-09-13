package cn.godlet.raft4j;

/**
 * The state of server
 */
public enum ServerState {
    STOPPED(0,"Stopped"),

    INITIALIZED(1,"Stopped"),

    FOLLOWER(2,"Stopped"),

    CANDIDATE(3,"Stopped"),

    LEADER(4,"Stopped"),

    SNAPSHOTTING(5,"Stopped");

    /** 枚举码 */
    private int _code;
    /** 枚举描述 */
    private String _desc;

    private ServerState(int code, String desc) {
        this._code = code;
        this._desc = desc;
    }

    public int code() {
        return _code;
    }

    public String desc() {
        return _desc;
    }

}
