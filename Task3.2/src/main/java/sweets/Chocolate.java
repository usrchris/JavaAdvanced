package sweets;

public class Chocolate extends Sweets{
    private String type;
    public Chocolate(String name, int weight, double price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Шоколад: " + super.toString() + ", тип - " + type;
    }
}
