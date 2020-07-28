package com.javaagenteg;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class DynamicallyLoadingAgent {
    public static void main(String[] args) {
        String javaProcessId = "86995";
        System.out.println("Attaching to target JVM with PID: " + javaProcessId);
        try {
            VirtualMachine jvm = VirtualMachine.attach(javaProcessId);
            jvm.loadAgent(DynamicallyLoadingAgent.class.getClassLoader().getResource("agent.jar").getPath());
            System.out.println("Attached to target JVM and loaded Java agent successfully");
        } catch (AgentLoadException | AgentInitializationException | IOException | AttachNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
