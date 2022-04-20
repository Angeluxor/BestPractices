package com.sofka;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.sofka.Playlist.createNewPlaylist;
import static com.sofka.Playlist.getPlaylistCollection;
import static com.sofka.Song.getSongList;

public class GetSongsData {

    private static List<Song> songsList;

    public static void main(String[] args) throws IOException {
        getSongData();
        menu();
        System.out.println("""
                         
                                Your music library:
                         
                """);

    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int option;
        while (!exit) {
            System.out.println("""
                    Welcome to your song library, please select an option:
                    1. List of all available songs
                    2. Create playlists
                    3. Filter songs by genre
                    4. Filter songs by year
                    5. Sort songs by length
                    6. Sort songs by date
                    7. Show playlists
                    8. Exit
                    """);
            option = scanner.nextInt();
            switch (option) {
                case 1 -> songsList.forEach(System.out::println);
                case 2 -> createNewPlaylist();
                case 3 -> genderFilter();
                case 7 -> {
                    List<Playlist> playlistCollection = getPlaylistCollection();
                    playlistCollection.forEach(System.out::println);
                }
                case 8 -> exit = true;
                default -> System.out.println("Sorry at the moment only the options between 1 and 7 are available");
            }

        }
    }

    private static void genderFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                The following genres can be filtered:
                1. Rock
                2. Cantautor
                3. Bolero
                4. Rap
                5. Back
                """);
        int option2 = scanner.nextInt();
        scanner.nextLine();
        switch (option2) {
            case 1 -> {
                List<Song> filteredList1 = songsList.stream()
                        .filter(Song -> Song.getGender().equals("Rock"))
                        .collect(Collectors.toList());
                System.out.println(filteredList1);
            }
            case 2 -> {
                List<Song> filteredList2 = songsList.stream()
                        .filter(Song -> Song.getGender().equals("Cantautor"))
                        .collect(Collectors.toList());
                System.out.println(filteredList2);
            }
            case 3 -> {
                List<Song> filteredList3 = songsList.stream()
                        .filter(Song -> Song.getGender().equals("Bolero"))
                        .collect(Collectors.toList());
                System.out.println(filteredList3);
            }
            case 4 -> {
                List<Song> filteredList4 = songsList.stream()
                        .filter(Song -> Song.getGender().equals("Rap"))
                        .collect(Collectors.toList());
                System.out.println(filteredList4);
            }
            case 5 -> menu();
            default -> System.out.println("Sorry at the moment only the options between 1 and 5 are available");
        }
    }

    private static void getSongData() throws IOException {
        List<Map<String, String>> dataList = CsvUtils.getDataCsv("songs");
        songsList = getSongList(dataList);
    }

    public static List<Song> getSongsList() {
        return songsList;
    }
}
