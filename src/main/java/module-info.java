module com.djalexspark.pinger.pinger {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.djalexspark.pinger.pinger to javafx.fxml;
    exports com.djalexspark.pinger.pinger;
}