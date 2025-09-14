/*An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
Hint => 
Take user input for 3 sides of a triangle 
The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
Write a Method to compute the number of rounds user needs to do to complete 5km run
 */
import java.util.Scanner;
public class rounds {
    public static int total_rounds(int a, int b, int c) {
        int perimeter = a + b + c;
        int rounds = 5000 / perimeter;
        return rounds;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the first side of the triangle");
        int a=sc.nextInt();
         System.out.println("Enter the second side of the triangle");
        int b=sc.nextInt();
         System.out.println("Enter the third side of the triangle");
        int c=sc.nextInt();
        int total_rounds_ran = total_rounds(a, b, c);
        System.out.println("The total rounds the athlete must run in a park with sides " + a + ", " + b + ", " + c + " meters to complete 5km is: " + total_rounds_ran);
    }
}
