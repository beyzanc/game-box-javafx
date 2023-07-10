package gamebox;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    object1 infoTransferred = new object1();
    public void levelSelection(GridPane gridPane,String level) throws FileNotFoundException {

        File file = new File(String.format("C:\\Users\\beyza\\Desktop\\levels\\level%s.txt",level));
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            String fullLine = scanner.nextLine();
            String[] lines = fullLine.split(",");
            for (Node n : gridPane.getChildren())
            {
                String nodeId = n.getId();
                String[] fullNodeId = nodeId.split(",");
                if (lines[1].equals(fullNodeId[0]) && (lines[2].equals(fullNodeId[1])))
                {
                    n.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + lines[0]);
                    if (lines[0].equals("Empty")) {
                        n.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                        n.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                        break;
                    }
                    else if (lines[0].equals("Mirror")) {
                        n.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                        n.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                        break;
                    }
                    else{
                            n.setStyle("-fx-border-color: deeppink ; -fx-background-color: hotpink  ; -fx-border-width: 2.5");
                            n.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Wood" + "," + fullNodeId[3] + "," + "3");
                            break;
                        }
                }
            }
        }
        scanner.close();
    }
    public int gameFunc(GridPane gridPane,Node node)
    {
        infoTransferred.score = 0;
        int newNodeLocation = 0,newNodeLocation2 = 0,score = 0;
        String[] fullNodeId = node.getId().split(",");
        int boxLocation = Integer.parseInt(fullNodeId[3]);
        if (fullNodeId[2].equals("Wall") || fullNodeId[2].equals("Empty"))
            return 0;
        else if (fullNodeId[2].equals("Wood"))
        {
            if (boxLocation == 0)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 10;
                for (Node n : gridPane.getChildren())
                {
                    fullNodeId = n.getId().split(",");
                    if (fullNodeId[3].equals("1"))
                    {
                        score += getScore(fullNodeId, n);

                    }
                    else if (fullNodeId[3].equals("11"))
                    {
                        score += getScore(fullNodeId, n);
                  
                    }
                }
                infoTransferred.score = scoreCount(score);


            }
            else if (boxLocation == 9)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score+=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);

            }
            else if (boxLocation == 90)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score+=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                infoTransferred.score += scoreCount(score);
                return scoreCount(score);
            }
            else if (boxLocation == 99)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score+=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 10;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if (((boxLocation/10) == 0) && (0<boxLocation) && (boxLocation>9))
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if ((boxLocation % 10) == 0)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 10;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if (boxLocation == 19 || boxLocation == 29 || boxLocation == 39 || boxLocation == 49 || boxLocation == 59
            || boxLocation == 69 || boxLocation  == 79 || boxLocation == 89)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 10;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if ((boxLocation % 91) > 0 && (boxLocation % 91) < 8)
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) - 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else
            {
                node.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) - 10;
                int newNodeLocation4 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                score += getScore1(gridPane,newNodeLocation4);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }


        }
        else
        {
            if (boxLocation == 0)
            {

                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 10;
                for (Node n : gridPane.getChildren())
                {
                    fullNodeId = n.getId().split(",");
                    if (fullNodeId[3].equals("1"))
                    {
                        score += getScore(fullNodeId, n);

                    }
                    else if (fullNodeId[3].equals("11"))
                    {
                        score += getScore(fullNodeId, n);
                    }
                }
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if (boxLocation == 9)
            {

                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score+=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);

            }
            else if (boxLocation == 90)
            {

                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score+=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if (boxLocation == 99)
            {

                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score+=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 10;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if (((boxLocation/10) == 0) && (0<boxLocation) && (boxLocation>9))
            {

                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if ((boxLocation % 10) == 0)
            {
                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 10;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) + 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if (boxLocation == 19 || boxLocation == 29 || boxLocation == 39 || boxLocation == 49 || boxLocation == 59
                    || boxLocation == 69 || boxLocation  == 79 || boxLocation == 89)
            {
                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) - 10;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else if ((boxLocation % 91) >= 0 && (boxLocation % 91) < 8)
            {
                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) - 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }
            else
            {
                node.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
                node.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
                infoTransferred.locations.add(fullNodeId[3]);
                score +=1;
                newNodeLocation = Integer.parseInt(fullNodeId[3]) + 1 ;
                newNodeLocation2 = Integer.parseInt(fullNodeId[3]) - 1;
                int newNodeLocation3 = Integer.parseInt(fullNodeId[3]) - 10;
                int newNodeLocation4 = Integer.parseInt(fullNodeId[3]) + 10;
                score += getScore1(gridPane, newNodeLocation);
                score += getScore1(gridPane, newNodeLocation2);
                score += getScore1(gridPane,newNodeLocation3);
                score += getScore1(gridPane,newNodeLocation4);
                infoTransferred.score = scoreCount(score);
                return scoreCount(score);
            }


        }
        return score;


    }

    public int getScore1(GridPane gridPane, int newNodeLocation) {
        String[] fullNodeId;
        for (Node n : gridPane.getChildren())
        {
            String newNodeLocationId = Integer.toString(newNodeLocation);
            fullNodeId = n.getId().split(",");
            if (fullNodeId[3].equals(newNodeLocationId))
            {
                int score= getScore(fullNodeId,n);
                if (score == 1){
                    return 1;}
                else {
                    return 0;

                }
            }

        }
        return 0;
    }

    public int getScore(String[] fullNodeId, Node n) {

        if (fullNodeId[4].equals("3"))
        {
            n.setStyle("-fx-border-color: deepskyblue ; -fx-background-color: cyan  ; -fx-border-width: 2.5");
            n.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Mirror" + "," + fullNodeId[3] + "," + "2");
            infoTransferred.locations.add(fullNodeId[3]);
            return 1;
        }
        else if (fullNodeId[4].equals("2"))
        {
            n.setStyle("-fx-border-color: silver ; -fx-background-color: White  ; -fx-border-width: 2.5");
            n.setId(fullNodeId[0] + "," + fullNodeId[1] + "," + "Empty" + "," + fullNodeId[3] + "," + "1");
            infoTransferred.locations.add(fullNodeId[3]);
            return 1;
        }

        else
        {

            return 0;
        }

    }
    public int scoreCount(int score)
    {
        if (score == 1)
            return -3;
        else if (score == 2)
            return -1;
        else if (score == 3)
            return 1;
        else if (score == 4)f
            return 2;
        else if (score == 5)
            return 4;
        return 0;
    }
    public void finalScore(Label label, int object)
    {
        int oldScore = Integer.parseInt(label.getText());
        int newScore = object + oldScore;
        label.setText(Integer.toString(newScore));
    }
    public void setNewHighScore(Label score,Label highScore,GridPane gridPane)
    {
        int counter = 0;
        for (Node node : gridPane.getChildren())
        {
            String[] fullNodeId = node.getId().split(",");
            if (fullNodeId[2].equals("Mirror") || fullNodeId[2].equals("Wood"))
            {
                break;
            }
            else counter++;

        }
        if (counter == 100)
    {
        String[] highScoreSplit = highScore.getText().split(":");
        if (Integer.parseInt(score.getText()) > Integer.parseInt( highScoreSplit[1])) {
            highScore.setText("High Score:" + score.getText());
        }
    }

    }
    public void showHit(Label bottomLabel,GridPane gridPane)
    {
        int firstHit = 0;
        String[] fullNodeId;
        String newString = "",score ="";

        for (String string : infoTransferred.locations)
        {
            for(Node node1:gridPane.getChildren())
            {
                fullNodeId = node1.getId().split(",");
                if (firstHit == 0)
                {
                    if (fullNodeId[3].equals(string))
                    {
                        newString = "Box:" + fullNodeId[0]+ "-" +fullNodeId[1];
                        firstHit++;
                    }
                }
                else
                    if (fullNodeId[3].equals(string))
                {
                    newString = newString.concat(" - " +"Hit:" + fullNodeId[0] + "," + fullNodeId[1]);
                    firstHit++;
                }

            }
        }
        if (firstHit == 1)
            score = "-3";
        else if (firstHit == 2)
            score = "-1";
        else if (firstHit == 3)
            score = "+1";
        else if (firstHit == 4)
            score = "+2";
        else if (firstHit == 5)
            score = "+4";
        newString = newString.concat("(" + score + ")");
        bottomLabel.setText(newString);

    }
    public void nextLevel(BorderPane bottomPane,Label bottomLabel,GridPane gridPane,Label level,Label score)
    {
        int counter = 0;
        Button button = new Button("Next Level >>");
        button.setStyle("-fx-background-color: transparent ; -fx-border-color: transparent");
        for (Node node : gridPane.getChildren())
        {
            String[] fullNodeId = node.getId().split(",");
            if (fullNodeId[2].equals("Wood") || fullNodeId[2].equals("Mirror"))
                break;
            else counter++;
        }
        if (counter == 100)
        {
            String[] levelSplit = level.getText().split("#");
            if (Integer.parseInt(levelSplit[1]) < 5) {
                int newLevel = Integer.parseInt(levelSplit[1]) + 1;
                EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try {
                            score.setText("0");
                            level.setText(levelSplit[0] + "#" + Integer.toString(newLevel));
                            levelSelection(gridPane, Integer.toString(newLevel));
                            bottomLabel.setText("---Text---");
                            bottomPane.setRight(null);
                        } catch (FileNotFoundException e) {
                            bottomLabel.setText("Sorry. Couldn't find the next level file");

                        }

                    }
                };button.setOnAction(eventHandler);
            }
            else {
                bottomPane.setRight(null);
                bottomLabel.setText("Congrats!)");
            }
            bottomPane.setRight(button);
        }
    }
}
