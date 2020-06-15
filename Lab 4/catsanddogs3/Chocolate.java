package cs2030.catsanddogs;

public class Chocolate extends Food {
    private String _brand;
    private String _flavour;

    public Chocolate(String brand, String flavour) {
        this._brand = brand;
        this._flavour = flavour;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s chocolate", _brand, _flavour);
    }
}