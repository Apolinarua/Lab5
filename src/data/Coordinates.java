package data;

public class Coordinates {


    private Float x; //Поле не может быть null

    private Long y; //Поле не может быть null

    public Coordinates() {

    }

    public void setX(Float x) throws Exception {
        if (x == null) {
            throw new Exception("Поле x не может быть null");
        }
    }

    public Float getX() {
        return x;
    }
    public void setY(Long y) throws Exception {
        if (y == null) {
            throw new Exception("Поле y не может быть null");
        }
    }
    public Long getY() {
        return y;
    }
    public Coordinates(Float x,Long y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
