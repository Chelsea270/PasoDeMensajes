module com.example.ejerciciopasomensajes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejerciciopasomensajes to javafx.fxml;
    exports com.example.ejerciciopasomensajes;
}