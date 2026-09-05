package eu.flancrest.stars_calc;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class UIController {

        private UserViewModel viewModel;

        @FXML
        private Button stars_ok;

        @FXML
        private Button clear_btn;

        @FXML
        private Label numResourcesLabel;

        @FXML
        private TextField numAutoBuildFactories;

        @FXML
        private TextField numAutoBuildMines;

        @FXML
        private TextField numResources;

        @FXML
        private TextField iMiningRate;

        @FXML
        private TextField numPossExtraMines;

        @FXML
        private TextField numPossExtraFactories;

        @FXML
        private TextField numDesiredFactories;

        @FXML
        private TextField numPossMines;

        @FXML
        private TextField numDesiredMines;

        @FXML
        private TextField numPossFactories;

        @FXML
        private Label status;

        @FXML
        private void onCalcButtonClick() {
                viewModel.calc();
        }

        @FXML
        private void onClearButtonClick() {
                viewModel.clear();
        }

        public void initViewModel(UserViewModel viewModel) {
                this.viewModel = viewModel;

                numResources.textProperty().bindBidirectional(viewModel.numResources());
                numAutoBuildFactories.textProperty().bindBidirectional(viewModel.numAutoBuildFactories());
                numAutoBuildMines.textProperty().bindBidirectional(viewModel.numAutoBuildMines());
                iMiningRate.textProperty().bindBidirectional(viewModel.iMiningRate());
                numPossExtraMines.textProperty().bindBidirectional(viewModel.numPossExtraMines());
                numPossExtraFactories.textProperty().bindBidirectional(viewModel.numPossExtraFactories());
                numDesiredFactories.textProperty().bindBidirectional(viewModel.numDesiredFactories());
                numPossMines.textProperty().bindBidirectional(viewModel.numPossMines());
                numDesiredMines.textProperty().bindBidirectional(viewModel.numDesiredMines());
                numPossFactories.textProperty().bindBidirectional(viewModel.numPossFactories());
        }

}
