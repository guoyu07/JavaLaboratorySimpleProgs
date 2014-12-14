package pl.polsl.Szymon.Bartnik.views;

import java.net.*;
import java.io.*;
import pl.polsl.Szymon.Bartnik.models.server.NumeralSystemsService;

/** 
 * The main class of the miltithreaded TCP server
 * 
 * @author Szymon Bartnik (Grupa 2)
 * @version 1.0
 */
public class ServerEntryPoint {

    /** port number on which the server will be running */
    static final int PORT = 8298;

    /** 
     * The main application method
     * @param args
     * @throws java.io.IOException
     * @params args all parametres are ignored
     */
    public static void main(String args[]) throws IOException {
        
        
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server has started.");

        try {
            while (true) {
                System.out.println("Server is waiting for connection...");
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getInetAddress());
                try {
                    NumeralSystemsService numeralSystemsService = new NumeralSystemsService(socket);
                    numeralSystemsService.start();
                } catch (IOException e) {
                    socket.close();
                    System.err.println(e.getMessage());
                }
            }
        } finally {
            server.close();
        }
    }
}