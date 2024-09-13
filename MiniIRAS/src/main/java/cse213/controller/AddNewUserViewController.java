package cse213.controller;

import cse213.normalizedtransactionclasses.LoginCredential;
import cse213.user.Accountant;
import cse213.user.Faculty;
import cse213.user.Student;
import cse213.user.User;
import cse213.utility.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;

public class AddNewUserViewController
{
    @javafx.fxml.FXML    private TextField idTextField;
    @javafx.fxml.FXML    private ComboBox<String> userTypeComboBox;
    @javafx.fxml.FXML    private PasswordField pwPasswordField;
    @javafx.fxml.FXML    private RadioButton otherRadioButton;
    @javafx.fxml.FXML    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML    private TextField emailTextField;
    @javafx.fxml.FXML    private TextField nameTextField;
    @javafx.fxml.FXML    private RadioButton maleRadioButton;
    @javafx.fxml.FXML    private Tab studentTab;
    @javafx.fxml.FXML    private Tab facultyTab;
    @javafx.fxml.FXML    private Tab accountantTab;
    @javafx.fxml.FXML    private TabPane userDataInputTabPane;
    @javafx.fxml.FXML    private ComboBox<String> minorComboBox;
    @javafx.fxml.FXML    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML    private ComboBox<String> empDeptComboBox;
    @javafx.fxml.FXML    private ComboBox<String> designationComboBox;
    @javafx.fxml.FXML    private TextField salaryTextField;
    @javafx.fxml.FXML    private ComboBox<Integer> publicationNoComboBox;
    @javafx.fxml.FXML    private ComboBox<String> advisorComboBox;
    @javafx.fxml.FXML    private DatePicker dojDatePicker;
    @javafx.fxml.FXML    private DatePicker dobDatePicker;

    ToggleGroup tg;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeComboBox.getItems().addAll("Student","Faculty","Accountant");
        userTypeComboBox.getSelectionModel().select("Select a user type:");
        userDataInputTabPane.setVisible(false);

        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        otherRadioButton.setToggleGroup(tg);
        maleRadioButton.setSelected(true);

        majorComboBox.getItems().addAll("CSE","EEE","PS","Finance","Law");
        minorComboBox.getItems().addAll("CSE","EEE","PS","Finance","Law");
        //HOWEVER, we need to load the items from file, as the list may change over time

        empDeptComboBox.getItems().addAll("Accounts","CSE","EEE","SETS","BBA","Law","Library","CITS");
        designationComboBox.getItems().addAll("Lecturer","Asst. Professor","Assoc. Professor","Professor","Dept. Manager","Head of Dept","Accountant","Admission Officer");
        //HOWEVER, we need to load the items from file, as the list may change over time

        publicationNoComboBox.getItems().addAll(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
    }

    @javafx.fxml.FXML
    public void userTypeComboBoxOnAction(ActionEvent actionEvent) {
        if(userTypeComboBox.getValue().equals("Student")){
            userDataInputTabPane.setVisible(true);
            studentTab.setDisable(false);
            facultyTab.setDisable(true);
            accountantTab.setDisable(true);
        }
        else if(userTypeComboBox.getValue().equals("Faculty")){
            userDataInputTabPane.setVisible(true);
            studentTab.setDisable(true);
            facultyTab.setDisable(false);
            accountantTab.setDisable(true);
        }
        else if(userTypeComboBox.getValue().equals("Accountant")){
            userDataInputTabPane.setVisible(true);
            studentTab.setDisable(true);
            facultyTab.setDisable(true);
            accountantTab.setDisable(false);
        }
    }

    @javafx.fxml.FXML
    public void createUserAndSaveToFileButtonOnAction(ActionEvent actionEvent) {
        String selectedGender=null;
        if(maleRadioButton.isSelected()) selectedGender = "Male";
        else if(femaleRadioButton.isSelected()) selectedGender = "Female";
        else if(otherRadioButton.isSelected()) selectedGender = "Other";

        int givenId = Integer.parseInt(idTextField.getText());
        String userType = userTypeComboBox.getValue();

        int idValidationCode = validateNewId(givenId,userType);

        if(idValidationCode == 0) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Validation failed! Given ID has invalid No of digits!");
            a.showAndWait();
        }
        else if (idValidationCode == -1) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Validation failed! Duplicate, given ID is already used!");
            a.showAndWait();
        }
        else{   // no duplicate found
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            try{
                File f = new File( userType+".bin" );
                if(f.exists())
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                else
                    oos = new ObjectOutputStream(new FileOutputStream(f));

                if(userType.equals("Student")){
                    Student newStudent = new Student(
                        //...,...,...,
                    );
                    oos.writeObject(newStudent);
                }
                else if(userType.equals("Faculty")){
                    Faculty newFaculty = new Faculty(
                        Integer.parseInt(idTextField.getText()),
                        nameTextField.getText(),
                        selectedGender,
                        emailTextField.getText(),
                        dobDatePicker.getValue(),
                        dojDatePicker.getValue(),
                        designationComboBox.getValue(),
                        empDeptComboBox.getValue(),
                        Float.parseFloat(salaryTextField.getText()),
                        publicationNoComboBox.getValue()
                    );
                    System.out.println(newFaculty);
                    oos.writeObject(newFaculty);
                }
                else if(userType.equals("Accountant")){
                    Accountant newAccountant = new Accountant(
                        //...,...,...,
                    );
                    oos.writeObject(newAccountant);
                }
                // add more else if blocks for remaining user types, too
                oos.close();
            }
            catch(Exception e){
                //
            }
        }
    }

    private int validateNewId(int givenId, String selectedUserType) {
        if (selectedUserType.equals("Student")) {
            if (givenId < 1000000 || givenId >= 10000000) {
                return 0; // invalid id length
            }
        } else if (
                selectedUserType.equals("Faculty")
                        || selectedUserType.equals("Accountant")
                        || selectedUserType.equals("Admission Officer")
                        // || check equality for all other remaining users
                        || selectedUserType.equals("Supplier")
        ) {
            if (givenId < 1000 || givenId >= 10000) {
                return 0; // invalid id length
            }
        }
        return User.isDuplicateId(givenId);
    }
}