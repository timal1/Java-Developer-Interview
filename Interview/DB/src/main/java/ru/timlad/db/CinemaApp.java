package ru.timlad.db;

import java.sql.SQLException;

public class CinemaApp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DbHandler dbHandler = new DbHandler();
        dbHandler.conn();
        dbHandler.createDB();
        dbHandler.writeDB();
        dbHandler.showTableSessions();
        dbHandler.showTableTickets();
        dbHandler.showTableMovies();
        dbHandler.showTableSchedule();
        dbHandler.showTableTicketsSold();
        dbHandler.showScheduleErrors();
        dbHandler.showBigBreaks();
        dbHandler.showListMovie();
        dbHandler.showCountVisitorsSumBayTickets();
        dbHandler.closeDB();

    }
}
