public class Square extends Shape implements Shape2D{
    public int i;
    public double j;

    public Square(int i1) {
        super();
        i = i1;
    }
    public Square(double j1){
        super();
        j = j1;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        if(i == 0)
            return j * j;
        else
            return i*i;
    }

}
