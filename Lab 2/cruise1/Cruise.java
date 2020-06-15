import java.util.*;

public class Cruise {
    private String _cruiseCode;
    private Time _cruiseTime;

    public Cruise(String cruiseCode, String cruiseTime) {
        this._cruiseCode = cruiseCode;
        this._cruiseTime = new Time(cruiseTime);
    }

    @Override
    public String toString() {
        return _cruiseCode + "@" + _cruiseTime.toString();
    }
}