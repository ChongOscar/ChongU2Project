import java.util.Scanner;

public class LinearEquationLogic {
    private LinearEquation linearEquation;
    private Scanner scanner;

    public LinearEquationLogic() {
        linearEquation = null;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        getData();
    }

    private void getData() {
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        System.out.println("Enter coordinate 1: ");
        x1 = parseCoord(1);
    }
    private int parseCoord(int xy) {
        int num = 0;
        String coord = "";
        boolean format = false;

        while (!format) {
            coord = scanner.nextLine();
        }
        return 0;
    }
}
