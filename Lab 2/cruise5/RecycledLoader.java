public class RecycledLoader extends Loader {
    private static final int MAINTENANCE_TIME = 60;
    
    public RecycledLoader() {
        super();
    }

    @Override
    public Time getNextTime() {
        Cruise lastCruise = _allCruises.getLast();
        Time cruiseTime = lastCruise.getCruiseTime();
        Time nextTime = cruiseTime.addMins(lastCruise.getServiceTime());
        nextTime = nextTime.addMins(MAINTENANCE_TIME);
        return nextTime;
    }
}