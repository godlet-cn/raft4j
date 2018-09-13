package cn.godlet.raft4j;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ConfigHelper {
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    /**
     * Write server's configuration to file.
     * @param server
     * @throws IOException
     */
    public static void writeConfig(RaftServer server) throws IOException {
        List<Peer> peers = new ArrayList<Peer>();
        for (Map.Entry<String, Peer> peerItem: server.getPeers().entrySet()) {
            peers.add(peerItem.getValue());
        }
        Config conf = new Config(server.getLog().getCommitIndex(),peers);

        File configFile= new File(server.getPath(), "conf");
        server.debugLine("Write config ", configFile.getPath());
        OutputStream out = new FileOutputStream(configFile);
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        gson.toJson(conf,Config.class, writer);
        writer.flush();
        writer.close();
    }

    /**
     * Read the configuration for the server.
     * @param server
     * @throws IOException
     */
    public static void ReadConfig(RaftServer server) throws IOException
    {
        File configFile= new File(server.getPath(), "conf");
        server.debugLine("Read config ", configFile.getPath());

        if (configFile.exists())
        {
            InputStream input = new FileInputStream(configFile);
            JsonReader reader = new JsonReader(new InputStreamReader(input));
            Config conf = gson.fromJson(reader,Config.class);
            reader.close();
            if(conf!=null){
                server.getLog().updateCommitIndex(conf.getCommitIndex());
            }
        }
    }
}
