module org.cs3380project.application {
    exports org.cs3380project.application;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens org.cs3380project.application;
    opens org.cs3380project.application.backend;
}