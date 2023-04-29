package controller;

public enum Option {
    ADD_MOVIE(0, "Add movie"),
    ADD_TV_SERIES(1, "Add TV series"),
    ADD_ACTOR(2, "Add actor"),
    PRINT_ALL(3, "Display all information"),
    EXIT(4, "End the program");

    final int number;
    final String description;

    Option(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String optionToChoose() {
        return number + " - " + description;
    }
}