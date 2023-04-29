package model;

public class Movie extends Item {
    private int year;
    private String director;

    public Movie(String title, String director, int year,  String genre, String description, int rating) {
        super(title, genre, description, rating);
        this.year = year;
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void showInfo() {
        System.out.println(getTitle() + ", rok: " +
                year + ", reżyser: " +
                director + ", gatunek: " +
                getGenre() + ", opis: " +
                getDescription() + ", ocena: " +
                getRating());
    }
}