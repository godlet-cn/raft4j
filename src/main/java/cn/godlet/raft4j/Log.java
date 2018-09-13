package cn.godlet.raft4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Log {
    private File file;

    private String path;

    List<LogEntry> entries;

    private int commitIndex;

    // The index before the first entry in the Log entries
    int startIndex;

    int startTerm;

    Boolean initialized = false;

    private final Object mutex = new Object();

    public Log() {
        entries = new ArrayList<LogEntry>();
    }

    /**
     * The last committed index in the log.
     * @return
     */
    public int getCommitIndex() {
        return this.commitIndex;
    }

    /**
     * The current index in the log without locking
     * @return
     */
    int getCurrentIndex() {
        if (this.entries.size() == 0) {
            return this.startIndex;
        }
        return this.entries.get(this.entries.size() - 1).getIndex();
    }

    /**
     * The next index in the log.
     * @return
     */
    int getNextIndex() {
        return this.getCurrentIndex() + 1;
    }

    /**
     * Determines if the log contains zero entries.
     * @return
     */
    Boolean isEmpty() {
        return (this.entries.size() == 0) && (this.startIndex == 0);
    }

    /**
     * The name of the last command in the log.
     * @return
     */
    String lastCommandName() {
        if (this.entries.size() > 0) {
            LogEntry entry = this.entries.get(this.entries.size() - 1);
            if (entry != null) {
                return entry.getCommand().getCommandName();
            }
        }
        return "";
    }

    /**
     * The current term in the log.
     * @return
     */
    int getCurrentTerm() {
        if (this.entries.size() == 0) {
            return this.startTerm;
        }
        return this.entries.get(this.entries.size() - 1).getTerm();
    }

    void updateCommitIndex(int commitIndex) {

    }
}
