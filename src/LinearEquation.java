public class LinearEquation {
    int x1;
    int x2;
    int y1;
    int y2;
    public LinearEquation(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        return Math.round(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 100.0) / 100.0;
    }

    public double slope() {
        return Math.round((y2 - y1) / (x2- x1) * 100.0) /100.0;
    }

    public double yIntercept() {
        return Math.round((y1 - (slope() * x1)) * 100.0) / 100.0;
    }

    public String equation() {
        String equation = "y = ";
        if (slope() % 1 == 0) {
            equation += slope();
        } else if (x2 - x1 < 0 && y2 - y1 < 0) {
            equation += ((y2 - y1) * -1) + "/" + ((x2 - x1) * -1);
        } else if (x2 - x1 < 0) {
            equation += "-" + (y2 - y1) + "/" + ((x2 - x1) * -1);
        }
        if (yIntercept() < 0) {
            equation += " - " + (yIntercept() * -1);
        } else {
            equation += " + " + yIntercept();
        }

        return equation;
    }

}
