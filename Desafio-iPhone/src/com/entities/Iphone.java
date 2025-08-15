package com.entities;

public class Iphone implements Phone, MusicPlayer, InternetBrowser {
    private String model;

    @Override
    public void openBrowser(String url) {
        System.out.println("Opening browser to " + url);
    }

    @Override
    public void addNewTab() {
        System.out.println("Adding new tab");
    }

    @Override
    public void refreshPage() {
        System.out.println("Refreshing page");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }

    @Override
    public void stopMusic() {
        System.out.println("Stopping music");
    }

    @Override
    public String selectSong(String songName) {
        System.out.println("Selecting song: " + songName);
        return songName;
    }

    @Override
    public void makeCall(String phoneNumber) {
        System.out.println("Making call to " + phoneNumber);
    }

    @Override
    public void receiveCall(String phoneNumber) {
        System.out.println("Receiving call from " + phoneNumber);
    }

    @Override
    public void startVoiceMail() {
        System.out.println("Starting voicemail");
    }
}