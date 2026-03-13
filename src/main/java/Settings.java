package com.example;

public class Settings {
    private boolean soundEnabled = true;

    //Parental control fields
    private boolean parentalLimitEnabled = false;
    private String playStartTime = "00:00";
    private String playEndTime = "23:59";

    //Sound
    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean enabled) {
        this.soundEnabled = enabled;
    }

    // 🔒 Parental Control Getters/Setters
    public boolean isParentalLimitEnabled() {
        return parentalLimitEnabled;
    }

    public void setParentalLimitEnabled(boolean parentalLimitEnabled) {
        this.parentalLimitEnabled = parentalLimitEnabled;
    }

    public String getPlayStartTime() {
        return playStartTime;
    }

    public void setPlayStartTime(String playStartTime) {
        this.playStartTime = playStartTime;
    }

    public String getPlayEndTime() {
        return playEndTime;
    }

    public void setPlayEndTime(String playEndTime) {
        this.playEndTime = playEndTime;
    }
}