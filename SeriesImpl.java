package fr.cnam.partiel;

public class SeriesImpl implements Series {
    private String seriesName;

    private Episode[] muyEpisodes;

    private int progression=0;
    private double score=0;


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
        return this.progression;
    }

    @Override
    public double getScore() {
        return this.score;
    }

    @Override
    public void watch(double score) {

        this.score=score;

    }

}
