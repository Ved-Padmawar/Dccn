import java.util.Scanner;

public class DataLink 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter window size: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of frames to transmit: ");
        int f = scanner.nextInt();

        int[] frames = new int[30];

        System.out.println("Enter " + f + " frames:");
        for (int i = 1; i <= f; i++) {
            frames[i] = scanner.nextInt();
        }

        System.out.println("\nWith sliding window protocol, the frames will be sent in the following manner (assuming no corruption of frames):\n");
        System.out.println("After sending " + n + " frames at each stage, the sender waits for an acknowledgment sent by the receiver.\n");

        for (int i = 1; i <= f; i++) {
            if (i % n == 0) {
                System.out.print(frames[i] + " ");
                System.out.println("\nAcknowledgment of the above frames sent is received by the sender.\n");
            } else {
                System.out.print(frames[i] + " ");
            }
        }

        if (f % n != 0) {
            System.out.println("Acknowledgment of the above frames sent is received by the sender.");
        }
        scanner.close();
    }
}
