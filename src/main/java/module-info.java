module com.example.pochinator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pochinator to javafx.fxml;
    exports com.example.pochinator;
}