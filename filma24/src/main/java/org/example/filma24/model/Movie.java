package org.example.filma24.model;

import jdk.jfr.BooleanFlag;
import org.example.filma24.model.enums.Rating;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private int id;

    private String title;

    private int duration;

//    private Set<Actor> actors = new HashSet();
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "box_office")
    private double boxOffice;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    // private Director director;

    private boolean oscarAward;

    private boolean released;

    public Movie() {
    }

    public Movie(int id, String title, int duration, LocalDate releaseDate, double boxOffice, Rating rating, boolean oscarAward, boolean released) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.boxOffice = boxOffice;
        this.rating = rating;
        this.oscarAward = oscarAward;
        this.released = released;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isOscarAward() {
        return oscarAward;
    }

    public void setOscarAward(boolean oscarAward) {
        this.oscarAward = oscarAward;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", boxOffice=" + boxOffice +
                ", rating=" + rating +
                ", oscarAward=" + oscarAward +
                ", released=" + released +
                '}';
    }
}
