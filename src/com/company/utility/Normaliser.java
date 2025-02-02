package com.company.utility;

import com.company.enums.NormalisedJobTitle;

import java.util.EnumSet;

public class Normaliser {

    private final EnumSet<NormalisedJobTitle> normalisedTitles;
    private final LevenshteinDistanceCalculator levenshteinDistanceCalculator;
    private static final Double QUALITY_THRESHOLD = 0.3;
    private static final String QUALITY_THRESHOLD_NOT_MET = "Unable to find Match";
    private static final String INVALID_JOB_TITLE = "Job Title cannot be null or an empty string";

    public Normaliser() {
        this.normalisedTitles = EnumSet.allOf(NormalisedJobTitle.class);
        this.levenshteinDistanceCalculator = new LevenshteinDistanceCalculator();
    }

    /**
     * Normalises a job title by comparing it with a set of normalised job titles via Levenshtein Distance scoring.
     *
     * @param jobTitle The job title to be normalized. It must not be null or empty.
     * @return a String containing either the successfully normalised Job Title, or a error message
     */
    public String normalise(final String jobTitle) {
        if (isBlank(jobTitle)) {
            return INVALID_JOB_TITLE;
        }

        String bestMatch = null;
        double highestQuality = 0.0;

        for (NormalisedJobTitle normalisedTitle : normalisedTitles) {
            if (!isBlank(normalisedTitle.getTitle())) {
                double quality = calculateQualityScore(jobTitle, normalisedTitle.getTitle());
                if (quality > highestQuality) {
                    highestQuality = quality;
                    bestMatch = normalisedTitle.getTitle();
                }
            }
        }
        return highestQuality >= QUALITY_THRESHOLD ? bestMatch : QUALITY_THRESHOLD_NOT_MET;
    }

    private double calculateQualityScore(final String jobTitle, final String normalizedTitle) {
        final int maxLength = Math.max(jobTitle.length(), normalizedTitle.length());

        //Compute LevenshteinDistance for character edit score
        final int levenshteinDistanceScore = levenshteinDistanceCalculator.calculateEditDistance(jobTitle, normalizedTitle);

        //Return a score based off 1.0 being a perfect match, 0.0 being no matching characters at all
        return 1.0 - (double) levenshteinDistanceScore / maxLength;
    }

    private boolean isBlank(final String string) {
        return string == null || string.equals("");
    }
}
