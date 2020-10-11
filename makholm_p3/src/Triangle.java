public class Triangle extends Shape implements Shape2D {
    public int i;
    public int j;
    public double k;
    public double l;

    public Triangle(int i1, int j1) {
        super();
        i = i1;
        j = j1;
    }

    public Triangle(double k1, double l1){
        super();
        k = k1;
        l = l1;
    }

    @Override
    public double getArea() {
        if(i == 0)
            return ((k*l)/2);
        else
            return ((i*j)/2);
    }

    @Override
    public String getName() {
        return "triangle";
    }
}
