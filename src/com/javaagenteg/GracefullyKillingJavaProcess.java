package com.javaagenteg;

public class GracefullyKillingJavaProcess {
    public static void agentmain(String agentArgs) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Runtime.getRuntime().exit(0);
            }
        }).start();
    }
}
