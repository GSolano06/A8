import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.FileInputStream;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.geometry.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javax.swing.*;
import javax.swing.text.rtf.RTFEditorKit;


public class Main extends Application {
    int numOfCookies = 0;
    int numOfDonuts = 0;


    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("THEN");

        // Controls
        Label label1 = new Label("Welcome to your Fave App");
        label1.setLineSpacing(10);
        label1.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        Text text1 = new Text("# of Cookies: "+ numOfCookies);
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 36));;

        FileInputStream input = new FileInputStream("src/chocoChip.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(250);
        imageView.setFitWidth(300);


        FileInputStream input2 = new FileInputStream("src/donut.png");
        Image image2 = new Image(input2);

        FileInputStream input3 = new FileInputStream("src/lucki.jpeg");
        Image image3 = new Image(input3);
        ImageView imageView2 = new ImageView(image3);
        imageView2.setImage(image3);
        imageView2.setFitHeight(900);
        imageView2.setFitWidth(900);





        ColorPicker colorPicker1 = new ColorPicker();
        colorPicker1.setVisible(false);


        BackgroundFill backgroundFill = new BackgroundFill(Color.PURPLE, CornerRadii.EMPTY,Insets.EMPTY);
        Background background = new Background(backgroundFill);


        final ToggleGroup group1 = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Cookies");
        rb1.setToggleGroup(group1);
        rb1.setSelected(true);



        RadioButton rb2 = new RadioButton("Donuts");
        rb2.setToggleGroup(group1);


        Button button1 = new Button("Click Me", imageView);
        button1.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        button1.setMinSize(200,200);

        ChoiceBox cb1 = new ChoiceBox();

        cb1.getItems().addAll("X6");



        rb1.setOnAction(actionEvent -> {
            imageView.setImage(image);
            text1.setText("# of Cookies: "+ numOfCookies);

            button1.setOnAction(actionEvent2 -> {
                System.out.println("NOW");
                numOfCookies = numOfCookies + 1;
                text1.setText("# of Cookies: "+ numOfCookies);
                colorPicker1.setVisible(true);

            });


        });


        rb2.setOnAction(actionEvent -> {
            imageView.setImage(image2);
            text1.setText("# of DONUTS: " + numOfDonuts);

            System.out.println("good choice");
            button1.setOnAction(actionEvent2 -> {
                System.out.println("NOW DONUTS");
                numOfDonuts = numOfDonuts + 1;
                text1.setText("# of DONUTS: " + numOfDonuts);
                imageView.setImage(image2);
                colorPicker1.setVisible(true);

            });

        });


        cb1.setOnAction(actionEvent -> {
            text1.setText("LUCKI IS THE GOAT! \n LISTEN TO FLM BY LUCKI. \n RESTART TO PLAY AGAIN");
            text1.setFill(Color.PURPLE);
            imageView.setImage(image3);
            imageView.setFitHeight(900);
            imageView.setFitWidth(900);
            rb1.setVisible(false);
            rb2.setVisible(false);
            colorPicker1.setVisible(false);
            label1.setVisible(false);





        });




        // Layouts
        HBox hbox1 = new HBox(button1, text1);
        VBox vbox2 = new VBox(label1, hbox1);
        VBox vbox3 = new VBox(vbox2, colorPicker1);
        VBox vbox4 = new VBox(vbox3, rb1);
        VBox vbox5 = new VBox(vbox4, rb2);
        HBox hbox4 = new HBox(vbox5, cb1);


        // Background Setting

        colorPicker1.setOnAction(actionEvent -> {
            Color value = colorPicker1.getValue();
            BackgroundFill backgroundFill2 = new BackgroundFill(value, CornerRadii.EMPTY,Insets.EMPTY);
            Background background2 = new Background(backgroundFill2);
            vbox5.setBackground(background2);



        });


        // Scenes
        Scene scene1 = new Scene(hbox4,800,800);

        // Stages
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Cookie Clicker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}