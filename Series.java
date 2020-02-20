package fr.cnam.partiel;

/**
 * When we talk about a series, we can get its name, its number of episodes, its progression and its global score.
 * We can also progress in the series by watching an episode.
 */
public interface Series {
    /**
     * Get the name of the series.
     *
     * @return A String representing the name of the series.
     */
    String getName();

    /**
     * Get the number of episodes of the series.
     *
     * @return An integer representing the number of episodes of the series.
     */
    int getEpisodesCount();

    /**
     * Get the number of episodes of the series that the user has already watched.
     *
     * @return An integer representing the number of episodes of the series that the user has already watched.
     */
    int getProgression();

    /**
     * Get the global score that the user assigned to the series.
     * This score is the mean of the scores of the episodes already watched by the user.
     *
     * @return A double representing the global score that the user assigned to the series.
     */
    double getScore();

    /**
     * Watch the next episode of the series, and give it a score.
     * We can't watch the next episode of a series that has been already completely watched.
     * The score is a number between 0 and 10.
     *
     * @param score A double representing the score between 0 and 10 that the user gave to the next episode of the series.
     * @throws IllegalStateException    When the series has been already completed by the user.
     * @throws IllegalArgumentException When the score is not between 0 and 10.
     */
    void watch(double score);
}
