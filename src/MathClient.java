import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class MathClient {
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("Usage: java MathClient <ip address> <port number>");
            System.exit(1);
        }

        String host = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try
        {
            // Setting up client socket
            System.out.println("Sending client request...");
            Socket socket = new Socket(host, portNumber);
            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            // Taking inputs from the user
            System.out.println("Enter 2 space separated numbers to be added:");
            String message = userInput.readLine();

            // Sending inputs to the server socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);

            // Reading response from the server
            BufferedReader socketReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            System.out.println(socketReader.readLine());
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
