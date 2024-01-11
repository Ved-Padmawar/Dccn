import java.io.*;
import java.net.*;

public class ReversedClient 
{
    public static void main(String[] args) 
    {
        try 
        {
            String serverAddress = "localhost";
            int serverPort = 9999;
            
            Socket clientSocket = new Socket(serverAddress, serverPort);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.print("Enter a sentence to reverse: ");
            String sentence = userInput.readLine();

            out.println(sentence);
            String reversedSentence = in.readLine();

            System.out.println("Reversed sentence received from server: " + reversedSentence);

            clientSocket.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
