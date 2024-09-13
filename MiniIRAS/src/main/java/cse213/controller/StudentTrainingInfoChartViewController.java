package cse213.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class StudentTrainingInfoChartViewController {

    Alert dataAlert = new Alert(Alert.AlertType.INFORMATION);

    private ObservableList<PieChart.Data> list
            = FXCollections.observableArrayList();
    @FXML
    private PieChart trainingInfoRatioPieChart;

    @FXML
    void loadStudentTrainingEnrollmentRatioPieChartButtonOnAction(ActionEvent event) {
        list.clear();
        list.add(new PieChart.Data("Java", 50));
        list.add(new PieChart.Data("C++", 40));
        list.add(new PieChart.Data("Python", 30));
        list.add(new PieChart.Data("C#", 10));
        list.add(new PieChart.Data("C", 15));
        trainingInfoRatioPieChart.setData(list);

        for (PieChart.Data data : trainingInfoRatioPieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            dataAlert.setContentText(
                                    "No of students enrolled for "
                                    + data.getName() + " training is: "
                                    + data.getPieValue()
                            );

                            dataAlert.showAndWait();
                        }
                    }
            );

        }
    }

    @FXML
    void initialize() {
        //
    }

}
