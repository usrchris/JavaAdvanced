package sweets;

public class Jellybean extends Sweets {
    private String shape;
    public Jellybean(String name, int weight, double price, String shape) {
        super(name, weight, price);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String toString() {
            return "Мармелад: " + super.toString() + ", форма - " + shape;
        }
    }
