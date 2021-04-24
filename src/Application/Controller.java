package Application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


// The controller class handles what happens when events occur
// You set the Controller class in Scene Builder
public class Controller {

    @FXML // tag FXML with the file
    private Label result;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();


    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            result.setText(""); // set label to blank
            start = false; // set flag to false
        }
        String value = ((Button)event.getSource()).getText(); // take button text and assign to value
        result.setText(result.getText() + value); // set label to be what is in label plus the previous valu

    }

    @FXML
    public void processOperators (ActionEvent event) {

        String value = ((Button)event.getSource()).getText(); // this will be the operator

        if (!value.equals("=")) { // if this value is not equal to symbol we will check if operator is empty
            if (!operator.isEmpty()) { // check if operator isn't empty
                return;
            }
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            long number2 = Long.parseLong(result.getText());
            float output = model.Calculate(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }

    }
}

