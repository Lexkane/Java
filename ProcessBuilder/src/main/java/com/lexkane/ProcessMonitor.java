package com.lexkane.process;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

public class ProcessMonitor {

    public static void main(String[] args) {
        Stream<ProcessHandle> allp = ProcessHandle.allProcesses();

        allp.forEach(ProcessMonitor::displayProcessInfo);
    }

    public static void displayProcessInfo(ProcessHandle ph) {
        ProcessHandle.Info info = ph.info();
        System.out.println("Process Id:" + ph.pid());
        System.out.println("User " + info.user().orElse(""));
        System.out.println("Command:" + info.command().orElse(""));
        System.out.println("Start Time: " + info.startInstant().orElse(Instant.now()).toString());
        System.out.println("Total CPU Time Acquired: " + info.totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis());
        System.out.println(

        );

    }
}
