package com.djalexspark.pinger.pinger;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ContextMenu contextLabelMenu;

    @FXML
    private Label statusLabel;

    @FXML
    void onActionContextLabelMenu(ActionEvent event) {

    }

    @FXML
    void onBorderDragDetected(MouseEvent event) {

    }

    @FXML
    void onBorderDragDropped(DragEvent event) {

    }

    @FXML
    void onExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onMenuMoveClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this::checkWebsiteAvailability, 0, 5, TimeUnit.SECONDS);
    }

    private void checkWebsiteAvailability() {
        try {
            InetAddress address = InetAddress.getByName("8.8.8.8");
            long startTime = System.currentTimeMillis();
            boolean isReachable = address.isReachable(5000);
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;

            Platform.runLater(() -> {
                if (isReachable) {
                    statusLabel.setText("Status: Available (Response time: " + timeTaken + "ms)");
                } else {
                    statusLabel.setText("Status: Unavailable");
                }
            });
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




public Stage stage;
    double xOffset, yOffset;
    public void setDragndropEffect(Stage stage) {
        this.stage = stage;
        borderPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        borderPane.setOnMouseDragged(event -> {
            this.stage.setX(event.getScreenX() - xOffset);
            this.stage.setY(event.getScreenY() - yOffset);
        });

    }
    Task task;
    public void setPinger() {
        task = new Task() {
           @Override
           protected Object call() throws Exception {

               return null;
           }
       };

    }
}
