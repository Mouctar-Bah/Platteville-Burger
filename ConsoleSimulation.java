package Assignment4;

import java.io.File;
import java.util.Scanner;

public class ConsoleSimulation
{
   private Simulation mySim;
   Scanner stdin;
   java.io.File file;
   Boolean cont = true;

   /**
    * default constructor to initiate mySim
    */
   public ConsoleSimulation()
   {
      mySim = new Simulation();
   }

   /**
    * Run method that excutes console Simulator and returns the
    * output to prog4.java. It reads in input from the user and
    * accesses execteCommand() while checking for error.
    * @throws Exception
    */
   public void run() throws Exception
   {
      File file = new File("src/Prog4_1.in");
      stdin = new Scanner(file);
      while(stdin.hasNext())
      {
         String inpC = stdin.next();
         if(inpC.equals("K")){
            System.out.println("Simulation terminated.");
            break;
         }
         else if(inpC.equals("A") || inpC.equals("L") || inpC.equals("C") ||
                 inpC.equals("S"))
         {
            executeCommand(inpC);
         }
         else{
            System.out.println(inpC + " is NOT a valid command!");
         }

      }
   }

   /**
    * This String method compares the user input from the executable commands
    * and runs the appropriate method.
    * @param inputCommand
    * @return inputCommand
    */
   private String executeCommand(String inputCommand)
   {
      if(inputCommand.equals("A"))
         arrive();
      else if(inputCommand.equals("L"))
         service();
      else if(inputCommand.equals("C"))
         updateTime();
      else if(inputCommand.equals("S"))
         printStats();
//      else
//         System.out.println(inputCommand+" is NOT a valid command!");

      return inputCommand;
   }

   /**
    * void method that print out an error message if there are no new customers.
    * Otherwise, print out a message showing at what time the customer
    * entered the queue, and how full the queue is.
    */
   private void arrive()
   {
      if (mySim.arrival() == false)
      {
         System.out.println("There are no new customers at the moment.");
      }
      else
      {
         System.out.println("A customer has arrived @time " + mySim.returnTime() +
                 ". " + "Number of customers waiting in the line: " + mySim.currWaiting());
      }
   }



   /**
    * This void method print the current statistics of the simulation.
    */
   private void service()
   {
//      customer leaves the restaurant. If there are no customers in the restaurant,
//      print out an error message.
//      Otherwise, print out the customer, the time when it finished,
//      and the number of customers waiting
      Customer templ = mySim.leave();

      if(templ == null)
      {
         System.out.println("Nobody is being served @time " + mySim.returnTime() + ".");
      }
      else
      {
         System.out.println(templ
                 + " and finished @time " + mySim.returnTime() + "." +" Number of customers waiting: "
                 + mySim.currWaiting() + ".");
      }

   }

   /**
    * This void method increase the value of clock by n time units.
    * If n is zero or negative, print an error message.
    */
   private void updateTime()
   {
      try{
         int update = Integer.parseInt(stdin.next());
         if(update < 0 )
         {
            System.out.println("Time NOT updated with " + update + ".");
         }

         else
         {
            int temp2 = update + mySim.returnTime();
            System.out.println("Time updated by " + update + " unit; current time is " + temp2 + ".");
            mySim.clockUpdate(update);
         }
      }
      catch (NumberFormatException exception){
         return;
      }
   }

   /**
    * This void method print the current statistics of the simulation.
    */
   private void printStats()
   {
      System.out.println("Simulation statistics:");
      System.out.println("The average wait time for the customers who finished waiting: "
              + mySim.avgTimeWait() + ".");
      System.out.println("The total wait time is " + mySim.totalWait() + "." );
      System.out.println("The number of customers finished: " + mySim.numServed() + ".");
      System.out.println("The number of customers who did not have to wait: " + mySim.numPeopleNotWaited()
              + ".");
   }
}