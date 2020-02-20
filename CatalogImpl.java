package fr.cnam.partiel;

import java.util.HashMap;
import java.util.Iterator;

public class CatalogImpl extends HashMap<String, Series> implements  Catalog{

    @Override
    public Series getSeriesForName(String name) {
        return this.get(name);
    }

    @Override
    public Series newSeries(String name, int epCount) {
        Series uneSerie = new SeriesImpl(name,epCount);
        this.put(name,uneSerie);
        return uneSerie;
    }

    @Override
    public Iterator<Series> iterator() {
        return this.values().iterator();
    }
}
