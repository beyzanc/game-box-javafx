package gamebox;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    Button button;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        int counter = 0;
        Controller controller = new Controller();
        primaryStage.setTitle("Game BOX");
        Label levelInfo = new Label("Level#1");
        Label score = new Label("0");
        Label highScore = new Label("High Score:3");

        BorderPane topPane = new BorderPane();/
        topPane.setLeft(levelInfo);
        topPane.setCenter(score);
        topPane.setRight(highScore);
        GridPane centerPane = new GridPane();/
        Label bottomLabel = new Label("---Text---");
        BorderPane bottomPane = new BorderPane();
        bottomPane.setLeft(bottomLabel);
        for(int i = 0;i<10;i++)
        {
            for(int j  = 0;j<10;j++)
            {
                button = new Button();
                button.setStyle("-fx-border-color: dimgrey ; -fx-background-color: grey  ; -fx-border-width: 2.5");
                button.setPrefSize(200,200);
                button.setMinSize(40,40);
                button.setId(Integer.toString(j)+ "," + Integer.toString(i) + "," + "Wall" + "," + Integer.toString(counter) + "," + "0" );
                EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        controller.gameFunc(centerPane, (Node) actionEvent.getSource());
                        controller.finalScore(score,controller.infoTransferred.score);
                        controller.showHit(bottomLabel,centerPane);
                        controller.infoTransferred.locations.clear();
                        controller.setNewHighScore(score,highScore,centerPane);
                        controller.nextLevel(bottomPane,bottomLabel,centerPane,levelInfo,score);
                        
                    }
                };
                counter+=1;
                button.setOnAction(event);
                centerPane.add(button,i,j);

            }
        }

        controller.levelSelection(centerPane,"1");
                                                       
        BorderPane mainWindow = new BorderPane();
        mainWindow.setTop(topPane);
        mainWindow.setCenter(centerPane);
        mainWindow.setBottom(bottomPane);
        Scene scene = new Scene(mainWindow,550,500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
