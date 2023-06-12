package lk.ijse.dep10.app.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.net.URL;
import java.util.Arrays;

public class MainFormController {
    public VBox vBox;
    public Label lblRectangle;
    public ColorPicker clrStroke;
    public ColorPicker clrFill;
    public Canvas cnvMain;
    public Button btnRect;
    public Button btnRoundRect;
    public Button btnOval;
    public Button btnCircle;
    public Button btnPencil;
    public Button btnEraser;
    public Button btnText;
    public HBox hBox;
    public Label lblTypedText;
    public Label lblCursorIcon;

    /*Created Variables*/
    double startXReal;
    double startYReal;
    double endXReal;
    double endYReal;
    double startX;
    double startY;
    double endX;
    double endY;
    double vBoxStartX;
    double vBoxStartY;
    double startScreenX;
    double startScreenY;
    double minLength = 0;
    String text;
    Timeline timeline = new Timeline();


    /*Function variables*/ boolean isRect = false;
    boolean isRoundRect = false;
    boolean isCircle = false;
    boolean isOval = false;
    boolean isPencil = false;
    boolean isEraser = false;
    boolean isText = false;
    boolean isTextPositionSet = false;

    public void initialize() {
        lblRectangle.setTooltip(new Tooltip("Drag the Toolbox"));
        btnRect.setTooltip(new Tooltip("Draw Rectangle"));
        btnRoundRect.setTooltip(new Tooltip("Draw Rounded corner Rectangle"));
        btnCircle.setTooltip(new Tooltip("Draw Circle"));
        btnOval.setTooltip(new Tooltip("Draw Oval"));
        btnPencil.setTooltip(new Tooltip("Draw with pencil"));
        btnEraser.setTooltip(new Tooltip("Erase the drawings"));
        btnText.setTooltip(new Tooltip("Enter text"));
        clrStroke.setTooltip(new Tooltip("Pick the stroke color"));
        clrFill.setTooltip(new Tooltip("Pick the fill color"));
        vBox.setTranslateY(160);
        vBox.setTranslateX(20);
        hBox.setVisible(false);
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.WHITE);
        lblTypedText.setVisible(false);
        clrFill.setValue(Color.RED);
        clrStroke.setValue(Color.DARKVIOLET);
        gc.setStroke(Color.DARKVIOLET);
        gc.setFill(Color.RED);
        KeyFrame key1 = new KeyFrame(Duration.seconds(0), event -> {
            lblCursorIcon.setVisible(true);
        });
        KeyFrame key2 = new KeyFrame(Duration.seconds(0.75), event -> {
            lblCursorIcon.setVisible(false);
        });
        KeyFrame key3 = new KeyFrame(Duration.seconds(1.5), event -> {
            lblCursorIcon.setVisible(true);
        });
        timeline.getKeyFrames().add(key1);
        timeline.getKeyFrames().add(key2);
        timeline.getKeyFrames().add(key3);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    /*Canvas*/
    public void cnvMainOnMousePressed(MouseEvent mouseEvent) {

    }

    public void cnvMainOnMouseDragged(MouseEvent mouseEvent) {

    }

    public void cnvMainOnMouseReleased(MouseEvent mouseEvent) {

    }

    public void cnvMainOnKeyPressed(KeyEvent keyEvent) {

    }

    /*Label Rectangle*/
    public void lblRectangleOnMouseDragged(MouseEvent mouseEvent) {

    }

    public void lblRectangleOnMouseEntered(MouseEvent mouseEvent) {


    }

    public void lblRectangleOnMouseExited(MouseEvent mouseEvent) {

    }

    public void lblRectangleOnMousePressed(MouseEvent mouseEvent) {

    }

    public void lblRectangleOnMouseReleased(MouseEvent mouseEvent) {

    }


    /*Stroke Button*/
    public void clrStrokeOnAction(ActionEvent actionEvent) {

    }

    public void clrStrokeOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void clrStrokeOnMouseExited(MouseEvent mouseEvent) {

    }

    public void clrStrokeOnMousePressed(MouseEvent mouseEvent) {

    }

    public void clrStrokeOnMouseReleased(MouseEvent mouseEvent) {

    }


    /*Fill Button*/
    public void clrFillOnAction(ActionEvent actionEvent) {

    }

    public void clrFillOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void clrFillOnMouseExited(MouseEvent mouseEvent) {

    }

    public void clrFillOnMousePressed(MouseEvent mouseEvent) {
 
    }

    public void clrFillOnMouseReleased(MouseEvent mouseEvent) {

    }

    /*Button rectangle*/
    public void btnRectOnAction(ActionEvent actionEvent) {

    }

    public void btnRectOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnRectOnMouseExited(MouseEvent mouseEvent) {

    }

    public void btnRoundRectOnAction(ActionEvent actionEvent) {

    }

    public void btnRoundRectOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnRoundRectOnMouseExited(MouseEvent mouseEvent) {

    }

    public void btnCircleOnAction(ActionEvent actionEvent) {

    }

    public void btnCircleOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnCircleOnMouseExited(MouseEvent mouseEvent) {

    }

    public void btnOvalOnAction(ActionEvent actionEvent) {

    }

    public void btnOvalOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnOvalOnMouseExited(MouseEvent mouseEvent) {

    }

    public void btnPencilOnAction(ActionEvent actionEvent) {

    }

    public void btnPencilOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnPencilOnMouseExited(MouseEvent mouseEvent) {

    }

    public void btnEraserOnAction(ActionEvent actionEvent) {

    }

    public void btnEraserOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnEraserOnMouseExited(MouseEvent mouseEvent) {

    }


    public void btnTextOnAction(ActionEvent actionEvent) {

    }

    public void btnTextOnMouseEntered(MouseEvent mouseEvent) {

    }

    public void btnTextOnMouseExited(MouseEvent mouseEvent) {

    }



}
