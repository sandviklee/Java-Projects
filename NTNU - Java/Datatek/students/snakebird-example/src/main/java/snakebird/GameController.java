package snakebird;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class GameController {

    private Game game;
    private ISaveHandler saveHandler = new SaveHandler();

    @FXML
    Pane board;

    @FXML
    TextField filename;

    @FXML
    Text fileNotFoundMessage;

    @FXML
    public void initialize() {
        game = new Game(16, 12);
        game.getTile(6, 11).setGround();
        game.getTile(7, 11).setGround();
        game.getTile(8, 11).setGround();
        game.getTile(6, 10).setGround();
        game.getTile(7, 10).setGround();
        game.getTile(8, 10).setGround();
        game.getTile(9, 10).setGround();
        game.getTile(6, 9).setGround();
        game.getTile(7, 9).setGround();
        game.getTile(8, 9).setGround();
        game.getTile(9, 9).setGround();
        game.getTile(6, 8).setGround();
        game.getTile(8, 6).setGround();
        game.getTile(10, 6).setGround();
        game.getTile(5, 5).setGround();
        game.getTile(5, 6).setFruit();
        game.getTile(9, 6).setFruit();
        game.getTile(8, 3).setGoal();

        game.createSnake(Arrays.asList(game.getTile(9, 8), game.getTile(8, 8)));

        createBoard();
        drawBoard();
    }

    private void createBoard() {
        board.getChildren().clear();
        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidth(); x++) {
                Pane tile = new Pane();
                tile.setTranslateX(x * 20);
                tile.setTranslateY(y * 20);
                tile.setPrefWidth(20);
                tile.setPrefHeight(20);
                board.getChildren().add(tile);
            }
        }
    }

    private String getTileColor(Tile tile) {
        if (game.isSnakeHead(tile)) {
            return "#1db121";
        } else if (tile.isSnake()) {
            return "#24d628";
        } else if (tile.isGround()) {
            return "#a26f42";
        } else if (tile.isFruit()) {
            return "#e5303a";
        } else if (tile.isGoal()) {
            return "#f6ec5a";
        }
        return "#7bcaf2";
    }

    @FXML
    void handleUp() {
        game.moveUp();
        drawBoard();
    }

    @FXML
    void handleDown() {
        game.moveDown();
        drawBoard();
    }

    @FXML
    void handleLeft() {
        game.moveLeft();
        drawBoard();
    }

    @FXML
    void handleRight() {
        game.moveRight();
        drawBoard();
    }

    private String getFilename() {
        String filename = this.filename.getText();
        if (filename.isEmpty()) {
            filename = "save_file";
        }
        return filename;
    }

    @FXML
    void handleSave() {
        try {
            saveHandler.save(getFilename(), game);
            fileNotFoundMessage.setVisible(false);
        } catch (FileNotFoundException e) {
            fileNotFoundMessage.setVisible(true);
        }
    }

    @FXML
    void handleLoad() {
        try {
            game = saveHandler.load(getFilename());
            fileNotFoundMessage.setVisible(false);
        } catch (FileNotFoundException e) {
            fileNotFoundMessage.setVisible(true);
        }
        createBoard();
        drawBoard();
    }

    private void drawBoard() {
        for (int y = 0; y < game.getHeight(); y++) {
            for (int x = 0; x < game.getWidth(); x++) {
                board.getChildren().get(y * game.getWidth() + x)
                        .setStyle("-fx-background-color: " + getTileColor(game.getTile(x, y)));
            }
        }

        if (game.isGameWon()) {
            Text wonText = new Text();
            wonText.setText("You Won!");
            wonText.setFill(Color.GREEN);
            wonText.setStyle("-fx-font-size: 40px;");
            wonText.setTranslateX(((double) game.getWidth() * 20) / 2 - 80);
            wonText.setTranslateY(((double) game.getHeight() * 20) / 2);
            board.getChildren().add(wonText);
        } else if (game.isGameOver()) {
            Text lostText = new Text();
            lostText.setText("You Lost!");
            lostText.setStyle("-fx-font-size: 40px;");
            lostText.setFill(Color.RED);
            lostText.setTranslateX(((double) game.getWidth() * 20) / 2 - 80);
            lostText.setTranslateY(((double) game.getHeight() * 20) / 2);
            board.getChildren().add(lostText);
        }
    }

}
