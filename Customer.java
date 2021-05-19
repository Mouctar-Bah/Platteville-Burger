package Assignment4;

import java.lang.String;

public class Customer
{
    private static int numCustomers = 0;
    private int customerNo;
    private int timeStamp;

    /**
     * Customer constructor. This method increments numCustomers by 1 each time
     * an instance of Customer is created.
     * @param time
     */
    public Customer(int time)
    {
       timeStamp = time;
       numCustomers++;
       customerNo = numCustomers;
    }


    /**
     * This is a getter method for Time Stamp that returns the arrival time
     * @return the time the customer arrived at
     */
    public int getTimeStamp(){
        return this.timeStamp;
    }

    /**
     *
     * @return a string of the customer's data
     */
    @Override
    public String toString() {
        /* Customer # n arrived @time t, where n is the customerNo, and t is the time stamp).*/
        return "Customer#" + customerNo + " arrived @time " + timeStamp;
    }

//    public int getServiceTimeStamp() {
//        return serviceTimeStamp;
//    }
//
//    public void setServiceTimeStamp(int serviceTimeStamp) {
//        this.serviceTimeStamp = serviceTimeStamp;
//    }
}