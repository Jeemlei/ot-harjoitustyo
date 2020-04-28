/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import domain.GameServices;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ui.JuomapeliUI;

/**
 * FXML Controller class
 *
 * @author Eemeli
 */
public class EndSceneController implements Initializable {

    private GameServices game;
    private JuomapeliUI application;

    /**
     * Sets the game logic used by this controller.
     *
     * @param gameServices object with the game services
     */
    public void setGameDomain(GameServices gameServices) {
        this.game = gameServices;
    }

    /**
     * Sets the main UI-class used by this controller.
     *
     * @param application UI with a scene controlled by this controller
     */
    public void setApplication(JuomapeliUI application) {
        this.application = application;
    }

    @FXML
    private void newGame(ActionEvent event) {
        this.application.setStartScene();
    }

    @FXML
    private void quitGame(ActionEvent event) {
        this.application.closeGame();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
