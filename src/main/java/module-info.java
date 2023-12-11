module com.example.java.mvc.javamvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.java.mvc.javamvc to javafx.fxml;
    exports com.example.java.mvc.javamvc;
    exports com.example.java.mvc.javamvc.Controllers;
    opens com.example.java.mvc.javamvc.Controllers to javafx.fxml;
}