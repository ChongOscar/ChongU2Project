public class LinearEquation {
    int x1;
    int x2;
    int y1;
    int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        return roundToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double slope() {
        if ((x2 - x1) == 0) {
            return 0;
        } else {
            return roundToHundredth( (y2 - y1 * 1.0) / (x2 - x1 * 1.0));
        }
    }

    public double yIntercept() {
        return roundToHundredth((y1 - (slope() * x1)));
    }

    public String equation() {
        if (x1 == x2) {
            return "x = " + x1;
        }
        if (y1 == y2) {
            return "y = " + y1;
        }
        String equation = "y = ";
        if (slope() == 1) {
            equation += "x";
        } else if (slope() == -1) {
            equation += "-x";
        } else if (slope() % 1 == 0) {
            equation += (int) slope() + "x";
        } else if (x2 - x1 < 0 && y2 - y1 < 0) {
            equation += ((y2 - y1) * -1) + "/" + ((x2 - x1) * -1) + "x";
        } else if (x2 - x1 < 0) {
            equation += "-" + (y2 - y1) + "/" + ((x2 - x1) * -1) + "x";
        } else if (y2 - y1 < 0) {
            equation += "-" + ((y2 - y1) * -1) + "/" + (x2 - x1) + "x";
        } else {
            equation += (y2 - y1) + "/" + (x2 - x1) + "x";
        }
        if (yIntercept() == 0) {
            equation += "";
        } else if (yIntercept() < 0) {
            equation += " - " + (yIntercept() * -1);
        } else {
            equation += " + " + yIntercept();
        }

        return equation;
    }

    public String coordinateForX(double x) {
        if (x1 == x2) {
            return "N/A";
        }
        if (y1 == y2) {
            return "(" + x + ", " + y1 + ")";
        }
        return "(" + x + ", " + (Math.round((slope() * x + yIntercept()) * 100.0) / 100.0) + ")";
    }

    public String lineInfo() {
        String info = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
               "The equation of the line between these points is: " + equation() + "\n";
        if ((x2 - x1) == 0) {
            info += "The slope of this line is: N/A" + "\n" + "The y-intercept of this line is: N/A" + "\n";
        } else {
            info += "The slope of this line is: " + slope() + "\n" + "The y-intercept of this line is: " + yIntercept() + "\n";
        }
        info += "The distance between these points is " + distance();
        return info;
    }

    private double roundToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }


}
