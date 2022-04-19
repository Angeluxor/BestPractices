package com.sofka;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.sofka.Song.getSongList;

public class getSongsData {

    public static void main(String[] args) throws IOException {
        List<Map<String, String>> dataList = CsvUtils.getDataCsv("songs");
        List<Song> songList = getSongList(dataList);
        songList.forEach(System.out::println);

    }

}
