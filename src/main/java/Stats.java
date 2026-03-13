package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Stats {
    // Singleton instance
    private static Stats instance = new Stats();

    private int sessionSeconds;   // current session length in seconds
    private int totalSeconds;     // cumulative playtime (completed sessions) in seconds
    private int sessionsCount;    // number of completed sessions
    private long sessionStartTime; // in milliseconds

    // Scheduler to update sessionSeconds every second.
    private ScheduledExecutorService scheduler;
    // Scheduler to persist stats automatically.
    private ScheduledExecutorService persistScheduler;

    // File name for persisting stats
    private final String statsFile = "stats.properties";

    // Private constructor
    private Stats() {
        loadStats();
        startSession();
        startPersistScheduler();
    }

    public static Stats getInstance() {
        return instance;
    }

    /**
     * Loads persisted stats from the statsFile.
     */
    private void loadStats() {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(statsFile)) {
            props.load(in);
            totalSeconds = Integer.parseInt(props.getProperty("totalSeconds", "0"));
            sessionsCount = Integer.parseInt(props.getProperty("sessionsCount", "0"));
            System.out.println("DEBUG: Loaded stats. TotalSeconds=" + totalSeconds + ", sessionsCount=" + sessionsCount);
        } catch (IOException e) {
            System.out.println("DEBUG: No stats file found, starting with defaults.");
            totalSeconds = 0;
            sessionsCount = 0;
        }
    }

    /**
     * Starts the session timer.
     */
    public void startSession() {
        sessionStartTime = System.currentTimeMillis();
        scheduler = Executors.newSingleThreadScheduledExecutor();
        // Update sessionSeconds every second.
        scheduler.scheduleAtFixedRate(() -> updateSessionSeconds(), 1, 1, TimeUnit.SECONDS);
    }

    private void updateSessionSeconds() {
        long currentTime = System.currentTimeMillis();
        sessionSeconds = (int) ((currentTime - sessionStartTime) / 1000);
    }

    /**
     * Starts a scheduler that persists stats every 3 seconds.
     */
    private void startPersistScheduler() {
        persistScheduler = Executors.newSingleThreadScheduledExecutor();
        persistScheduler.scheduleAtFixedRate(() -> persistStats(), 3, 3, TimeUnit.SECONDS);
    }

    /**
     * Ends the current session and restarts the timer.
     */
    public void endSessionAndRestart() {
        updateSessionSeconds(); // final update
        totalSeconds += sessionSeconds;
        sessionsCount++;
        sessionSeconds = 0;
        sessionStartTime = System.currentTimeMillis();
        persistStats();
    }


    /**
     * Resets all playtime statistics.
     */
    public void resetPlaytime() {
        sessionSeconds = 0;
        totalSeconds = 0;
        sessionsCount = 0;
        sessionStartTime = System.currentTimeMillis();
        persistStats();
    }

    /**
     * Returns cumulative playtime (completed sessions + current session).
     */
    public int getPlaytime() {
        return totalSeconds + sessionSeconds;
    }

    /**
     * Returns average session playtime (based on completed sessions).
     */
    public int getAveragePlaytime() {
        return sessionsCount == 0 ? 0 : totalSeconds / sessionsCount;
    }



    /**
     * Returns only the current session's seconds.
     */
    public int getCurrentSessionSeconds() {
        return sessionSeconds;
    }

    /**
     * Persists the current stats to the statsFile.
     */
    public void persistStats() {
        Properties props = new Properties();
        // Include live session time in the persisted total.
        int currentTotal = totalSeconds + sessionSeconds;
        // If a live session is running (sessionSeconds > 0), count it as a session.
        int currentSessionCount = (sessionSeconds > 0) ? (sessionsCount + 1) : sessionsCount;
        props.setProperty("totalSeconds", String.valueOf(currentTotal));
        props.setProperty("sessionsCount", String.valueOf(currentSessionCount));
        try (FileOutputStream out = new FileOutputStream(statsFile)) {
            props.store(out, "Game Statistics");
            System.out.println("DEBUG: Statistics persisted. TotalSeconds=" + currentTotal + ", sessionsCount=" + currentSessionCount);
        } catch (IOException e) {
            System.err.println("Error persisting stats: " + e.getMessage());
        }
    }


    /**
     * Shuts down the schedulers.
     */
    public void shutdownSchedulers() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdownNow();
        }
        if (persistScheduler != null && !persistScheduler.isShutdown()) {
            persistScheduler.shutdownNow();
        }
    }

    public void revivePet() {
        System.out.println("Reviving pet...");
        // Implement pet revival logic here if needed.
    }

    public void recordSession(int seconds) {
        sessionSeconds = seconds;
        totalSeconds += seconds;
        sessionsCount++;
    }
}