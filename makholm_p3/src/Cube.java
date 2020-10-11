public class Cube extends Shape implements Shape3D {
    public int i;
    public double j;

    public Cube(int i1){
        super();
        i = i1;
    }
    public Cube(double j1){
        super();
        j = j1;
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        if(i == 0)
            return (6 * (j * j));
        else
            return (6 * (i * i));
    }

    @Override
    public double getVolume() {
        if(i == 0)
            return (j * j * j);
        else
            return (i * i * i);
    }
}
