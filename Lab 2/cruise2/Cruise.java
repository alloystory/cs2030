import java.util.*;

public class Cruise {
    private String _cruiseCode;
    private Time _cruiseTime;
    private static final int SERVICE_TIME = 30;
    private static final int LOADERS_REQUIRED = 1;

    public Cruise(String cruiseCode, String cruiseTime) {
        this._cruiseCode = cruiseCode;
        this._cruiseTime = new Time(cruiseTime);
    }

    public Time getCruiseTime() {
        return this._cruiseTime;
    }

    public int getServiceTime() {
        return this.SERVICE_TIME;
    }

    public int getLoadersRequired() {
        return this.LOADERS_REQUIRED;
    }

    @Override
    public String toString() {
        return _cruiseCode + "@" + _cruiseTime.toString();
    }
}