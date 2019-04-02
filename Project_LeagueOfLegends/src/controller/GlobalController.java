package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GlobalController {

    public void exitProgram(JFXButton button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public void miniProgram(AnchorPane anchorPane) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setIconified(true);
    }


    public void dialogConfirmExit(StackPane stackPane, AnchorPane anchorPane, JFXButton buttonClose){
        buttonClose.getScene().getStylesheets().add("src/asset_public/css/application.css");
        BoxBlur blur = new BoxBlur(3,3,5);

        JFXDialogLayout content = new JFXDialogLayout();
        Label labelHeading = new Label("Thoát chương trình");
        labelHeading.setTextFill(Color.web("#f1f1f1"));
        content.setHeading(labelHeading);

        content.setBody(new Label("Bạn có chắc muốn thoát!"));
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);

        JFXButton btnYes = new JFXButton("Đồng ý");
        btnYes.setId("btnConfirm");

        JFXButton btnNo = new JFXButton("Quay lại");
        btnNo.setId("btnConfirm");
        btnNo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });

        btnYes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GlobalController controller = new GlobalController();
                controller.exitProgram(buttonClose);
            }
        });

        dialog.setOnDialogClosed(new EventHandler<JFXDialogEvent>() {
            @Override
            public void handle(JFXDialogEvent event) {
                anchorPane.setEffect(null);
            }
        });

        content.setActions(btnNo, btnYes);
        content.setId("dialogConfirmExit");
        dialog.show();

        anchorPane.setEffect(blur);
    }

    public void checkboxesClient(JFXCheckBox checkboxAnimation, JFXCheckBox checkboxMusic, MediaPlayer mediaPlayer){
        if (checkboxAnimation.isSelected()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
        if (checkboxMusic.isSelected()) {
            mediaPlayer.setMute(true);
        } else {
            mediaPlayer.setMute(false);
        }
    }

}
