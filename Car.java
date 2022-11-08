
/**
 *
 * 
 */
public class Car {

    private String nameCar;
    private String[] color;
    private String[] Price;
    private String[] soldOn;

    public Car() {
    }

    public Car(String nameCar, String[] color, String[] Price, String[] soldOn) {
        this.nameCar = nameCar;
        this.color = color;
        this.Price = Price;
        this.soldOn = soldOn;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String[] getColer() {
        return color;
    }

    public void setColer(String[] color) {
        this.color = color;
    }

    public String[] getPrice() {
        return Price;
    }

    public void setPrice(String[] Price) {
        this.Price = Price;
    }

    public String[] getSoldOn() {
        return soldOn;
    }

    public void setSoldOn(String[] soldOn) {
        this.soldOn = soldOn;
    }

}
