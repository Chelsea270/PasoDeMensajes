package org.test.pasodemensajes.controller;

import com.example.ejerciciopasomensajes.model.Cliente;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class RegistroClientesController {
    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    private ComboBox<String> cmbTipoCliente;

    @FXML
    private TextField txtDocumentoIdentificacionCliente;

    @FXML
    private TextField txtDirectorioCliente;

    @FXML
    private Button btnSeleccionarImagen;

    @FXML
    private Button btnSeleccionarDirectorio;

    @FXML
    private void initialize(){
        cmbTipoCliente.setItems(FXCollections.observableArrayList(
                "Individual",
                "Empresa",
                "Institucional"
        ));
    }

    @FXML
    private void seleccionarDocumento(){
        //Solo dejar png o jpg
        FileChooser fc = new FileChooser();



    }


    @FXML
    private void seleccionarDirectorio(){
        //Directorio especifico
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Seleccionar directorio");
        dc.setInitialDirectory(new File("/home/charlieuxv/Downloads/"));


        File directorio = dc.showDialog(btn.getScene().getWindow());

        if(directorio != null) {
            txtDirectorioCliente.setText(directorio.getAbsolutePath());
        }
    }

    @FXML
    private void mostrarAlerta(){

    }

    @FXML
    private Cliente construirCliente(){
        return new Cliente (

                txtNombreCliente.getText().trim(),
                txtCorreoCliente.getText().trim(),
                txtTelefonoCliente.getText().trim(),
                cmbTipoCliente.getValue(),
                txtDocumentoIdentificacionCliente.getText().trim(),
                txtDirectorioCliente.getText().trim()
        );

    }

    @FXML
    private void abrirSolicitudServicio(){
        if (!validarFormulario()){
            return;
        }

        Cliente cliente = construirCliente();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("com.example.ejerciciopasomensajes.registro-cliente.fxml"));
            Parent root = loader.load();
            SolicitudServicioCotroller controller = loader.getController();

            controller.recibirCLiente(cliente);
            Stage stage = new Stage();
            stage.setTitle("Solicitud Servicio");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            mostrarAlerta(
                    Alert.AlertType.ERROR,
                    "Error",
                    "No fue posible abrir solicitud de servicio. \n"
            );
        }
    }


    @FXML
    private void guardarCliente(){

    }

    @FXML
    private boolean validarFormulario(){
        return false;
    }
}