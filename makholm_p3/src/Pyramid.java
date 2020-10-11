public class Pyramid extends Shape implements Shape3D {
    public int i, j, k;
    public double l, m, n;

    public Pyramid(int i1, int j1, int k1){
        super();
        i = i1;
        j = j1;
        k = k1;
    }
    public Pyramid(double l1, double m1, double n1){
        super();
        l = l1; //length
        m = m1; //width
        n = n1; //height
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        if(i == 0)
            return (l * m) + (l * Math.sqrt(Math.pow(m / 2.0, 2.0) + Math.pow(n, 2.0))) + (m * Math.sqrt(Math.pow(l / 2.0, 2.0) + Math.pow(n, 2.0)));
        else
            return (i * j) + (i * Math.sqrt(Math.pow(j / 2.0, 2.0) + Math.pow(k, 2.0))) + (j * Math.sqrt(Math.pow(i / 2.0, 2.0) + Math.pow(k, 2.0)));
    }

    @Override
    public double getVolume() {
        if(i == 0)
            return (l * m * n)/3.0;
        else
            return (i * j * k)/3.0;
    }
}
