package io;

import exception.IncorrectDataException;
import model.Actor;
import model.Genre;
import model.Movie;
import model.TvSeries;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationIO {
    private final Scanner scanner = new Scanner(System.in);

    public Movie createMovie() {
        String convertedGenre = "";
        printLine("Creating new movie...\nEnter movie name:");
        String name = scanner.nextLine();
        printLine("Enter name of director:");
        String director = scanner.nextLine();
        printLine("Enter the year of production:");
        int yearOfProduction = readIntFromScanner();
        printLine("Enter the genre:");
        convertedGenre = getGenre(convertedGenre);
        printLine("Enter a description:");
        String description = scanner.nextLine();
        printLine("Enter rating (0 - 10):");
        int rating = readRatingFromScanner();
        return new Movie(name, director, yearOfProduction, convertedGenre, description, rating);
    }

    public Actor createActor() {
        printLine("Creating new actor...\nEnter actor first name:");
        String firstName = scanner.nextLine();
        printLine("Enter actor last name:");
        String lastName = scanner.nextLine();
        printLine("Enter the actor's country of origin:");
        String countryOfOrigin = scanner.nextLine();
        return new Actor(firstName, lastName, countryOfOrigin);
    }

    public TvSeries createTvSeries() {
        printLine("Creating new series...\nEnter TV series name:");
        String name = scanner.nextLine();
        printLine("Enter the number of seasons:");
        int numberOfSeasons = readIntFromScanner();
        printLine("Enter the number of episodes:");
        int numberOfEpisodes = readIntFromScanner();
        printLine("Enter name of director:");
        String director = scanner.nextLine();
        printLine("Enter genre:");
        Genre.printAllGenresToChoose();
        String genre = scanner.nextLine();
        String convertedGenre = Genre.convert(genre);
        printLine("Enter description:");
        String description = scanner.nextLine();
        printLine("Enter rating (0 - 10):");
        int rating = readRatingFromScanner();
        if (convertedGenre == null) {
            throw new IncorrectDataException("The provided data is incorrect. Failed to create the TV series.");
        } else {
            return new TvSeries(name, numberOfSeasons, numberOfEpisodes, director, convertedGenre, description, rating);
        }
    }

    public int readIntFromScanner() {
        int number = -1;
        while (number < 0) {
            try {
                number = scanner.nextInt();
                if (number < 0) {
                    System.err.println("The number must be positive. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("The data is in an invalid format. Please try again.");
            } finally {
                scanner.nextLine();
            }
        }
        return number;
    }

    private int readRatingFromScanner() {
        int number = -1;
        while (isInTheNumericalRange(number)) {
            try {
                number = scanner.nextInt();
                if (isInTheNumericalRange(number)) {
                    System.err.println("The number cannot be lower than 0 or exceed 10. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("The data is in an invalid format. Please try again.");
            } finally {
                scanner.nextLine();
            }
        }
        return number;
    }

    private String getGenre(String convertedGenre) {
        String genre;
        do {
            Genre.printAllGenresToChoose();
            genre = scanner.nextLine();
            try {
                convertedGenre = Genre.convert(genre);
            } catch (IncorrectDataException e) {
                System.err.println("The provided genre is incorrect. Please try again.");
            }
        } while (!genre.equalsIgnoreCase(convertedGenre));
        return convertedGenre;
    }

    private static boolean isInTheNumericalRange(int number) {
        return number < 0 || number > 10;
    }

    private void printLine(String text) {
        System.out.println(text);
    }
}