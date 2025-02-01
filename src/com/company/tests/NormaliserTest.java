package com.company.tests;

import com.company.utility.Normaliser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormaliserTest {

    private Normaliser normaliser;

    @BeforeEach
    void setUp() {
        normaliser = new Normaliser();
    }

    @Test
    void testCorrectValue() {
        String jobTitle = "Software engineer";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Software engineer", result, "The job title should match 'Software engineer'");
    }

    @Test
    void testEmptyInput() {
        String jobTitle = "";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Job title cannot be null or empty", result);
    }

    @Test
    void testNullInput() {
        String result = normaliser.normalise(null);
        assertEquals("Job title cannot be null or empty", result);
    }

    @Test
    void testMisspelledInput() {
        String jobTitle = "Soft Engineer";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Software engineer", result, "The misspelled title should match 'Software engineer'");

        jobTitle = "Accontant";
        result = normaliser.normalise(jobTitle);
        assertEquals("Accountant", result, "The misspelled title should match 'Accountant'");
    }
}