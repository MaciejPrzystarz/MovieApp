package model;

public class TvSeries extends Item {
    private int seasons;
    private int episodes;
    private String producer;

    public TvSeries(String title, int seasons, int episodes, String producer, String genre, String description, int rating) {
        super(title, genre, description, rating);
        this.seasons = seasons;
        this.episodes = episodes;
        this.producer = producer;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void showInfo() {
        System.out.println(getTitle() + ", liczba sezonów: " +
                seasons + ", liczba odcinków: " +
                episodes + ", producent: " +
                producer + ", gatunek: " +
                getGenre() + ", opis: " +
                getDescription() + ", ocena: " +
                getRating());
    }
}