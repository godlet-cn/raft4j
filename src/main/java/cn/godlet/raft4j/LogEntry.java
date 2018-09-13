package cn.godlet.raft4j;

/**
 *  A log entry stores a single item in the log.
 */
public class LogEntry {

    public LogEntry()
    {

    }

    /**
     * Creates a new log entry associated with a log.
     * @param log
     * @param index
     * @param term
     * @param command
     */
    public LogEntry(Log log, int index, int term, Command command)
    {
        this.log=log;
        this.index=index;
        this.term=term;
        this.command=command;
    }

    private Log log;

    private int index;

    private int term;

    private Command command;

    Log getLog() {
        return log;
    }

    public int getIndex()
    {
        return index;
    }

    public int getTerm()
    {
        return term;
    }

    public Command getCommand()
    {
        return command;
    }
}
