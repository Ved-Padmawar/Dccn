import java.util.Scanner;

public class SlidingWindow 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int window = 0;

        System.out.print("Enter Window size: ");
        window = scanner.nextInt();
        int sent = 0, ack;

        while (true) {
            for (int i = 0; i < window; i++) 
            {
                System.out.println("Frame Transmitted " + sent);
                sent++;
                if (sent == window) 
                {
                    break;
                }
            }

            System.out.print("Enter last received acknowledgment: ");
            ack = scanner.nextInt();

            if (ack == window) 
            {
                break;
            } 
            else 
            {
                sent = ack;
            }
        }
        scanner.close();
    }
}
