import java.util.Scanner;
public class intrest {
    public int simple_intrest(int p, int r, int t) {
        int si = (p * r * t) / 100;
        return si;
    }
  public static void main (String args[])
  {
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter principal amount: ");
    int p=sc.nextInt();
    System.out.print("Enter rate of interest: ");
    int r=sc.nextInt();
    System.out.print("Enter time in years: ");  
    int t=sc.nextInt();
    intrest obj=new intrest();
    int si=obj.simple_intrest(p, r, t);
    System.out.println("The Simple Interest is"+si+"  for Principal"+p+ "  Rate of Interest"+r+" In time"+t);
    
  }
}
