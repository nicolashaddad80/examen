package fr.cnam.partiel;

public class SeriesImpl implements Series {
    private String seriesName;

    Episode[] muyEpisodes;



    public SeriesImpl(String name, int  epCount) {

        this.muyEpisodes = new Episode[epCount];
        this.seriesName=name;
    }

    @Override
    public String getName() {
        return this.seriesName;
    }

    @Override
    public int getEpisodesCount() {
        return this.muyEpisodes.length;
    }

    @Override
    public int getProgression() {
        return 0;
    }

    @Override
    public double getScore() {
        return 0;
    }

    @Override
    public void watch(double score) {

    }

}
