package ru.timlad.db;

import java.time.LocalTime;

public class ListMovie {


    private String movieName;
    private String weekday;
    private LocalTime timeStart;
    private int movieDuration;
    private LocalTime timeStartPrevMovie;
    private int durationBreak;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public LocalTime getTimeStartPrevMovie() {
        return timeStartPrevMovie;
    }

    public void setTimeStartPrevMovie(LocalTime timeStartPrevMovie) {
        this.timeStartPrevMovie = timeStartPrevMovie;
    }

    public int getDurationBreak() {
        return durationBreak;
    }

    public void setDurationBreak(int durationBreak) {
        this.durationBreak = durationBreak;
    }

    @Override
    public String toString() {
        return movieName + "                    " + '\'' +
                weekday + "                " + '\'' +
                timeStart + "                " +
                movieDuration + "                    " +
                timeStartPrevMovie + "                               " +
                durationBreak;
    }
}
