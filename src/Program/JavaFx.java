package Program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.io.IOException;

public class JavaFx {

    public void press_btn_exit(ActionEvent event){
        System.exit(0);
    }
    public void press_btn_highscore(ActionEvent event) throws IOException {
        Parent hs = FXMLLoader.load(getClass().getResource("Highscore.fxml"));
        Scene scene = new Scene(hs);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    public void press_btn_back(ActionEvent event) throws IOException {

        Parent hs = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(hs);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

    public void press_btn_play(ActionEvent event) throws IOException{
        Parent hs = FXMLLoader.load(getClass().getResource("SelectScene.fxml"));
        Scene scene = new Scene(hs);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }

    public void press_btn_level1(ActionEvent event) throws IOException{
        //Parent hs = FXMLLoader.load(getClass().getResource("level1.fxml"));
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane);

        //ezt kell kb. megirni betaban
        Canvas canvas= new Canvas();

        pane.setCenter(canvas);
        Button b = new Button();
        pane.setTop(b);
        //beta vege

        //ide kell Beta cucc hivasa a Scene gecivel, meg hogy melyik textfajlbol toltse mapet


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

    }


}
