import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class JavaNet {
    public static void main(String[] args) {
        String serverName;
        serverName = "35.236.135.229";
        int port = 80;
        try {
            System.out.println("Connect to Host" + serverName + ",port:" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Remote Host adress:" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from" + client.getLocalSocketAddress());
            InputStream inFormServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFormServer);
            System.out.println("Server respond:" + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
