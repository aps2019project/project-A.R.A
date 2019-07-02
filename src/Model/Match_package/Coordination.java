package Model.Match_package;

public class Coordination {
    private int x;
    private int y;

    public Coordination(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public static int getDistance(Coordination c1, Coordination c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }

    @Override
    public boolean equals(Object object){
        Coordination coordination = (Coordination) object;
        return (this.x == coordination.getX() && this.y == coordination.getY());
    }

    public boolean equals(int x, int y){
        return (x == this.x && y == this.y);
    }

    public boolean isMXM(int m) {
        if (x <= 5 - m && y <= 9 - m)
            return true;
        return false;
    }
    public boolean is2X2() {
        return isMXM(2);
    }
    public boolean is3X3() {
        return isMXM(3);
    }

}
