public class APLine{
    private int a, b, c;

    public APLine(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getSlope(){
        return (-1.0*a)/b;
    }

    public boolean isOnLine(int x, y){
        return ((this.a*x + this.b*y +c) == 0);
    }
}