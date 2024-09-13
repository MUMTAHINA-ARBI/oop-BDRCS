package cse213.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import cse213.miniiras.MainApplicationClass;
import cse213.utility.AppendableObjectOutputStream;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import cse213.nonuser.Course;
import javafx.stage.Stage;

public class AddNewCourseController{
    @FXML    private TextField idTextField;
    @FXML    private TextField nameTextField;
    @FXML    private ComboBox<Integer> credirComboBox;
    @FXML    private ComboBox<String> courseTypeComboBox;

    ArrayList<Course> courseList;

    @FXML
    void accumulateCourseToArrayListButtonMouseOnClicked(MouseEvent event) {
        courseList.add(
                new Course(
                        idTextField.getText(),
                        nameTextField.getText(),
                        courseTypeComboBox.getValue(),
                        credirComboBox.getValue()
                )

        );
        idTextField.clear();
        nameTextField.clear();
        //courseTypeComboBox
    }

    @FXML
    void saveArrayListToFileButtonMouseOnClicked(MouseEvent event) {
        FileWriter fw = null;
        try {
            File f = new File("CourseInfo.txt");
            //FileWriter fw = new FileWriter("CourseInfo.txt");

            if(f.exists()) {
                fw = new FileWriter(f, true);
                //fw = new FileWriter(f);
            }
            else {
                fw = new FileWriter(f);
            }
            String str = "";
            for(Course c : courseList){
                str += c.toString("for file");
            }
            fw.write(str);
            fw.close();
        }
        catch(Exception e){
            try {
                if (fw != null) fw.close();
            }
            catch(Exception e2){
                e2.printStackTrace();
            }
        }

    }

    @FXML
    void initialize() {
        credirComboBox.getItems().addAll(1,3,4,6);
        courseTypeComboBox.getItems().addAll("Select Course Type","Foundation", "Major", "Minor", "Core", "Optional");
        courseList = new ArrayList<Course>();
    }

    @FXML
    public void goToCourseLoadViewButtonMouseOnClicked(Event event) {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(CreateNewBookController.class.getResource("LoadBookInfoFromFileView.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("LoadBookInfoFromFileView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage nextStage = new Stage();
            nextStage.setTitle("Load Course From File");
            nextStage.setScene(nextScene);
            //defaultStage.setScene(nextScene);
            nextStage.show();
        }
        catch(Exception e){
            //
        }
    }

    @FXML
    public void saveArrayListToBinaryFileButtonMouseOnClicked(Event event) {
        try {
            File f = new File("CourseInfo.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            //Will create multiple file header issue while appending objects (class instances)
            if(f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            //oos = new ObjectOutputStream(fos);

            /*
            if(f.exists()) {
                oos = new AppendableObjectOutputStream ()
                fos = new FileOutputStream(f, true);
            }
            else {
                fos = new FileOutputStream(f);
            }
            oos = new ObjectOutputStream(fos);
            */


            for(Course c : courseList){
                oos.writeObject(c);
            }
            /*
            ArrayList<String> strList = new ArrayList<String>();
            strList.add("Hello");
            strList.add("World");
            strList.add("Welcome");

            oos.writeObject(strList);
            */

            oos.close();
        }
        catch(Exception e){
            //
        }
    }

    @FXML
    public void switchToCourseLoadViewButtonMouseOnClicked(Event eventTriggered) {
        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(CreateNewBookController.class.getResource("LoadBookInfoFromFileView.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationClass.class.getResource("LoadBookInfoFromFileView.fxml"));
            Scene nextScene = new Scene(fxmlLoader.load());
            Stage refToCurrentStage = (Stage)((Node)eventTriggered.getSource()).getScene().getWindow();
            refToCurrentStage.setTitle("Load Course From File");
            refToCurrentStage.setScene(nextScene);
            refToCurrentStage.show();
        }
        catch(Exception e){
            //
        }
    }
}