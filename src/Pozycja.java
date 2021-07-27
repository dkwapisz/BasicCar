public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }

    public void przemiesc(double V, double dT, Pozycja cel) {
        double dX = V * dT/1000 * (cel.x - this.x) / Math.sqrt(Math.pow((cel.x - this.x), 2) + Math.pow((cel.y - this.y), 2));
        double dY = V * dT/1000 * (cel.y - this.y) / Math.sqrt(Math.pow((cel.x - this.x), 2) + Math.pow((cel.y - this.y), 2));
        if (dX < Math.abs(cel.x - this.x))
            this.x = this.x + dX;
        else
            this.x = cel.x;

        if (dY < Math.abs(cel.y - this.y))
            this.y = this.y + dY;
        else
            this.y = cel.y;
    }
}
