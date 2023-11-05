module fr.perrot54u.rugby {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;

    opens fr.perrot54u.rugby to javafx.fxml;
    exports fr.perrot54u.rugby;

    opens fr.perrot54u.rugby.controllers to javafx.fxml;
    exports fr.perrot54u.rugby.controllers;

    opens fr.perrot54u.rugby.pojo to javafx.fxml;
    exports fr.perrot54u.rugby.pojo;

    opens fr.perrot54u.rugby.models to javafx.fxml;
    exports fr.perrot54u.rugby.models;

}