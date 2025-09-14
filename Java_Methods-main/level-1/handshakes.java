package methods;
import java.util.Scanner;
public class handshakes {
    public static int calculateHandshakes(int n) {
        
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.close();
        int maxHandshakes = calculateHandshakes(numberOfStudents);
        System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is: " + maxHandshakes);
    }
}
