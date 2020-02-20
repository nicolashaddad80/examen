package fr.cnam.partiel;

import java.util.HashMap;
import java.util.Iterator;

public class CatalogImpl extends HashMap<String, Series> implements Catalog {

    @Override
    public Series getSeriesForName(String name) {
        if (name != null)
            return this.get(name);
        else
            throw new IllegalArgumentException();

    }

    @Override
    public Series newSeries(String name, int epCount) {
        if (this.containsKey(name))
            throw new IllegalStateException();
        else if (name != null && epCount > 0) {
            Series uneSerie = new SeriesImpl(name, epCount);
            this.put(name, uneSerie);
            return uneSerie;
        } else throw new IllegalArgumentException();
    }

    @Override
    public Iterator<Series> iterator() {
        return this.values().iterator();
    }
}
