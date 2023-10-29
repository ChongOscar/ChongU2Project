
import java.util.Scanner;    
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinearEquationLogic {
    private LinearEquation linearEquation;
    private Scanner scanner;

    public LinearEquationLogic() {
        linearEquation = null;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (true) {
            double x;
            String input;
            boolean stop = false;
            getData();
            System.out.println();
            System.out.println(linearEquation.lineInfo());
            System.out.println();
            System.out.print("Enter a value for x: ");
            x = scanner.nextDouble();
            scanner.nextLine();
            System.out.println();
            System.out.println("The point on the line is " + linearEquation.coordinateForX(x));
            System.out.println();
            while (true) {
                System.out.print("Would you like to enter another pair of coordinates? y/n: ");
                input = scanner.nextLine();
                if (input.equals("y")) {
                    break;
                } else if (input.equals("n")) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                System.out.println("Thank you for using the slop calculator, goodbye.");
                break;
            }
        }
    }

    private void getData() {
        int[] coord1;
        int[] coord2;
        coord1 = getCoord(1);
        coord2 = getCoord(2);
        linearEquation = new LinearEquation(coord1[0], coord1[1], coord2[0], coord2[1]);
    }
    private int[] getCoord(int num) {
        int[] coordinates = new int[2];
        Pattern pattern = Pattern.compile("\\((-?\\d+), (-?\\d+)\\)");
        while (true) {
            System.out.print("Enter coordinate " + num + ": ");
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) {
                coordinates[0] = Integer.parseInt(matcher.group(1));
                coordinates[1] = Integer.parseInt(matcher.group(2));
                break;
            } else {
                System.out.println("Invalid format.");
            }
        }
        return coordinates;
    }
}
