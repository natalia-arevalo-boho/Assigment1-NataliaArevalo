package com.example.assigm_artist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class YoutubeViewController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load chart data from the database upon initialization
        loadChartDataFromDatabase();
    }

    // Method to load chart data from the database
    private void loadChartDataFromDatabase() {
        try (Connection connection = new DatabaseConnector().connect()) {
            // SQL query to retrieve artist names and their YouTube views in 2022
            String query = "SELECT name, youtube_views_2022 FROM artists ORDER BY youtube_views_2022 DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Artists with more plays on YouTube");

            // Iterate through the result set and add data to the series
            while (resultSet.next()) {
                String artist = resultSet.getString("name");
                int views = resultSet.getInt("youtube_views_2022");
                series.getData().add(new XYChart.Data<>(artist, views));
            }

            // Add the series to the bar chart
            barChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Button event handlers to switch scenes

    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Load the tableview.fxml file
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
