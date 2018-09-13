package cn.godlet.raft4j;

import java.io.InputStream;
import java.io.OutputStream;

public final class JoinCommand extends Command {
    /**
     * node name
     */
    private String name;

    /**
     * connection information
     */
    private String connectionString;


    public JoinCommand(){
        this.commandName="raft:join";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
