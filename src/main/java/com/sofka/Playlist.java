package com.sofka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sofka.Library.getSongsList;
import static com.sofka.Library.menu;

/**
 * Representa una playlist de música y sus comportamientos
 */

public class Playlist {
    /**
     * Almacena los objetos de tipo Playlist creados
     */
    private static final List<Playlist> playlistCollection = new ArrayList<>();
    /**
     * Almacena los objetos de tipo Song que contiene un objeto de tipo Playlist
     */
    private static List<Song> songs = new ArrayList<>();
    /**
     * Almacena el nombre de un objeto de tipo Playlist
     */
    private static String name;

    /**
     * Crea una instancia de la clase Playlist
     *
     * @param songs Lista de objetos de tipo Song que se almacenarán
     * @param name  Nombre de la Playlist
     */

    public Playlist(List<Song> songs, String name) {
        Playlist.songs = songs;
        Playlist.name = name;
    }

    /**
     * Crea una instancia vacía de la clase Playlist
     */

    public Playlist() {

    }

    /**
     * Permite al usuario la creación de un objeto de tipo Playlist a través de la consola
     *
     * @return Objeto de tipo Playlist creado por el usuario
     */

    public static Playlist createNewPlaylist() {

        int choice;
        String name;

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("""
                        Do you want to create a new playlist?
                        1. Yes
                        2. No
                        """);
                choice = Integer.parseInt(scanner.nextLine());
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

    /**
     * Permite al usuario añadir un objeto de tipo Song a una Playlist a través de su ID
     */

    public static void addSong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the Id of the song that you want to add");
        int id = Integer.parseInt(scanner.nextLine());
        id = id - 1;
        Song song = getSongsList().get(id);
        songs.add(song);
        System.out.println("""
                Do you want add another song?
                1. Yes
                2. No
                """);
        int choice = Integer.parseInt(scanner.nextLine());
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
