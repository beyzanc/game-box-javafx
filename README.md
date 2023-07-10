# Game Box

Game Box is a JavaFX game where the user aims to destroy all the boxes on the grid with the highest score and the fewest clicks. The game consists of multiple levels, and the user must complete each level to progress to the next. The level layouts are created based on input files stored in the "levels" folder.

## **Objective**

The objective of Game Box is to strategically click on boxes in the 10x10 grid to destroy them. Clicking on a box not only destroys the box itself but also affects its neighboring boxes. The user's goal is to clear the grid by destroying all the boxes while maximizing their score and minimizing the number of clicks.

## Architecture

The game follows the Model-View-Controller (MVC) design pattern. The main class inherits from the Applications class in JavaFX. The program utilizes BorderPanes for layout management, with labels in the top pane, the grid of boxes in the center pane, and the bottom label in the bottom pane. Buttons are created dynamically using a nested loop.

The Controller class handles the logic and backend operations. It includes methods to read and update level selections, handle button clicks, calculate scores, set new high scores, and display hit information. It also checks for level completion and handles exceptions.

## UML Class Diagram
![](https://github.com/beyzanc/game-box-javafx/blob/master/uml.png)


## Game Layout
Consists of three parts:

-  Top Pane: Displays the current level number, current score, and highest score.
-  Center Pane: Contains the 10x10 game board grid.
-  Bottom Pane: Shows information about the clicked box, its neighbors, and the obtained score.

## Box Types

|                   | Box Type                  | Description                        |
| ----------------- | ------------------------- | ---------------------------------    |
|![](https://github.com/beyzanc/game-box-javafx/blob/master/Resim1.png) | Empty Type Box            | It cannot be destroyed               |
|![](https://github.com/beyzanc/game-box-javafx/blob/master/Resim2.png) | Wall Type Box             | It cannot be destroyed               |
|![](https://github.com/beyzanc/game-box-javafx/blob/master/Resim3.png)| Mirror Type Box           | Durability (or life) value is 1. It returns to the empty box type if the click or hit occurs |
|![](https://github.com/beyzanc/game-box-javafx/blob/master/Resim4.png)| Wood Type Box             | Durability (or life) value is 2. It returns to the mirror box type and durability becomes 1 if the click or hit occurs |

## Level Progression

Game Box offers multiple levels, each defined by an input file located in the "levels" folder. To progress to the next level, the player must complete the current level by destroying all the applicable boxes. The game checks if all levels have been completed and displays a message when there are no more levels remaining.

## Sample Game Scenario
![](https://github.com/beyzanc/game-box-javafx/blob/master/ss.png)

![](https://github.com/beyzanc/game-box-javafx/blob/master/sss.png)
