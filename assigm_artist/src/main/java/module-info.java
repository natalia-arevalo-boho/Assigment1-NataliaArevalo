module com.example.assigm_artist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.assigm_artist to javafx.fxml;
    exports com.example.assigm_artist;
}