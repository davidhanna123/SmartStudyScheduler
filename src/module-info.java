module SmartStudyScheduler {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires org.junit.jupiter.api;
    requires java.sql;
    exports Gui to javafx.graphics, javafx.fxml;
    opens Gui to javafx.fxml;
}