package com.company;

import com.company.utility.Normaliser;

public class Main {

    public static void main(String[] args) {
        Normaliser normaliser = new Normaliser();
        String normalizedJobTitle = normaliser.normalise(args[0]);
        System.out.println("Input Job Title: \"" + args[0] + "\"");
        System.out.println("Normalised Job Title: \"" + normalizedJobTitle + "\"");
    }
}
