module eu.flancrest.stars_calc {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.apache.logging.log4j;
        requires org.apache.logging.log4j.core;

        opens eu.flancrest.stars_calc to javafx.fxml, org.apache.logging.log4j.core;

        exports eu.flancrest.stars_calc;
}
