import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class MathServer {
    public static void main(String[] args){
        if(args.length != 1)
        {
            System.out.println("Usage: java MathServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try
        {
            // Setting up server socket
            System.out.println("Server started!!!");
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket socket = serverSocket.accept();
            System.out.println("Connection established!!!");

            // Reading from the socket
            BufferedReader socketReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String input = socketReader.readLine();

            // Implementing addition logic
            String[] number = input.split(" ");
            int result = Integer.parseInt(number[0]) + Integer.parseInt(number[1]);

            // Sending the response from the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("The result of your query is: " + result);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}