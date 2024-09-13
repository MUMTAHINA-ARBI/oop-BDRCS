package cse213.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class UserSpecificGenderRatioChartViewController {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private PieChart genderRatioPieChart;
    @FXML    private ComboBox<String> userTypeComboBox;

    Alert dataAlert = new Alert(Alert.AlertType.INFORMATION);

    private ObservableList<PieChart.Data> list
            = FXCollections.observableArrayList();

    @FXML
    void loadGenderRatioPieChartButtonOnAction(ActionEvent event) {
        list.clear();
        if(userTypeComboBox.getValue().equals("Student")){
            list.add( new PieChart.Data("Male-Student",7000) );
            list.add( new PieChart.Data("Female-Student",5400) );
        }
        else if(userTypeComboBox.getValue().equals("Faculty")){
            list.add( new PieChart.Data("Male-Faculty",250) );
            list.add( new PieChart.Data("Female-Faculty",160) );
        }
            //        list.add( new PieChart.Data("Java",50) );
            //        list.add( new PieChart.Data("C++",40) );
            //        list.add( new PieChart.Data("Python",30) );
            //        list.add( new PieChart.Data("C#",10) );
            //        list.add( new PieChart.Data("C",15) );
            //        genderRatioPieChart.setData(list);

        genderRatioPieChart.setData(list);
        for(PieChart.Data data: genderRatioPieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED,
                    new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {

                            dataAlert.setContentText(
                                    "No of "
                                            + data.getName() + " user is: "
                                            + data.getPieValue()
                            );

                            /*
                            dataAlert.setContentText(
                                    "No of students enrolled for "
                                    + data.getName() + " training is: "
                                    + data.getPieValue()
                            );
                            */

                            dataAlert.showAndWait();
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    }
            );

        }
    }

    @FXML
    void initialize() {
        String[] users = {"Faculty", "Student", "Accountant"};
        userTypeComboBox.getItems().addAll(users);

    }
}