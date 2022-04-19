package com.sofka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Song {

    private String title;
    private String id;
    private String date;
    private String length;
    private String gender;
    private String cover;
    private String summary;

    public Song(
            String title,
            String id,
            String date,
            String length,
            String gender,
            String cover,
            String summary) {
        this.title = title;
        this.id = id;
        this.date = date;
        this.length = length;
        this.gender = gender;
        this.cover = cover;
        this.summary = summary;
    }

    public Song() {
    }

    public static List<Song> getSongList(List<Map<String, String>> dataSongs) {
        List<Song> songList = new ArrayList<>();
        for (Map<String, String> song : dataSongs) {
            songList.add(
                    new Song(
                            song.get("Title"),
                            song.get("Id"),
                            song.get("Date"),
                            song.get("Length"),
                            song.get("Gender"),
                            song.get("Cover"),
                            song.get("Summary")));
        }
        return songList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", length='" + length + '\'' +
                ", gender='" + gender + '\'' +
                ", cover='" + cover + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }



}
