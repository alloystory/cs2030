import java.util.*;

public class Loader {
    protected LinkedList<Cruise> _allCruises;

    public Loader() {
        this._allCruises = new LinkedList<Cruise>();
    }

    public void loadCruise(Cruise cruise) {
        _allCruises.add(cruise);
    }

    public Time getNextTime() {
        Cruise lastCruise = _allCruises.getLast();
        Time cruiseTime = lastCruise.getCruiseTime();
        Time nextTime = cruiseTime.addMins(lastCruise.getServiceTime());
        return nextTime;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Cruise cruise : _allCruises) {
            String text = "    " + cruise.toString();
            output.append(String.format("| %-32s |\n", text));
        }
        return output.toString();
    }
}