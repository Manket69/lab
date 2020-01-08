/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author mateusz
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zad1();
        Zad2();
        Zad3();
    }

    private static void Zad1() {
        for (int i = 0; i < 2; i++) {
            MyThread mt = new MyThread();
            mt.start();
            System.out.println(mt.getName());
        }
    }
    
    private static void Zad2() {
        MyClass mc1 = new MyClass();
        MyClass mc2 = new MyClass();
        
        Thread t1 = new Thread(mc1);
        Thread t2 = new Thread(mc2);
        t1.start();
        t2.start();
    }
    
        private static void Zad3() {
        MyClass mc1 = new MyClass("apk1");
        MyClass mc2 = new MyClass("apk2");
        
        Thread t1 = new Thread(mc1);
        Thread t2 = new Thread(mc2);
        t1.start();
        t2.start();
    }

}
