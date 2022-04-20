package com.sofka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sofka.GetSongsData.getSongsList;
import static com.sofka.GetSongsData.menu;

public class Playlist {
    private static final List<Playlist> playlistCollection = new ArrayList<>();
    private static List<Song> songs = new ArrayList<>();
    private static String name;

    public Playlist(List<Song> songs, String name) {
        Playlist.songs = songs;
        Playlist.name = name;
    }

    public Playlist() {
    }

    public static Playlist createNewPlaylist() {

        int choice;
        String name;
        int id;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("""
                        Do you want to create a new playlist?
                        1. Yes
                        2. No
                        """);
                choice = (Integer.parseInt(scanner.nextLine()));
                if (choice == 1) {
                    System.out.println("Please type a name for the new playlist");
                    name = scanner.nextLine();
                    addSong();
                    Playlist newPlaylist = new Playlist(songs, name);
                    playlistCollection.add(newPlaylist);
                    return newPlaylist;
                } else if (choice == 2) {
                    System.out.println("Returning to main menu");
                    menu();
                } else {
                    System.out.println("Invalid answer");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid answer, the value must be a number");
            }

        }

    }

    public static void addSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the Id of the song that you want to add");
        int id = (Integer.parseInt(scanner.nextLine()));
        id = id - 1;
        Song song = getSongsList().get(id);
        songs.add(song);
        System.out.println("""
                Do you want add another song?
                1. Yes
                2. No
                """);
        int choice = (Integer.parseInt(scanner.nextLine()));
        if (choice == 1) {
            addSong();
        } else if (choice == 2) {
            System.out.println("Returning to main menu");
            //menu();
        } else {
            System.out.println("Invalid answer");
        }

    }

    public static List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        Playlist.songs = songs;
    }

    public static List<Playlist> getPlaylistCollection() {
        return playlistCollection;
    }

    @Override
    public String toString() {
        return "Playlist: " + name + "\n" +
                "Songs: " + "\n" + songs + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Playlist.name = name;
    }
}
