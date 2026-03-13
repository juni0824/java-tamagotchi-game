package com.example;

import java.time.LocalTime;

public class Restrictions {
    private int startTimeLimit; // Restricted start hour (inclusive)
    private int endTimeLimit;   // Restricted end hour (exclusive)
    private boolean gameStatus; // If false, restrictions are off.

    public int getStartTimeLimit() {
        return startTimeLimit;
    }
    public void setStartTimeLimit(int startTimeLimit) {
        this.startTimeLimit = startTimeLimit;
    }

    public int getEndTimeLimit() {
        return endTimeLimit;
    }
    public void setEndTimeLimit(int endTimeLimit) {
        this.endTimeLimit = endTimeLimit;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * With restrictions enabled, play is NOT allowed during the restricted period:
     * from startTimeLimit (inclusive) to endTimeLimit (exclusive).
     * Outside that time window, play is allowed.
     * If restrictions are off, play is allowed.
     */
    public boolean isPlayAllowed() {
        if (!gameStatus) return true;
        int currentHour = LocalTime.now().getHour();
        // Play is allowed if the current hour is before the restricted period or at/after the restricted end.
        return currentHour < startTimeLimit || currentHour >= endTimeLimit;
    }
}
