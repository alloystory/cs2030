import java.util.*;

public class Loaders {
    private LinkedList<Loader> _allLoaders;
    private int _numOfNormalLoaders = 0;
    private int _numOfRecycledLoaders = 0;
    
    public Loaders() {
        this._allLoaders = new LinkedList<Loader>();
    }

    public int getNumOfNormalLoaders() {
        return this._numOfNormalLoaders;
    }

    public int getNumOfRecycledLoaders() {
        return this._numOfRecycledLoaders;
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
                    _numOfRecycledLoaders++;
                    newLoader = new RecycledLoader();
                } else {
                    _numOfNormalLoaders++;
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
        String separator = "+==================================+\n";
        int loaderNum = 1;
        for (Loader loader : _allLoaders) {
            if (loader instanceof RecycledLoader) {
                String title = String.format("Loader %d (recycled) serves:", loaderNum);
                bufOutput.append(String.format("| %-32s |\n", title));
                bufOutput.append(loader.toString());
                bufOutput.append(separator);
            } else {
                String title = String.format("Loader %d serves:", loaderNum); 
                output.append(String.format("| %-32s |\n", title));
                output.append(loader.toString());
                output.append(separator);
            }
            loaderNum++;
        }
        output.append(bufOutput.toString());
        return output.toString();
    }
}