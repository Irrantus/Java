/*
 * Harry Potter 
 * Group 243
 */

package studentlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.*;

/**
 *
 * @author Harry Potter 
 */
public class StudentList extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ListForm.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Verkin Igor.243");
        Image icon = new Image(getClass().getResourceAsStream("anarchy-symbol.jpg"));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
