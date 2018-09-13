package cn.godlet.raft4j;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 */
public final class NOPCommand extends Command{

    public NOPCommand(){
        // Set the name of the NOP command in the log
        this.commandName="raft:nop";
    }

    @Override
    public Object Apply(Context context) {
        return null;
    }

    @Override
    public Boolean Decode(InputStream reader) {
        return null;
    }

    @Override
    public Boolean Encode(OutputStream writer) {
        return null;
    }
}
