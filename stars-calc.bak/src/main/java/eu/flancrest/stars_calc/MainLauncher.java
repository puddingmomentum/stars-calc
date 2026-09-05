package eu.flancrest.stars_calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLauncher {
        private static final Logger logger = LogManager.getLogger(MainLauncher.class);

        public static void main(String[] args) {
                System.out.println("=== LAUNCHER STARTED ===");
                logger.info("Log4j2 initialized successfully via MainLauncher");

                Main.main(args);
        }
}
