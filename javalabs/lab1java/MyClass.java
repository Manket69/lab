/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Random;

/**
 *
 * @author mateusz
 */
public class MyClass implements Runnable {

    private String name;
    MyClass() { }
    
    MyClass(String name) {
        this.name = name;
    }
    
    private Random rnd = new Random();

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(rnd.nextInt(2500) + 500);
            }
            catch(InterruptedException e) {
            }
            if (name != null) { Thread.currentThread().setName(this.name); };
            System.out.println(Thread.currentThread().getName());
        }
    }
}
