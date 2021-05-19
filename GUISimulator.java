package Assignment4;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUISimulator
{
   public Button btnArrive, btnLeave, btnClockUp, btnStats;
   public TextField txtClock, txtCustServed, txtNumCustWaiting;
   public TextArea txtStats;
   public Simulation guiSim = new Simulation();


   public void buttonArrive(ActionEvent actionEvent) {
      guiSim.arrival();
      txtCustServed.setText(String.valueOf(guiSim.currCustomer()));
      txtNumCustWaiting.setText(String.valueOf(guiSim.currWaiting()));

   }

   public void buttonLeave(ActionEvent actionEvent) {
      guiSim.leave();
      txtNumCustWaiting.setText(String.valueOf(guiSim.currWaiting()));
   }

   public void buttonClockUp(ActionEvent actionEvent) {
      guiSim.clockUpdate(1);
      txtClock.setText(String.valueOf(guiSim.returnTime()));
   }

   public void buttonStatistics(ActionEvent actionEvent) {
      txtNumCustWaiting.setText(String.valueOf(guiSim.currWaiting()));
      txtClock.setText(String.valueOf(guiSim.returnTime()));
      txtStats.setText(guiSim.printStatistics());
   }

}
