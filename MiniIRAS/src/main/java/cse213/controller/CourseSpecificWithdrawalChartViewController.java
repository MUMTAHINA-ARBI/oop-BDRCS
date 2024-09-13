package cse213.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CourseSpecificWithdrawalChartViewController {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private BarChart<Number, String> withdrawalBarChart;
    @FXML    private ComboBox<String> selectCourseComboBox;
    @FXML    private TextField yearTextField;
    @FXML    private ComboBox<String> selectSemesterComboBox;

    @FXML
    void renderBarChartButtonOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        //
    }
}
