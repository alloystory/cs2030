package cs2030.catsanddogs;

public class Tuna extends Food {
    private String _brand;

    public Tuna(String brand) {
        this._brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%s tuna", _brand);
    }
}