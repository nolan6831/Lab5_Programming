package common;

public class Coordinates implements java.io.Serializable {
    private int x;
    private Float y; //Максимальное значение поля: 709, Поле не может быть null

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }

    public Float getY(){
        return this.y;
    }

    public void setY(Float y){
        this.y = y;
    }
}
