package Model.Match_package;

public class Coordination {
    private int x;
    private int y;

    Coordination(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object object){
        Coordination coordination = (Coordination) object;
        return (this.x == coordination.getX() && this.y == coordination.getY());
    }

    public boolean equals(int x, int y){
        return (x == this.x && y == this.y);
    }
}
