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

            String inputLine, outputLine;

            // Initiate conversation with client
            ServerProtocol sp = new ServerProtocol();
            outputLine = sp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = sp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
