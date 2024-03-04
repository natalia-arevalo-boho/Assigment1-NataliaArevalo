package com.example.assigm_artist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PopularGenreController implements Initializable {

    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Method called to initialize the controller after the FXML fields have been populated
        loadChartDataFromDatabase(); // Call method to load the chart data from database
    }

    // Method to load chart data from the database
    private void loadChartDataFromDatabase() {
        try (Connection connection = new DatabaseConnector().connect()) {
            // SQL query to retrieve musical genre data and its count
            String query = "SELECT musical_genre, COUNT(*) AS count FROM artists GROUP BY musical_genre ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Iterate through the result set and populate the pie chart
            while (resultSet.next()) {
                String genre = resultSet.getString("musical_genre");
                int count = resultSet.getInt("count");
                pieChart.getData().add(new PieChart.Data(genre, count));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Button event handlers to switch scenes

    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableview.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void youtubeViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views2022.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void genreViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("musicalgenreview.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
