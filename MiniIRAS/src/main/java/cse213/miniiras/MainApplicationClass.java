package cse213.miniiras;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import cse213.user.Employee;
import cse213.user.Faculty;

public class MainApplicationClass extends Application {
    @Override
    public void start(Stage defaultStage) throws IOException {
        FXMLLoader myFxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("CommonDashBoardView.fxml"));
        //FXMLLoader myFxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("ChartsView.fxml"));
        //FXMLLoader myFxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("CreateNewBookView.fxml"));
        //FXMLLoader myFxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoadBookInfoFromFileView.fxml"));
        //Scene defaultScene = new Scene(myFxmlLoader.load(), 320, 240);
        Scene defaultScene = new Scene(myFxmlLoader.load());
        defaultStage.setTitle("MiniIRAS");
        defaultStage.setScene(defaultScene);
        defaultStage.show();
    }

    public static void main(String[] args) {
        //User u = new User();
        //System.out.println(u.toString());

        //Employee e = new Employee();
        //e.applyForLoan();
        //e.applyForLeave();

        //Employee e1, e2;

        //e1 = new Faculty();
        //defaultStage.show();

        launch();
    }
}