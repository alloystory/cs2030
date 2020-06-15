public class BigCruise extends Cruise {
    private static final int SERVICE_TIME = 60;
    private static final int LOADERS_REQUIRED = 2;

    public BigCruise(String cruiseCode, String cruiseTime) {
        super(cruiseCode, cruiseTime);
    }

    @Override
    public int getServiceTime() {
        return this.SERVICE_TIME;
    }

    @Override
    public int getLoadersRequired() {
        return this.LOADERS_REQUIRED;
    }
}