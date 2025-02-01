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
    void testSoftwareEngineerCorrectValue() {
        String jobTitle = "Java Engineer";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Software engineer", result, "The job title should match 'Software engineer'");
    }

    @Test
    void testArchitectCorrectValue() {
        String jobTitle = "Senior Building Architect";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Architect", result, "The job title should match 'Architect'");
    }

    @Test
    void testQuantitySurveyorCorrectValue() {
        String jobTitle = "Junior Quantity Surveyor";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Quantity surveyor", result, "The job title should match 'Quantity surveyor'");
    }

    @Test
    void testAccountantCorrectValue() {
        String jobTitle = "Banking Accountant";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Accountant", result, "The job title should match 'Accountant'");
    }

    @Test
    void testEmptyInput() {
        String jobTitle = "";
        String result = normaliser.normalise(jobTitle);
        assertEquals("Job Title cannot be null or an empty string", result);
    }

    @Test
    void testNullInput() {
        String result = normaliser.normalise(null);
        assertEquals("Job Title cannot be null or an empty string", result);
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