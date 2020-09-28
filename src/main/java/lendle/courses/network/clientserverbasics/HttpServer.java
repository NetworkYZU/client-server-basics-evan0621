package lendle.courses.network.clientserverbasics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpServer {
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(5080);
            System.out.println("connection opened");
            while (true){
                Socket client=server.accept();
                OutputStream out=client.getOutputStream();
                Writer writer=new OutputStreamWriter(out,"UTF-8");
                writer.write("HTTP/1.0 200 OK\r\n\r\n");
                writer.write("<h1>HelloWorld!</h1>");
                writer.flush();
                writer.close();
            }
        }catch (IOException exception){
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, exception);
        }
    }
}
