package common;

public class Human implements java.io.Serializable {
    private Long height; //Значение поля должно быть больше 0

    public Human(Long height) {
    }

    public Long getHeight(){
        return this.height;
    }

    public void setHeight(Long height){
        this.height = height;
    }
}
