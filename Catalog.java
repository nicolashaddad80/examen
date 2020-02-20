package fr.cnam.partiel;

public interface Catalog extends Iterable<Series> {
    /**
     * Just some data to test quickly.
     */
    Object[][] catalogExampleData = {
            {"The Running Dead - S3", 5, 16, 8.2},
            {"Yellow is the new Blue - S1", 13, 13, 7.8},
            {"The Running Dead - S2", 13, 13, 8.8},
            {"Breaking Good - S2", 13, 13, 7.5},
            {"How I Met Your Father - S1", 22, 22, 8.6},
            {"The Black Hole Theory - S1", 17, 17, 8.4},
            {"The Running Dead - S1", 6, 6, 9.0},
            {"Breaking Good - S1", 7, 7, 9.4},
    };

    /**
     * Build a catalog with the data just above.
     *
     * @return A catalog containing the data above.
     */
    static Catalog buildDefaultCatalog() {
        Catalog catalog = new CatalogImpl();

        for (Object[] entry : catalogExampleData) {
            // Create the series
            Series series = catalog.newSeries((String) entry[0], (int) entry[2]);

            // Watch some episodes of the series
            for (int i = 0; i < (int) entry[1]; i++) {
                series.watch((double) entry[3]);
            }
        }

        return catalog;
    }

    /**
     * Search in the catalog for the series with the correct name.
     *
     * @param name A String representing the name of the series we are looking for.
     * @return The series if it has been found in the catalog, or null otherwise.
     * @throws IllegalArgumentException When the given name is null.
     */
    Series getSeriesForName(String name);

    /**
     * Start a new series from the first episode.
     * The series is fully defined by its name.
     * We precise the number of episodes of the series.
     *
     * @param name    A String representing the name of the new series.
     * @param epCount An integer representing the number of episodes of the new series.
     * @return The new series.
     * @throws IllegalArgumentException When the given name is null, or when the series has 0 episodes.
     * @throws IllegalStateException    When the name corresponds to an already existing series.
     */
    Series newSeries(String name, int epCount);
}
