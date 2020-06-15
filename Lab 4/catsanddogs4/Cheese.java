package cs2030.catsanddogs;

public class Cheese extends Food {
    private String _brand;

    public Cheese(String brand) {
        this._brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%s cheese", _brand);
    }
}