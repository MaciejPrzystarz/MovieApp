package controller;

import exception.OptionNotExistsException;
import db.ApplicationDatabase;
import exception.DuplicateException;
import io.ApplicationIO;
import model.Actor;
import model.Movie;
import model.TvSeries;

import java.util.Arrays;
import java.util.Objects;

public class ApplicationController {

    private final ApplicationDatabase database = new ApplicationDatabase();
    private final ApplicationIO reader = new ApplicationIO();

    public void mainLoop() {
        try {
            int userOption;
            do {
                printOptions();
                printLine("Choose option:");
                userOption = reader.readIntFromScanner();
                chooseOption(userOption);
            } while (userOption != Option.EXIT.getNumber());
        } catch (OptionNotExistsException e) {
            System.err.println("Chosen option is not available.");
        }
    }

    private void chooseOption(int userOption) {
        Option option = Arrays.stream(Option.values())
                .filter(x -> userOption == x.getNumber())
                .findFirst()
                .orElse(null);
        if (option == null) {
            System.err.println("Option (" + userOption + ") does not exist.");
        } else {
            switch (Objects.requireNonNull(option)) {
                case ADD_MOVIE -> addMovie();
                case ADD_TV_SERIES -> addTvSeries();
                case ADD_ACTOR -> addActor();
                case PRINT_ALL -> printAll();
                case EXIT -> exit();
                default -> throw new OptionNotExistsException("Chosen option is not available.");
            }
        }
    }

    private void addActor() {
        try {
            Actor actor = reader.createActor();
            database.addActor(actor);
        } catch (DuplicateException e) {
            System.err.println("This actor already exists in database.");
        }
    }

    private void addTvSeries() {
        try {
            TvSeries tvSeries = reader.createTvSeries();
            database.addTvSeries(tvSeries);
        } catch (DuplicateException e) {
            System.err.println("This TV series already exists in database.");
        }
    }

    private void addMovie() {
        try {
            Movie movie = reader.createMovie();
            database.addMovie(movie);
        } catch (DuplicateException e) {
            System.err.println("This movie already exists in database.");
        }
    }

    private void exit() {
        printLine("End of session, goodbye!");
    }

    private void printAll() {
        printLine("Movies:");
        for (Movie movie : database.getMovies()) {
            movie.showInfo();
        }

        printLine("Tv Series:");
        for (TvSeries tvSerie : database.getTvSeries()) {
            tvSerie.showInfo();
        }

        printLine("Actors:");
        for (Actor actor : database.getActors()) {
            actor.showInfo();
        }
    }


    private static void printOptions() {
        printLine("---------------");
        Arrays.stream(Option.values())
                .forEach(option -> printLine(option.optionToChoose()));
        printLine("---------------");
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}