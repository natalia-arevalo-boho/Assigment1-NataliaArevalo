package com.example.assigm_artist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Artists {
    private Integer id;
    private String name;
    private Integer most_popular_year;
    private String musical_genre;
    private Integer formation_year;
    private String end_year;
    private Integer youtube_views_2022;

    // Default constructor
    public Artists() {
    }

    // Parameterized constructor
    public Artists(Integer id, String name, Integer most_popular_year, String musical_genre, Integer formation_year, String end_year, Integer youtube_views_2022) {
        this.id = id;
        this.name = name;
        this.most_popular_year = most_popular_year;
        this.musical_genre = musical_genre;
        this.formation_year = formation_year;
        this.end_year = end_year;
        this.youtube_views_2022 = youtube_views_2022;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMostPopularYear() {
        return most_popular_year;
    }

    public void setMostPopularYear(Integer most_popular_year) {
        this.most_popular_year = most_popular_year;
    }

    public String getMusicalGenre() {
        return musical_genre;
    }

    public void setMusicalGenre(String musical_genre) {
        this.musical_genre = musical_genre;
    }

    public Integer getFormationYear() {
        return formation_year;
    }

    public void setFormationYear(Integer formation_year) {
        this.formation_year = formation_year;
    }

    public String getEndYear() {
        return end_year;
    }

    public void setEndYear(String end_year) {
        this.end_year = end_year;
    }

    public Integer getYoutubeViews2022() {
        return youtube_views_2022;
    }

    public void setYoutubeViews2022(Integer youtube_views_2022) {
        this.youtube_views_2022 = youtube_views_2022;
    }

    // Database connection and data retrieval
    DatabaseConnector dbConnector = new DatabaseConnector();

    // Method to retrieve artists' data from the database
    public ObservableList<Artists> getArtistsFromDatabase() {
        ObservableList<Artists> artistsList = FXCollections.observableArrayList();

        try {
            // Establishing a database connection
            Connection connection = dbConnector.connect();
            String SQL = "SELECT * FROM artists";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL);

            // Iterating through the result set and adding artists to the list
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer mostPopularYear = resultSet.getInt("most_popular_year");
                String musicalGenre = resultSet.getString("musical_genre");
                Integer formationYear = resultSet.getInt("formation_year");
                String endYear = resultSet.getString("end_year");
                Integer youtubeViews2022 = resultSet.getInt("youtube_views_2022");

                Artists artist = new Artists(id, name, mostPopularYear, musicalGenre, formationYear, endYear, youtubeViews2022);
                artistsList.add(artist);
            }

            // Closing resources
            stmt.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            // Handling database errors
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("Error retrieving data from the database: " + e.getMessage());
            alert.showAndWait();
        }

        return artistsList;
    }
}
