package eu.flancrest.stars_calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {

        @Override
        public void start(Stage stage) throws Exception {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("stars_calc.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 800, 600);

                UIController controller = loader.getController();
                UserViewModel viewModel = new UserViewModel();
                controller.initViewModel(viewModel);

                Image icon = new Image(getClass().getResourceAsStream("starsicon.png"));
                stage.getIcons().add(icon);

                stage.setTitle("Stars! Calculator");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}
