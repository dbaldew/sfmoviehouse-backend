package com.ticketapp.sfmoviehouse.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table (name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieID;
    private String title;
    private String year;
    private String category;
    private String summary;
    private String description;
    @OneToOne
    @JoinColumn(name = "image", referencedColumnName = "name")
    private File image;

    public Movie() {
    }

    public Movie(Long movieID, String title, String year, String category, String summary, String description, File image) {
        this.movieID = movieID;
        this.title = title;
        this.year = year;
        this.category = category;
        this.summary = summary;
        this.description = description;
        this.image = image;
    }

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}

