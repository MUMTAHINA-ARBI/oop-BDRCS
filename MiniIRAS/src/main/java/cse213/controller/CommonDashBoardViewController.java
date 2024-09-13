package cse213.controller;

import java.net.URL;
import java.util.ResourceBundle;

import cse213.miniiras.MainApplicationClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class CommonDashBoardViewController {

    @FXML    private BorderPane commonDashBoardBorderPane;

    @FXML
    void initialize() {

    }

    @FXML
    void loadCourseSpecificWithdrwalChartOnAction(ActionEvent event) {
        loadFxmlParentToBorderPaneCenter("CourseSpecificWithdrawalChartView.fxml");
    }

    @FXML
    void loadUserSpecificGenderRatioChartOnAction(ActionEvent event) {
        loadFxmlParentToBorderPaneCenter("UserSpecificGenderRatioChartView.fxml");
    }

    @FXML
    public void loadAddNewUserViewMenuItemOnAction(ActionEvent actionEvent) {
        loadFxmlParentToBorderPaneCenter("AddNewUserView.fxml");
    }

    @FXML
    public void loadPdfGenerationViewMenuItemOnAction(ActionEvent actionEvent) {

    }

    @FXML
    public void loadAddNewCourseViewMenuItemOnAction(ActionEvent actionEvent) {
        loadFxmlParentToBorderPaneCenter("AddNewCourseView.fxml");
    }

    @FXML
    public void loadCourseInfoFromFileViewMenuItemOnAction(ActionEvent actionEvent) {
        loadFxmlParentToBorderPaneCenter("LoadCourseInfoFromFileView.fxml");
    }

    private void loadFxmlParentToBorderPaneCenter(String fxmlName){
        try {
            FXMLLoader nextFxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource(fxmlName));
            commonDashBoardBorderPane.setCenter(nextFxmlLoader.load());
        }
        catch(Exception e){
            //
        }
    }

}
