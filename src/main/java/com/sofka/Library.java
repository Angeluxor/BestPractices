package com.sofka;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.sofka.Playlist.createNewPlaylist;
import static com.sofka.Playlist.getPlaylistCollection;

/**
 * Representa una librería de música y sus comportamientos
 */

public class Library {

    /**
     * Lista de canciones almacenada en una librería
     */
    private static List<Song> songsList;

    /**
     * Método principal que inicia la librería y ofrece el menú al usuario en consola
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        SongData();
        menu();
        System.out.println("""
                         
                                Your music library:
                         
                """);

    }

    /**
     * Muestra al usuario en consola un menú de opciones que le permite interactuar con la librería y acceder a sus comportamientos
     */

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
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> songsList.forEach(System.out::println);
                    case 2 -> createNewPlaylist();
                    case 3 -> genderFilter();
                    case 4 -> yearFilter();
                    case 5 -> lengthSort();
                    case 6 -> yearSort();
                    case 7 -> {
                        List<Playlist> playlistCollection = getPlaylistCollection();
                        playlistCollection.forEach(System.out::println);
                    }
                    case 8 -> exit = true;
                    default -> System.out.println("Sorry at the moment only the options between 1 and 7 are available");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number");
                scanner.next();
            }

        }
    }

    /**
     * Filtra las canciones de la librería por género según la selección del usuario
     */

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
        try {
            int option2 = scanner.nextInt();
            scanner.nextLine();
            switch (option2) {
                case 1 -> {
                    List<Song> filteredList1 = songsList.stream()
                            .filter(Song -> "Rock".equals(Song.getGender()))
                            .collect(Collectors.toList());
                    System.out.println(filteredList1);
                }
                case 2 -> {
                    List<Song> filteredList2 = songsList.stream()
                            .filter(Song -> "Cantautor".equals(Song.getGender()))
                            .collect(Collectors.toList());
                    System.out.println(filteredList2);
                }
                case 3 -> {
                    List<Song> filteredList3 = songsList.stream()
                            .filter(Song -> "Bolero".equals(Song.getGender()))
                            .collect(Collectors.toList());
                    System.out.println(filteredList3);
                }
                case 4 -> {
                    List<Song> filteredList4 = songsList.stream()
                            .filter(Song -> "Rap".equals(Song.getGender()))
                            .collect(Collectors.toList());
                    System.out.println(filteredList4);
                }
                case 5 -> menu();
                default -> System.out.println("Sorry at the moment only the options between 1 and 5 are available");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must enter a number");
            scanner.next();
        }
    }

    /**
     * Filtra las canciones de la librería por año según el valor introducido por el usuario
     */

    private static void yearFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                The next options are available:
                1. Filter by your desired year\040
                2. Go back to the menu
                                
                """);
        try {
            int option3 = scanner.nextInt();
            scanner.nextLine();
            switch (option3) {
                case 1 -> {
                    System.out.println("Type the year you want to filter");
                    String year = scanner.next();

                    List<Song> yearFilter = songsList.stream()
                            .filter(Song -> Song.getDate().equals(year))
                            .collect(Collectors.toList());
                    System.out.println(yearFilter);
                }
                case 2 -> menu();

                default -> System.out.println("Sorry at the moment only the options between 1 and 2 are available");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must enter a number");
            scanner.next();
        }
    }

    /**
     * Ordena las canciones por su duración de manera ascendente o descendente
     */

    private static void lengthSort() {
        sorter(Comparator.comparing(Song::getLength));

    }

    /**
     * Ordena las canciones por su año de lanzamiento de manera ascendente o descendente
     */

    private static void yearSort() {
        sorter(Comparator.comparing(Song::getDate));

    }

    /**
     * Muestra al usuario las posibilidades de ordenamiento y llama al método apropiado según el caso
     *
     * @param comparing Comparador que establece el tipo de ordenamiento que se va a realizar
     */

    private static void sorter(Comparator<Song> comparing) {
        int option;
        List<Song> orderedSongList;
        orderedSongList = songsList;
        System.out.println("""
                Please select the order that you want:
                1. Ascending
                2. Descending
                """);
        Scanner scanner = new Scanner(System.in);
        try {

            option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    orderedSongList.sort(comparing);
                    System.out.println(orderedSongList);
                }

                case 2 -> {
                    orderedSongList.sort(comparing.reversed());
                    System.out.println(orderedSongList);
                }

                default -> System.out.println("Sorry at the moment only the options between 1 and 2 are available");

            }
        } catch (InputMismatchException e) {
            System.out.println("You must enter a number");
            scanner.next();
        }
    }

    /**
     * Crea las instancias necesarias de la clase Song a partir del mapa obtenido del archivo csv
     *
     * @param dataSongs Mapa de dos objetos de tipo String obtenido a partir de un archivo csv
     * @return Una lista de objetos de tipo Song
     */

    public static List<Song> getSongList(List<Map<String, String>> dataSongs) {
        List<Song> songList = new ArrayList<>();
        for (Map<String, String> song : dataSongs) {
            songList.add(
                    new Song(
                            song.get("Id"),
                            song.get("Title"),
                            song.get("Date"),
                            song.get("Length"),
                            song.get("Gender"),
                            song.get("Cover"),
                            song.get("Summary")));
        }
        return songList;
    }

    /**
     * Llama los métodos necesarios para la lectura del archivo csv, su almacenamiento en un mapa y posterior conversión a lista
     *
     * @throws IOException
     */


    private static void SongData() throws IOException {
        List<Map<String, String>> dataList = CsvUtils.getDataCsv("songs");
        songsList = getSongList(dataList);
    }


    public static List<Song> getSongsList() {
        return songsList;
    }
}
