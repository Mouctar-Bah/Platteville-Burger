package Assignment4;

import java.lang.Object;

public class MyQueue<E>
{
   private E [] elements;
   public int front, rear, count;

   /**
    * this the parameterized constructor for Queue.
    * This method initialize the array elements, front, rear, and count.
    * @param capacity
    */
   public MyQueue(int capacity)
   {
      elements = (E[])new Object[capacity];
      this.front = 0;
      this.rear = 0;
      this.count = 0;
   }


   /**
    * This method adds an object to the array, x- is the object being added.
    * @param x
    */
   public void add(E x){
      elements[rear] = x;
      rear = (rear + 1) % elements.length;
      ++count;
   }

   /**
    * removes an element from the array.
    * @return the element being from the queue.
    */
   public E remove(){
      E x = elements[front];
      front = (front + 1) % elements.length;
      --count;
      return  x ;
   }

   /**
    * This method checks if the queue is empty it.
    * @return boolean true if empty, and false if not.
    */
   public boolean isEmpty(){
      if(count == 0){
         return true;
      }
      else {
         return false;
      }
   }

   /**
    * This method Checks if the queue is full.
    * @return boolean true if full, false if not
    */
   public boolean isFull(){
      if(count == elements.length){
         return true;
      }
      else{
         return false;
      }
   }

   /**
    * This method determines how many people are currently in the list.
    * @return counts
    */
   public int numItems(){
      return count;
   }


}

