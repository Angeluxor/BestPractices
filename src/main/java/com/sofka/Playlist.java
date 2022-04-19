package com.sofka;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }
}
