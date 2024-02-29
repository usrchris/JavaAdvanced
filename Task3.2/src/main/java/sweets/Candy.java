package sweets;

public class Candy extends Sweets {
    private String color;
    public Candy(String name, int weight, double price, String color) {
        super(name, weight, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Конфеты: " + super.toString() + ", цвет упаковки - " + color;
    }
}
