/**
 * Created by cyonkee on 4/2/17.
 */
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        //        if (args.length != 1) {
        //            System.err.println("Usage: java KnockKnockServer <port number>");
        //            System.exit(1);
        //        }
        int portNumber = 6066;

        try(
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {

            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String inputLine, outputLine;
            String fromServer;

            // Initiate conversation with client
//            ServerProtocol sp = new ServerProtocol();
//            outputLine = sp.processInput(null);
//            fromServer = stdIn.readLine();
//            //out.println(outputLine);
//            out.println(fromServer);

            while (true) {
                //outputLine = sp.processInput(inputLine);
                fromServer = stdIn.readLine();
                out.println(fromServer);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
