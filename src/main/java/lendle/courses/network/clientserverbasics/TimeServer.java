package lendle.courses.network.clientserverbasics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(13);
            System.out.println("connection opened");
            while (true) {
                Socket client = server.accept();
                OutputStream outputstream = client.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(outputstream, "ascii");
                Date date = new Date();
                writer.write(date.toString());
                writer.flush();
                client.close();

            }
        } catch (IOException exception) {
            Logger.getLogger(TimeServer.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
