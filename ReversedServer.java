import java.io.*;
import java.net.*;

public class ReversedServer 
{
    public static void main(String[] args) 
    {
        try 
        {
            int port = 9999;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running and waiting for client connection...");

            while (true) 
            {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientSentence = in.readLine();
                System.out.println("Received from client: " + clientSentence);

                String reversedSentence = new StringBuilder(clientSentence).reverse().toString();
                out.println(reversedSentence);
                
                clientSocket.close();
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}