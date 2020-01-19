package com.zadanie_8;

import java.rmi.Remote;

public interface RemoteInterface extends Remote {

    int getMode(int[] array);
}
