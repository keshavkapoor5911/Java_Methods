public class EmployeeBonusCalculator {
    public static int[][] generateEmployeeData(int n) {
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            int salary = (int)(Math.random() * 90000) + 10000; 
            int years = (int)(Math.random() * 11); 
            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    
    public static double[][] calculateBonus(int[][] data) {
        double[][] result = new double[data.length][4];
        for (int i = 0; i < data.length; i++) {
            int oldSalary = data[i][0];
            int years = data[i][1];
            double bonus = (years > 5) ? oldSalary * 0.05 : oldSalary * 0.02;
            double newSalary = oldSalary + bonus;
            result[i][0] = oldSalary;
            result[i][1] = years;
            result[i][2] = bonus;
            result[i][3] = newSalary;
        }
        return result;
    }

    
    public static void displayResults(double[][] result) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.printf("%-10s %-15s %-10s %-15s %-15s\n", "Emp#", "Old Salary", "Years", "Bonus", "New Salary");
        for (int i = 0; i < result.length; i++) {
            totalOld += result[i][0];
            totalNew += result[i][3];
            totalBonus += result[i][2];
            System.out.printf("%-10d %-15.2f %-10.0f %-15.2f %-15.2f\n", i+1, result[i][0], result[i][1], result[i][2], result[i][3]);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s %-15.2f %-10s %-15.2f %-15.2f\n", "Total", totalOld, "", totalBonus, totalNew);
    }

    public static void main(String[] args) {
        int[][] data = generateEmployeeData(10);
        double[][] result = calculateBonus(data);
        displayResults(result);
    }
}
