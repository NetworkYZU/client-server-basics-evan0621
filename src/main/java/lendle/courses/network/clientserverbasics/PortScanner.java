/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.clientserverbasics;

import java.io.IOException;
import java.net.Socket;

/**
 * @author lendle
 */
public class PortScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 1; i <= 1024; i++) {
            try {
                Socket s = new Socket("localhost", i);
                System.out.println("service on port" + i);
            } catch (IOException ex) {
                System.out.println("no service on port" + i);
            }
        }
    }

}
