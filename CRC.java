import java.util.Scanner;

public class CRC 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Transmitter side:");
        System.out.print("Enter no. of data bits: ");
        int n = scanner.nextInt();
        
        int[] data = new int[n];
        System.out.println("Enter data:");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        
        System.out.print("Enter size of generator: ");
        int g = scanner.nextInt();
        
        int[] generator = new int[g];
        System.out.println("Enter generator:");
        do {
            for (int j = 0; j < g; j++) {
                generator[j] = scanner.nextInt();
            }
        } while (generator[0] != 1);
        
        System.out.println("\n\tThe generator matrix:");
        for (int j = 0; j < g; j++) {
            System.out.print(generator[j]);
        }

        int a = n + (g - 1);
        System.out.println("\n\tThe appended matrix is:");
        int[] arr = new int[a];
        for (int i = 0; i < n; i++) {
            arr[i] = data[i];
        }
        for (int i = 0; i < a; i++) {
            System.out.print(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = i; j < g + i; j++) {
                    arr[j] = arr[j] ^ 0;
                }
            } else {
                for (int j = 0; j < g; j++) {
                    arr[i + j] = arr[i + j] ^ generator[j];
                }
            }
        }

        System.out.println("\n\tThe CRC is :");
        for (int i = n; i < a; i++) {
            System.out.print(arr[i]);
        }

        System.out.println();
        for (int i = 0; i < a; i++) {
            System.out.print(data[i]);
        }
        scanner.close();
    }
}
