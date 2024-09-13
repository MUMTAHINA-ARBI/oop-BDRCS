package cse213.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cse213.miniiras.MainApplicationClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ChartsViewController {

    @FXML    private BorderPane chartLoadBorderPane;

    private void loadChart(String chartFxmlName){
        try {
            FXMLLoader chartFxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource(chartFxmlName));
            chartLoadBorderPane.setCenter(chartFxmlLoader.load());
        }
        catch(Exception e){
            //
        }
    }

    @FXML
    void initialize() {
        //
    }

    @FXML
    public void loadCourseWithdrwalChartViewButtonOnAction(ActionEvent actionEvent) {
        loadChart("CourseSpecificWithdrawalChartView.fxml");
    }

    @FXML
    public void loadStudentTrainingInfoChartViewButtonOnAction(ActionEvent actionEvent) {
        loadChart("StudentTrainingInfoChartView.fxml");
    }
}