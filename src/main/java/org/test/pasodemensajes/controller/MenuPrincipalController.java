package org.test.pasodemensajes.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MenuPrincipalController {

    @FXML
    private void abrirRegistroClientes(){
        abrirVentana(
                "/home/charlieuxv/IdeaProjects/EjercicioPasoMensajes/src/main/resources/com/example/ejerciciopasomensajes/registro-clientes.fxml",
                "Registro de clientes"
        );
    }


    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.show();
        }
        catch (Exception e){
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "ERROR",
                    "NO FUE POSIBLE ABRIR LA VENTANA \n" + e.getMessage());

        }

    }

    private void mostrarAlerta(Alert.AlertType type, String titulo, String mensaje){
        Alert alert = new Alert(type);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();

    }
}