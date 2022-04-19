package com.sofka;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


import static com.sofka.Song.getSongList;

public class getSongsData {

    public static void main(String[] args) throws IOException {
        //List<Map<String, String>> dataList = CsvUtils.getDataCsv("songs");
        //List<Song> songList = getSongList(dataList);
        //songList.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int option;
        while (!exit) {
            System.out.println(" Bienvenido a su libreria de canciones, por favor seleecione una opcion");
            System.out.println("1. Lista de todas las canciones disponibles");
            System.out.println("2. Crear listas de reproducción");
            System.out.println("3. Filtrar las canciones por género");
            System.out.println("4. Filtrar las canciones por año");
            System.out.println("5. Ordenar las canciones por duración");
            System.out.println("6. Ordenar las canciones por fecha");
            System.out.println("7. Exit");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        List<Map<String, String>> dataList = CsvUtils.getDataCsv("songs");
                        List<Song> songList = getSongList(dataList);
                        songList.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Se pueden filtrar los siguientes generos");
                        System.out.println("1.- Rock");
                        System.out.println("2.- Cantautor ");
                        System.out.println("3.- Bolero ");
                        System.out.println("4.- Rap ");
                        int option2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (option2) {

                            case 1:
                                List<Map<String, String>> dataListFilter1 = CsvUtils.getDataCsv("songs");
                                List<Song> songListFilter1 = getSongList(dataListFilter1);
                                List<Song> filteredList1 = songListFilter1.stream()
                                        .filter(Song -> Song.getGender().equals("Rock"))
                                        .collect(Collectors.toList());
                                System.out.println(filteredList1);
                                break;

                            case 2:
                                List<Map<String, String>> dataListFilter2 = CsvUtils.getDataCsv("songs");
                                List<Song> songListFilter2 = getSongList(dataListFilter2);
                                List<Song> filteredList2 = songListFilter2.stream()
                                        .filter(Song -> Song.getGender().equals("Cantautor"))
                                        .collect(Collectors.toList());
                                System.out.println(filteredList2);
                                break;

                            case 3:
                                List<Map<String, String>> dataListFilter3 = CsvUtils.getDataCsv("songs");
                                List<Song> songListFilter3 = getSongList(dataListFilter3);
                                List<Song> filteredList3 = songListFilter3.stream()
                                        .filter(Song -> Song.getGender().equals("Bolero"))
                                        .collect(Collectors.toList());
                                System.out.println(filteredList3);
                                break;

                            case 4:
                                List<Map<String, String>> dataListFilter4 = CsvUtils.getDataCsv("songs");
                                List<Song> songListFilter4 = getSongList(dataListFilter4);
                                List<Song> filteredList4 = songListFilter4.stream()
                                        .filter(Song -> Song.getGender().equals("Rap"))
                                        .collect(Collectors.toList());
                                System.out.println(filteredList4);
                                break;

                        }

                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Sorry at the moment only the options between 1 and 5 are available");



                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //List<Song> filteredList = songList.stream()
            //.filter(Song -> Song.getGender().equals("Rock"))
            //.collect(Collectors.toList());
            //System.out.println(filteredList);


        }

    }
}

