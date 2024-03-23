package com.main;

import java.io.IOException;

public class CheckInternetConnectivity {
    Boolean isConnected;

    public CheckInternetConnectivity() {
        isConnected = false;
    }

    public Boolean getIsConnected() throws IOException, InterruptedException {
        Process process = java.lang.Runtime.getRuntime().exec("ping www.google.com");
        int x = process.waitFor();
        isConnected = (x != 0);
        return isConnected;
    }
}