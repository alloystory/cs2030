import java.util.*;

public class Loaders {
    private LinkedList<Loader> _allLoaders;
    
    public Loaders() {
        this._allLoaders = new LinkedList<Loader>();
    }

    public void loadCruise(Cruise cruise) {
        Time cruiseTime = cruise.getCruiseTime();
        for (int i = 0; i < cruise.getLoadersRequired(); i++) {
            boolean cruiseLoaded = false;

            for (Loader loader : _allLoaders) {
                Time nextTime = loader.getNextTime();

                if (!cruiseLoaded && nextTime.isNotEarlier(cruiseTime)) {
                    loader.loadCruise(cruise);
                    cruiseLoaded = true;
                }
            }

            if (!cruiseLoaded) {
                Loader newLoader;
                if ((_allLoaders.size() + 1) % 3 == 0) {
                    newLoader = new RecycledLoader();
                } else {
                    newLoader = new Loader();
                }

                newLoader.loadCruise(cruise);
                _allLoaders.add(newLoader);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        StringBuilder bufOutput = new StringBuilder();
        int loaderNum = 1;
        for (Loader loader : _allLoaders) {
            if (loader instanceof RecycledLoader) {
                bufOutput.append(String.format("Loader %d (recycled) serves:\n", loaderNum));
                bufOutput.append(loader.toString());
            } else {
                output.append(String.format("Loader %d serves:\n", loaderNum));
                output.append(loader.toString());
            }
            loaderNum++;
        }
        output.append(bufOutput.toString());
        return output.toString();
    }
}