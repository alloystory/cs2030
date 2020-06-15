import java.util.*;

public class Time {
    private int _hours;
    private int _minutes;

    public Time(String timeStr) {
        int time = Integer.parseInt(timeStr);
        this._minutes = time % 100;
        this._hours = (time - _minutes) / 100;
    }

    public Time(int hours, int minutes) {
        this._hours = hours;
        this._minutes = minutes;
    }

    public int getHours() {
        return this._hours;
    }

    public int getMinutes() {
        return this._minutes;
    }

    public Time addMins(int duration) {
        int newHours = _hours;
        int newMinutes = _minutes + duration;
        if (newMinutes >= 60) {
            newHours += 1;
            newMinutes = newMinutes - 60;
        }

        if (newHours >= 24) {
            newHours = 0;
        }

        return new Time(newHours, newMinutes);
    }

    public boolean isNotEarlier(Time time) {
        int targetFullTime = time.getHours() * 100 + time.getMinutes();
        int currFullTime = this._hours * 100 + this._minutes;
        return targetFullTime >= currFullTime;
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