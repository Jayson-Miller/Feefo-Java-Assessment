package com.company.utility;

public class LevenshteinDistanceCalculator {

    /**
     * Calculate the Levenshtein edit distance between two strings.
     * This method computes the minimum number of single-character edits
     * (insertions, deletions, or substitutions) required to change one string into the other.
     *
     * @param firstString  First string.
     * @param secondString Second string.
     * @return The Levenshtein distance between the two strings.
     */
    public int calculateEditDistance(final String firstString, final String secondString) {
        final int firstStringLength = firstString.length();
        final int secondStringLength = secondString.length();

        //Create two arrays to store the current and previous row of distances
        int[] previousRow = new int[secondStringLength + 1];
        int[] currentRow = new int[secondStringLength + 1];

        //Initialize the previous row with values from 0 to secondStringLength
        for (int i = 0; i <= secondStringLength; i++) {
            previousRow[i] = i;
        }
        for (int i = 1; i <= firstStringLength; i++) {
            currentRow[0] = i;

            for (int j = 1; j <= secondStringLength; j++) {
                //If match, get the value
                if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    currentRow[j] = previousRow[j - 1];
                } else {
                    //Otherwise, take the minimum value from substitution, insertion, or deletion
                    currentRow[j] = 1 + Math.min(previousRow[j - 1], Math.min(currentRow[j - 1], previousRow[j]));
                }
            }

            //Swap current and previous rows for the next iteration
            int[] temp = previousRow;
            previousRow = currentRow;
            currentRow = temp;
        }

        //The final distance is in the last element of the previous row
        return previousRow[secondStringLength];
    }
}