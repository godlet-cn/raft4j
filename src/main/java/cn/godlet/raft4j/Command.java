package cn.godlet.raft4j;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Command represents an action to be taken on the replicated state machine.
 */
public abstract class Command {
    /**
     * The name of Command
     */
    protected String commandName;

    /**
     * Command name accessor
     * @return
     */
    public String getCommandName(){
        return commandName;
    }

    /**
     * Apply this command to the server.
     * @param context
     * @return
     */
    public abstract Object Apply(Context context);

    /**
     * Deserialize command
     * @param reader
     * @return
     */
    public abstract Boolean Decode(InputStream reader);

    /**
     * Serialize command
     * @param writer
     * @return
     */
    public abstract Boolean Encode(OutputStream writer);

}
