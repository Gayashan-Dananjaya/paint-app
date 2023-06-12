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
        startXReal = mouseEvent.getX();
        startYReal = mouseEvent.getY();
        if (isText) {
            isTextPositionSet = true;
            cnvMain.setCursor(Cursor.TEXT);
            cnvMain.requestFocus();
            hBox.setLayoutX(startXReal);
            hBox.setLayoutY(startYReal);
            hBox.setVisible(true);
            text = "";
            lblTypedText.setText(text);


            timeline.playFromStart();
        }
    }

    public void cnvMainOnMouseDragged(MouseEvent mouseEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        endXReal = mouseEvent.getX();
        endYReal = mouseEvent.getY();
//        if (isRect) {
//            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
//            gc.beginPath();
//            gc.rect(startX, startY, mouseEvent.getX() - startX, mouseEvent.getY() - startY);
//            gc.fill();
//            gc.stroke();
//        }
        if (isRect) {
            if (startXReal > endXReal) {
                startX = endXReal;
                endX = startXReal;
            } else {
                startX = startXReal;
                endX = endXReal;
            }
            if (startYReal > endYReal) {
                startY = endYReal;
                endY = startYReal;
            } else {
                startY = startYReal;
                endY = endYReal;
            }

            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            gc.strokeRect(startX, startY, endX - startX, endY - startY);
        }
        if (isRoundRect) {
            System.out.println("Round Rectangle");
            if (startXReal > endXReal) {
                startX = endXReal;
                endX = startXReal;
            } else {
                startX = startXReal;
                endX = endXReal;
            }
            if (startYReal > endYReal) {
                startY = endYReal;
                endY = startYReal;
            } else {
                startY = startYReal;
                endY = endYReal;
            }

            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            gc.strokeRoundRect(startX, startY, endX - startX, endY - startY, 20, 20);
        }
        if (isCircle) {
            System.out.println("Circle");
            if (startXReal > endXReal) {
                startX = endXReal;
                endX = startXReal;
            } else {
                startX = startXReal;
                endX = endXReal;
            }
            if (startYReal > endYReal) {
                startY = endYReal;
                endY = startYReal;
            } else {
                startY = startYReal;
                endY = endYReal;
            }

            double width = endX - startX;
            double height = endY - startY;
            minLength = Math.min(width, height);

            if ((startXReal - startX) > minLength) startX = startXReal - minLength;
            if ((startYReal - startY) > minLength) startY = startYReal - minLength;


            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            Paint color = gc.getStroke();
            gc.setStroke(Color.LIGHTGRAY);
            gc.strokeRect(startX, startY, minLength, minLength);
            gc.setStroke(color);
            gc.strokeOval(startX, startY, minLength, minLength);
        }
        if (isOval) {
            System.out.println("Oval");
            if (startXReal > endXReal) {
                startX = endXReal;
                endX = startXReal;
            } else {
                startX = startXReal;
                endX = endXReal;
            }
            if (startYReal > endYReal) {
                startY = endYReal;
                endY = startYReal;
            } else {
                startY = startYReal;
                endY = endYReal;
            }

            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            Paint color = gc.getStroke();
            gc.setStroke(Color.LIGHTGRAY);
            gc.strokeRect(startX, startY, endX - startX, endY - startY);
            gc.setStroke(color);
            gc.strokeOval(startX, startY, endX - startX, endY - startY);
        }
        if (isPencil) {
            System.out.println("Pencil");
            gc.strokeLine(startXReal, startYReal, mouseEvent.getX(), mouseEvent.getY());
            startXReal = mouseEvent.getX();
            startYReal = mouseEvent.getY();
        }
        if (isEraser) {
            gc.clearRect(mouseEvent.getX(), mouseEvent.getY(), 25,25);
        }

    }

    public void cnvMainOnMouseReleased(MouseEvent mouseEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        if (isRect) {
            gc.fillRect(startX, startY, endX - startX, endY - startY);
        }
        if (isRoundRect) {
            gc.fillRoundRect(startX, startY, endX - startX, endY - startY, 20, 20);
        }
        if (isCircle) {
            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            gc.strokeOval(startX, startY, minLength, minLength);
            gc.fillOval(startX, startY, minLength, minLength);
        }
        if (isOval) {
            gc.clearRect(0, 0, cnvMain.getWidth(), cnvMain.getHeight());
            gc.strokeOval(startX, startY, endX - startX, endY - startY);
            gc.fillOval(startX, startY, endX - startX, endY - startY);
        }
    }

    public void cnvMainOnKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().getName().equals("Backspace")) {
            if (text.length() > 0) text = text.substring(0, text.length() - 1);
        } else text += keyEvent.getText();
        lblTypedText.setText(text);
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFont(Font.font("", FontWeight.THIN,20));
        gc.clearRect(0,0,cnvMain.getWidth(), cnvMain.getHeight());
        gc.strokeText(text,startXReal,startYReal+20);
        gc.fillText(text,startXReal,startYReal+20);
    }

    /*Label Rectangle*/
    public void lblRectangleOnMouseDragged(MouseEvent mouseEvent) {
//        vBox.setLayoutX(vBoxStartX + (mouseEvent.getScreenX() - startScreenX));
//        vBox.setLayoutY(vBoxStartY + (mouseEvent.getScreenY() - startScreenY));
        double x = vBoxStartX + (mouseEvent.getScreenX() - startScreenX);
        double y = vBoxStartY + (mouseEvent.getScreenY() - startScreenY);

        if (x < -20) vBox.setLayoutX(0);
        else vBox.setLayoutX(vBoxStartX + (mouseEvent.getScreenX() - startScreenX));
        vBox.setLayoutY(vBoxStartY + (mouseEvent.getScreenY() - startScreenY));



    }

    public void lblRectangleOnMouseEntered(MouseEvent mouseEvent) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1), lblRectangle);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.playFromStart();

    }

    public void lblRectangleOnMouseExited(MouseEvent mouseEvent) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1), lblRectangle);
        scaleTransition.setFromX(1.1);
        scaleTransition.setFromY(1.1);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.playFromStart();
    }

    public void lblRectangleOnMousePressed(MouseEvent mouseEvent) {
        vBoxStartX = vBox.getLayoutX();
        vBoxStartY = vBox.getLayoutY();
        startScreenX = mouseEvent.getScreenX();
        startScreenY = mouseEvent.getScreenY();
        lblRectangle.setOpacity(0.7);
        lblRectangle.setCursor(Cursor.MOVE);
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
