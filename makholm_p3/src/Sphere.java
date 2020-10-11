public class Sphere extends Shape implements Shape3D {
    public int i;
    public double j;

    public Sphere(int i1){
        super();
        i = i1;
    }
    public Sphere(double j1){
        super();
        j = j1;
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        if(i == 0)
            return (4.0 * Math.PI * Math.pow(j, 2.0));
        else
            return (4.0 * Math.PI * Math.pow(i, 2.0));
    }

    @Override
    public double getVolume() {
        if(i == 0)
            return((4.0/3.0) * Math.PI * Math.pow(j, 3.0));
        else
            return((4.0/3.0) * Math.PI * Math.pow(i, 3.0));
    }
}
