package Assignment4;

public class Simulation extends Object
{
   private Customer being_served = null;
   private int clock, finished, nowait, totalwait, waited;
   private static final int MAX_CUSTOMER = 5;
   private MyQueue<Customer> q = new MyQueue<>(MAX_CUSTOMER);
   /**
    * Default Constructor
    */
   public Simulation()
   {
      clock = 0;
      finished = 0;
      nowait = 0;
      totalwait = 0;
      waited = 0;
   }


   /**
    * This method will return the current time
    * @return this.clock
    */
   public int returnTime(){ return this.clock;}

   /**
    * This method will return the Customer Object currently getting served
    * @return being_served
    */
   public Customer currCustomer()
   {
      return being_served;
   }

   /**
    * this will return the current number of waiting customers
    * @return q.numItems()
    */
   public int currWaiting()
   {
      return q.numItems();
   }

   /**
    * This method will calculate total time waited for all previous and current customers
    * @return an int of Total time waited between current customers in line and previous customers wait time
    */
   public int totalWait()
   {
//      if(being_served == null)
//         totalwait = 0;
//      else if(being_served.hasWaited() == true){
//         int tempWait = being_served.getTimeStamp();
//         totalwait = returnTime() - tempWait;
//      }

//      else
//      {
         return totalwait;
//         totalwait += currWaiting();
//         int tempWait = being_served.getTimeStamp();
//         totalwait = returnTime() - tempWait;
//                 being_served.getServiceTimeStamp() - being_served.getTimeStamp();
//                 totalwait + (returnTime() - tempWait);
//      }
//      return totalwait;
   }

   /**
    * This method will check if the Queue can handle another customer, if yes, it will add the customer
    * If Queue is empty and no customer is being served, customer will be set to being_served
    * @return a Boolean of if the Customer was accepted or not
    */
   public boolean arrival()
   {
      if(q.isFull())
      {
         return false;
      }
      else if(q.isEmpty() && (being_served == null))
      {
         being_served = new Customer (clock);
         nowait++;
//         System.out.println(currCustomer().toString());
         return true;
      }
      else
      {
         Customer temp = new Customer(clock);
//         System.out.println(temp.toString());
         q.add(temp);
         return true;
      }
   }

   /**
    * This method will calculate the average time waited for all customers
    * @return totalwait / waited
    */
   public double avgTimeWait()
   {
      if(nowait == 0 && waited == 0)
         return 0;
//      else if(!q.isEmpty() && currWaiting() < 2){
//         return nowait;
//      }
      else
         return totalwait / (double) (finished);
   }

   /**
    * This method will updates
    * @return nowait
    */
   public int numPeopleNotWaited()
   {
      return this.nowait;
   }

   /**
    * This method will return the number of customers that have left
    * @return Finished
    */
   public int numServed()
   {
      return this.finished;
   }

   /**
    * This method will updates the clock, adding the desired amount of time unless the amount is less than 0
    * @param numTime
    */
   public void clockUpdate(int numTime)
   {
         if(numTime > 0)
         {
            this.clock += numTime;
         }
   }

   /**
    *This method increments the finished count, and sets a new customer to being_served if one is waiting
    * @return null if Queue is empty being_served if another customer is to be served
    */
   public Customer leave()
   {

      if(being_served == null)
      {
         return null;
      }

      else if(q.isEmpty())
      {
         return null;
      }
      else
      {
//         being_served.setServiceTimeStamp(returnTime());
         totalWait();
         Customer temp = being_served;
         being_served = q.remove();
         totalwait += returnTime() - being_served.getTimeStamp();
         waited++;
         this.finished++;
         return temp;
      }

   }

   /**
    * This method will print out all statistics tracked during the simulation
    * This is only for the testbed main()
    */
   public String printStatistics()
   {
      return "Simulation statistics:" + "\n" +
              "The average wait time for the customers who finished " +
              "waiting: "+avgTimeWait()+"." + "\n" + "The total wait" +
              " time is "+totalWait()+"." + "\n" + "The number of " +
              "customers finished: "+this.finished+"." + "\n" +
              "The number of customers who did not have to wait: "
              +nowait+".";
   }
   /**
    * This is Testbed main()
    */
   /*
   public static void main(String [] args)
   {
      Simulation x = new Simulation();

      x.leave();

      x.arrival();
      System.out.println(x.currCustomer().toString());
      x.clockUpdate(3);
      x.leave();

      System.out.println(x.returnTime());

      x.arrival();
      x.arrival();
      System.out.println(x.currCustomer().toString());
      x.clockUpdate(3);
      x.clockUpdate(-3);
      x.arrival();
      x.clockUpdate(5);
      x.arrival();
      x.clockUpdate(50);
      x.arrival();
      x.arrival();
      x.arrival();
      x.arrival();
      System.out.println(x.currWaiting());
      x.leave();
      System.out.println(x.currCustomer().toString());
      x.leave();
      x.leave();
      x.leave();
      x.leave();

      x.printStatistics();
   }

    */
}
