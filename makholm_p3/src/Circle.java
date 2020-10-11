public class Circle extends Shape implements Shape2D {
    public int i;
    public double j;

    public Circle(int i1){
        super();
        i = i1;
    }

    public Circle(double j1){
        super();
        j =j1;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        if(i == 0)
            return (Math.PI * (j*j));
        else
            return (Math.PI * (i*i));
    }

}
