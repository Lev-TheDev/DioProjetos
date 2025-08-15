package com.application;

import com.entities.Iphone;

public class Main {
    public static void main(String[] args) {
        Iphone meuIphone = new Iphone();

        System.out.println("--- Testing Music Player ---");
        meuIphone.selectSong("Stairway to Heaven - Led Zeppelin");
        meuIphone.playMusic();
        meuIphone.stopMusic();
        System.out.println();

        System.out.println("--- Testing the Phone ---");
        meuIphone.makeCall("11-98765-4321");
        meuIphone.receiveCall("11-98765-4321");
        meuIphone.startVoiceMail();
        System.out.println();

        System.out.println("--- Testing Internet Browser ---");
        meuIphone.openBrowser("https://www.dio.me");
        meuIphone.addNewTab();
        meuIphone.refreshPage();
    }
}