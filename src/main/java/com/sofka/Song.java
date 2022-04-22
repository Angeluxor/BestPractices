package com.sofka;

/**
 * Representa una canción y sus comportamientos
 */

public class Song {

    /**
     * Identificación numérica de una canción
     */
    private String id;
    /**
     * Título de una canción
     */
    private String title;
    /**
     * Año de lanzamiento de una canción
     */
    private String date;
    /**
     * Duración de una canción
     */
    private String length;
    /**
     * Género de una canción
     */
    private String gender;
    /**
     * Portada de una canción
     */
    private String cover;
    /**
     * Descripción de una canción
     */
    private String summary;

    /**
     * Crea una instancia de la clase Song
     *
     * @param id      Identificación numérica de una canción
     * @param title   Título de una canción
     * @param date    Año de lanzamiento de una canción
     * @param length  Duración de una canción
     * @param gender  Género de una canción
     * @param cover   Portada de una canción
     * @param summary Descripción de una canción
     */
    public Song(
            String id,
            String title,
            String date,
            String length,
            String gender,
            String cover,
            String summary) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.length = length;
        this.gender = gender;
        this.cover = cover;
        this.summary = summary;
    }

    /**
     * Crea una instancia de la clase Song
     */

    public Song() {
    }

    /**
     *  estos son los getters y los setters de la clase song, estos respectivamente sirven para crear y obtener los valores de los atributos:
     *  tittle
     *  date
     *  length
     *  gender
     *  cover
     *  summary
     *  @version 01.00.00 2022-04-22, La clase corresponde a la versión 1 del sistema,
     * *               la misma ha sufrido 0 refactorings durante la versión
     * *               se realizaron 0 cambios menores
     * *
     * @since 01.00.00 2022-04-22
     * @return retorna los valroes de los atributos anteriores
     */
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
        return "Id = " + id + '\n' +
                "Title = " + title + '\n' +
                "Date = " + date + '\n' +
                "Length = " + length + '\n' +
                "Genre = " + gender + '\n' +
                "Cover = " + cover + '\n' +
                "Summary = " + summary + '\n' +
                "\n";
    }


}
