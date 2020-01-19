package com.zadanie_8;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 4, 4, 4};
        RemoteObject remoteObject = new RemoteObject();
	    System.out.println(remoteObject.getMode(array));
    }
}
