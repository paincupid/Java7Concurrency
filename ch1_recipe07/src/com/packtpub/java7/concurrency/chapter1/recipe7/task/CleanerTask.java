package com.packtpub.java7.concurrency.chapter1.recipe7.task;

import java.util.Date;
import java.util.Deque;

import com.packtpub.java7.concurrency.chapter1.recipe7.event.Event;
  
public class CleanerTask extends Thread {  
  
    private Deque<Event> deque;  
  
    public CleanerTask(Deque<Event> deque) {  
        this.deque = deque;  
        //����Ϊ�ػ�����  
        setDaemon(true);  
    }  
      
    @Override  
    public void run() {  
        while(true) {  
            Date date = new Date();  
            clean(date);  
        }  
    }  
  
    private void clean(Date date) {  
        long difference = 0;  
        boolean delete = false;  
          
        if(deque.size() == 0) {  
            return;  
        }  
          
        do {  
            Event e = deque.getLast();  
            difference = date.getTime() - e.getDate().getTime();  
            if(difference > 10000) {  
                System.out.println("cleaner " + e.getEvent());  
                deque.removeLast();  
                delete = true;  
            }  
        }while(difference > 10000);  
          
        if(delete) {  
            System.out.println("cleaner : the size of the deque " + deque.size());  
        }  
    }  
  
    public Deque<Event> getDeque() {  
        return deque;  
    }  
  
    public void setDeque(Deque<Event> deque) {  
        this.deque = deque;  
    }  
      
      
}  
