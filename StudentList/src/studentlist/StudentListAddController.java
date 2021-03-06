/*
 * Frodo Baggins 
 * Group 243
 */

package studentlist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import student.Student;
import student.StaticData;



/**
 * FXML Controller class
 *
 * @author Frodo Baggins
 */
public class StudentListAddController  implements Initializable
{
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private DatePicker birthday;
    @FXML
    private ChoiceBox<String> departmentChoiceBox;
    @FXML
    private ChoiceBox<String> specialityChoiceBox;
    @FXML
    private ChoiceBox<String> courseChoiceBox;
    @FXML
    private TextField groupField;
    @FXML
    private Button bAdd;
    @FXML
    private DatePicker dateOfDelay;
    
    
    @FXML
     void onClickAdd(ActionEvent event)
    {
        if(!nameField.getText().matches("^\\D*$"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Name can not contain numbers.");
            alert.setContentText("Please check and try again!");

            alert.showAndWait();
            return;
        }
        else
        {
            //не містить
        }
        
        
        if(!surnameField.getText().matches("^\\D*$"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Name can not contain numbers.");
            alert.setContentText("Please check and try again!");

            alert.showAndWait();
            return;
        }
        else
        {
            //не містить
        }
        
        if (!isEmptyFields())
        {
            String department = (String) departmentChoiceBox.getSelectionModel().getSelectedItem().toString();
            String speciality = (String) specialityChoiceBox.getSelectionModel().getSelectedItem().toString();
            String course = (String) courseChoiceBox.getSelectionModel().getSelectedItem().toString();

            Student st = new Student(nameField.getText(),
                                 surnameField.getText(),
                                 birthday.getValue().toString(),
                                 department,
                                 speciality,
                                 course,
                                 groupField.getText(),
                                 dateOfDelay.getValue().toString());

            StaticData.data.add(st);
            Stage stage = (Stage) bAdd.getScene().getWindow();
            //close form Message
            stage.close();

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill in all the fields");
            alert.setContentText("Please check and try again!");
        }
    }
       
        private boolean isEmptyFields()
        {
        if (nameField.getText().isEmpty() ||
            surnameField.getText().isEmpty() || groupField.getText().isEmpty()
                || birthday.getValue().toString().equals("")||dateOfDelay.getValue().toString().equals(""))
                //fields is empty
                return true;
        else
            return false;

        }
        
        @Override
        public void initialize(URL url, ResourceBundle rb) 
        {
        ObservableList<String> listOfComputerScines = FXCollections.observableArrayList();
        listOfComputerScines.add("Software engineering");
        listOfComputerScines.add("Computer engineering");
        listOfComputerScines.add("Computer science");

        ObservableList<String> listOfMath = FXCollections.observableArrayList();
        listOfMath.add("Department of Applied Mathematics");
        listOfMath.add("Department of Algebra and Computer Science");
        listOfMath.add("Department of Mathematical Analysis");

        ObservableList<String> listOfPhysics = FXCollections.observableArrayList();
        listOfPhysics.add("Department of Physics");
        listOfPhysics.add("Department of Theoretical Physics");
        listOfPhysics.add("Department of Solid State Physics");
        listOfPhysics.add("Department of Physics of Semiconductors and Nanostructures");



        departmentChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
             String tmp = (String) departmentChoiceBox.getItems().get((Integer) number2);
             System.out.println(tmp);
             if (tmp.equals("Computer science"))
             {
                specialityChoiceBox.setItems(listOfComputerScines);
                specialityChoiceBox.getSelectionModel().select("Software engineering");
             }
             if (tmp.equals("Mathematics"))
             {
                specialityChoiceBox.setItems(listOfMath);
                specialityChoiceBox.getSelectionModel().select("Department of Applied Mathematics");
             }

             if (tmp.equals("Physics"))
             {
                specialityChoiceBox.setItems(listOfPhysics);
                specialityChoiceBox.getSelectionModel().select("Department of Physics");
             }

      }
    });    
    } 
}       
        

    
    
  
    

