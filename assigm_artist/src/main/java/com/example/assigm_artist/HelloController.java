package com.example.assigm_artist;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class HelloController {

    // Connector to interact with the database
    @FXML
    private DatabaseConnector dbConnector = new DatabaseConnector();

    // Reference to the table view in the FXML file
    @FXML
    private TableView<Artists> artistsTable;

    // Table columns defined in the FXML file
    @FXML
    private TableColumn<Artists, Integer> idColumn;
    @FXML
    private TableColumn<Artists, String> nameColumn;
    @FXML
    private TableColumn<Artists, Integer> mostPopularYearColumn;
    @FXML
    private TableColumn<Artists, String> musicalGenreColumn;
    @FXML
    private TableColumn<Artists, Integer> formationYearColumn;
    @FXML
    private TableColumn<Artists, String> endYearColumn;
    @FXML
    private TableColumn<Artists, Integer> youtubeViews2022Column;

    @FXML
    private void initialize() {
        // Set up cell value factories to populate the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        mostPopularYearColumn.setCellValueFactory(new PropertyValueFactory<>("mostPopularYear"));
        musicalGenreColumn.setCellValueFactory(new PropertyValueFactory<>("musicalGenre"));
        formationYearColumn.setCellValueFactory(new PropertyValueFactory<>("formationYear"));
        endYearColumn.setCellValueFactory(new PropertyValueFactory<>("endYear"));
        youtubeViews2022Column.setCellValueFactory(new PropertyValueFactory<>("youtubeViews2022"));

        // Retrieve data from database and set it to the table
        Artists artists = new Artists();
        ObservableList<Artists> items = artists.getArtistsFromDatabase();
        this.artistsTable.setItems(items);
    }

    // Methods to handle button events

    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Load the table view scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableview.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void youtubeViewButton(ActionEvent actionEvent) throws IOException {
        // Load the YouTube views scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views2022.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void genreViewButton(ActionEvent actionEvent) throws IOException {
        // Load the musical genre review scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("musicalgenreview.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

