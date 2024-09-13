module cse213.miniiras {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.miniiras to javafx.fxml;
    exports cse213.miniiras;
    opens cse213.user to javafx.fxml;
    exports cse213.user;
    opens cse213.nonuser to javafx.fxml;
    exports cse213.nonuser;
    opens cse213.utility to javafx.fxml;
    exports cse213.utility;

    opens cse213.mymath to javafx.fxml;
    exports cse213.mymath;
    exports cse213.controller;
    opens cse213.controller to javafx.fxml;
    exports cse213.normalizedtransactionclasses;
    opens cse213.normalizedtransactionclasses to javafx.fxml;

}