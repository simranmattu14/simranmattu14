import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class TictactoeView {

    Stage stage;

    Pane pane;

    public TictactoeView(Stage stage){
        this.stage = stage;
        initUI();
    }

    private void initUI() {
        stage.setTitle("TicTacToe Game!!");

        pane = new Pane();

        Scene scene = new Scene(pane, 380, 450);
        this.stage.setScene(scene);
        this.stage.show();
    }
}
