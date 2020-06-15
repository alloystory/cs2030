import java.util.*;

public class Time {
    private int _hours;
    private int _minutes;

    public Time(String timeStr) {
        int time = Integer.parseInt(timeStr);
        this._minutes = time % 100;
        this._hours = (time - _minutes) / 100;
    }

    public void addMins(int duration) {
        int newMinutes = _minutes + duration;
        if (newMinutes < 60) {
            this._minutes = newMinutes;
        } else {
            this._hours += 1;
            this._minutes = newMinutes - 60;
        }

        if (this._hours >= 24) {
            this._hours = 0;
        }
    }

    @Override
    public String toString() {
        String hoursStr, minutesStr;
        if (_hours < 10) {
            hoursStr = "0" + Integer.toString(_hours);
        } else {
            hoursStr = Integer.toString(_hours);
        }

        if (_minutes < 10) {
            minutesStr = "0" + Integer.toString(_minutes);
        } else {
            minutesStr = Integer.toString(_minutes);
        }
        return hoursStr + minutesStr;
    }
}