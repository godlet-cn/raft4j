package cn.godlet.raft4j;

/**
 * StateMachine is the interface for allowing the host application to save and recovery
 * the state machine. This makes it possible to make snapshots and compact the log.
 */
public abstract class StateMachine {

    public abstract byte[] Save();

    public abstract void Recovery(byte[] bytes);

}
