package cn.godlet.raft4j;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LocatorEx;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public abstract class RaftServer {
    protected Log log;

    protected  String name;

    protected Object context;

    protected StateMachine stateMachine ;

    protected String leader ;

    protected ServerState State;

    protected String path ;

    protected String logPath ;

    protected int term ;

    protected int commitIndex;

    protected String votedFor ;

    protected int memberCount ;

    protected int quorumSize ;

    protected Boolean isLogEmpty ;

    protected List<LogEntry> logEntries;

    protected String lastCommandName ;

    protected Boolean isRunning ;

    protected int electionTimeout ;

    protected int heartbeatInterval ;

    protected Transporter transporter ;

    Log getLog() {
        return log;
    }

    public String getName() {
        return name;
    }

    public Object getContext() {
        return context;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public String getLeader() {
        return leader;
    }

    public ServerState getState() {
        return State;
    }

    public String getPath() {
        return path;
    }

    public String getLogPath() {
        return logPath;
    }

    public int getTerm() {
        return term;
    }

    public int getCommitIndex() {
        return commitIndex;
    }

    public String getVotedFor() {
        return votedFor;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public int getQuorumSize() {
        return quorumSize;
    }

    public Boolean getLogEmpty() {
        return isLogEmpty;
    }

    public List<LogEntry> getLogEntries() {
        return logEntries;
    }

    public String getLastCommandName() {
        return lastCommandName;
    }

    public Boolean getRunning() {
        return isRunning;
    }

    public int getElectionTimeout() {
        return electionTimeout;
    }

    public void setElectionTimeout(int electionTimeout) {
        this.electionTimeout = electionTimeout;
    }

    public int getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public void setHeartbeatInterval(int heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }

    public abstract void init();

    public abstract void start();

    public abstract void stop();

    public abstract Object execute(Command command);

    public abstract AppendEntriesResponse appendEntries(AppendEntriesRequest req);

    public abstract RequestVoteResponse requestVote(RequestVoteRequest req);

    public abstract SnapshotResponse requestSnapshot(SnapshotRequest req);

    public abstract SnapshotRecoveryResponse snapshotRecoveryRequest(SnapshotRecoveryRequest req);

    public abstract void addPeer(String name, String connectiongString);

    public abstract void removePeer(String name);

    public abstract ConcurrentHashMap<String, Peer> getPeers();

    public abstract LocatorEx.Snapshot getSnapshot();

    public abstract String getSnapshotPath(int lastIndex, int lastTerm);

    public abstract void takeSnapshot();

    public abstract void loadSnapshot();

    public abstract void flushCommitIndex();

    abstract void debugLine(String writeConfig, String confPath);
}
