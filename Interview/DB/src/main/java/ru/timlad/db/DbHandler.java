package ru.timlad.db;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DbHandler {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:CINEMA.s3db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void createDB() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'movies' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'duration' INT);");
        statmt.execute("CREATE TABLE if not exists 'sessions' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'weekday' text, 'time_start' text, 'price' INT);");
        statmt.execute("CREATE TABLE if not exists 'tickets' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'number' INT);");
        statmt.execute("CREATE TABLE if not exists 'schedule' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'session_id' INT references sessions (id), 'movie_id' INT references movies (id));");
        statmt.execute("CREATE TABLE if not exists 'tickets_sold' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'ticket_id' INT references tickets (id), 'schedule_id' INT references schedule (id));");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы--------
    public static void writeDB() throws SQLException {
        statmt.execute("INSERT INTO 'movies' ('name', 'duration') VALUES " +
                "('ONE', 60), " +
                "('TWO', 90)," +
                "('THREE', 120)," +
                "('FOUR', 90)," +
                "('FIVE', 120); ");

        statmt.execute("INSERT INTO 'sessions' ('weekday', 'time_start', 'price') VALUES " +

                "('MONDAY', '08:00', 50), " +
                "('MONDAY', '10:00', 100), " +
                "('MONDAY', '13:00', 100), " +
                "('MONDAY', '16:00', 150), " +
                "('MONDAY', '19:00', 150), " +
                "('MONDAY', '22:00', 200), " +

                "('TUESDAY', '08:00', 50), " +
                "('TUESDAY', '10:00', 100), " +
                "('TUESDAY', '13:00', 150), " +
                "('TUESDAY', '16:00', 200), " +
                "('TUESDAY', '19:00', 250), " +
                "('TUESDAY', '22:00', 300), " +

                "('WEDNESDAY', '08:00', 50), " +
                "('WEDNESDAY', '10:00', 100), " +
                "('WEDNESDAY', '13:00', 150), " +
                "('WEDNESDAY', '16:00', 200), " +
                "('WEDNESDAY', '19:00', 250), " +
                "('WEDNESDAY', '22:00', 300), " +

                "('THURSDAY', '08:00', 50), " +
                "('THURSDAY', '10:00', 100), " +
                "('THURSDAY', '13:00', 150), " +
                "('THURSDAY', '16:00', 200), " +
                "('THURSDAY', '19:00', 250), " +
                "('THURSDAY', '22:00', 300), " +

                "('FRIDAY', '08:00', 50), " +
                "('FRIDAY', '10:00', 100), " +
                "('FRIDAY', '13:00', 150), " +
                "('FRIDAY', '16:00', 200), " +
                "('FRIDAY', '19:00', 250), " +
                "('FRIDAY', '22:00', 300), " +

                "('SATURDAY', '08:00', 100), " +
                "('SATURDAY', '10:00', 150), " +
                "('SATURDAY', '13:00', 200), " +
                "('SATURDAY', '16:00', 250), " +
                "('SATURDAY', '19:00', 300), " +
                "('SATURDAY', '22:00', 400), " +

                "('SUNDAY', '08:00', 50), " +
                "('SUNDAY', '10:00', 100), " +
                "('SUNDAY', '13:00', 200), " +
                "('SUNDAY', '16:00', 300), " +
                "('SUNDAY', '19:00', 250), " +
                "('SUNDAY', '22:00', 300); ");

        statmt.execute("INSERT INTO 'tickets' ('number') VALUES (100), " +
                "(101), " +
                "(102), " +
                "(103), " +
                "(104), " +
                "(105), " +
                "(106), " +
                "(107), " +
                "(108), " +
                "(109), " +
                "(110); ");

        statmt.execute("INSERT INTO 'schedule' ('session_id', 'movie_id') VALUES " +
                "(1, 3), " +
                "(15, 1), " +
                "(5, 1), " +
                "(10, 1), " +
                "(19, 1), " +
                "(2, 2), " +
                "(5, 2), " +
                "(16, 2), " +
                "(18, 2), " +
                "(25, 2), " +
                "(4, 3), " +
                "(9, 3), " +
                "(24, 3), " +
                "(31, 3), " +
                "(40, 3), " +
                "(17, 3), " +
                "(3, 4), " +
                "(12, 4), " +
                "(22, 4), " +
                "(33, 4), " +
                "(27, 4), " +
                "(41, 4), " +
                "(6, 5), " +
                "(9, 5), " +
                "(25, 5), " +
                "(14, 5), " +
                "(39, 5), " +
                "(23, 5); ");

        statmt.execute("INSERT INTO 'tickets_sold' ('ticket_id', 'schedule_id') VALUES " +
                "(1, 1), " + // 3
                "(2, 2), " + // 1
                "(3, 3), " + // 1
                "(4, 4), " + // 1
                "(5, 6), " + // 2
                "(6, 7), " + // 2
                "(7, 9), " + // 2
                "(8, 11), " + // 3
                "(9, 12), " + // 3
                "(11, 1), " + // 3
                "(12, 2), " + // 1
                "(13, 2), " + // 1
                "(14, 15), " + // 3
                "(15, 9), " + // 2
                "(16, 9), " + // 2
                "(17, 9), " + // 2
                "(18, 9); "); // 2

        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public static void showTableSessions() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM sessions");

        while (resSet.next()) {
            int id = resSet.getInt("id");
            String weekday = resSet.getString("weekday");
            String timeStart = resSet.getString("time_start");
            int price = resSet.getInt("price");
            System.out.println("ID = " + id);
            System.out.println("weekday = " + weekday);
            System.out.println("time_start = " + timeStart);
            System.out.println("price = " + price);
            System.out.println();
        }

        System.out.println("Таблица сеансов выведена");
    }

    public static void showTableTicketsSold() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM tickets_sold");

        while (resSet.next()) {
            int id = resSet.getInt("id");
            int ticketId = resSet.getInt("ticket_id");
            int scheduleId = resSet.getInt("schedule_id");
            System.out.println("ID = " + id);
            System.out.println("ticket_id = " + ticketId);
            System.out.println("schedule_id = " + scheduleId);
            System.out.println();
        }

        System.out.println("Таблица проданных билетов выведена");
    }

    public static void showTableSchedule() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM schedule");

        while (resSet.next()) {
            int id = resSet.getInt("id");
            int sessionId = resSet.getInt("session_id");
            int movieId = resSet.getInt("movie_id");
            System.out.println("ID = " + id);
            System.out.println("session_id = " + sessionId);
            System.out.println("movie_id = " + movieId);
            System.out.println();
        }

        System.out.println("Таблица расписания выведена");
    }

    public static void showTableTickets() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM tickets");

        while (resSet.next()) {
            int id = resSet.getInt("id");
            int number = resSet.getInt("number");
            System.out.println("ID = " + id);
            System.out.println("number = " + number);
            System.out.println();
        }

        System.out.println("Таблица билетов выведена");
    }

    public static void showTableMovies() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM movies");

        while (resSet.next()) {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            int duration = resSet.getInt("duration");
            System.out.println("ID = " + id);
            System.out.println("name = " + name);
            System.out.println("duration = " + duration);
            System.out.println();
        }

        System.out.println("Таблица фильмов выведена");
    }

    public static void showScheduleErrors() throws ClassNotFoundException, SQLException {

        statmt = conn.createStatement();
        int end_time = 0;
        String prevWeekday = "";
        resSet = statmt.executeQuery("SELECT name, duration, time_start, weekday, session_id FROM " +
                "movies mo LEFT JOIN schedule sh on mo.id = sh.movie_id LEFT JOIN sessions s on s.id = sh.session_id ORDER BY session_id");

        System.out.println("Название фильма     " + "Длительность      " + "День недели     " + "Время начала");

        while (resSet.next()) {
            String name = resSet.getString("name");
            int duration = resSet.getInt("duration");
            String weekday = resSet.getString("weekday");

            LocalTime time_start = LocalTime.parse(resSet.getString("time_start"));
            int time = time_start.getHour() * 60 + time_start.getMinute();

            if (time <= end_time && weekday.equals(prevWeekday)) {
                System.out.println("Ошибка в расписании!");
                System.out.println();
            }

            end_time = time + duration;
            prevWeekday = weekday;

            System.out.println(name + "                     " + duration + "             " + weekday + "                   " + time_start);
            System.out.println();
        }
    }

    public static void showBigBreaks() throws ClassNotFoundException, SQLException {

        statmt = conn.createStatement();
        String prevWeekday = "";
        String prevMovieName = "";
        LocalTime timeStartPrev = LocalTime.parse("00:00");
        int prevMovieDuration = 0;
        int durationBreak;
        List<ListMovie> listMovies = new ArrayList<>();


        resSet = statmt.executeQuery("SELECT name, duration, time_start, weekday, session_id FROM " +
                "movies mo LEFT JOIN schedule sh on mo.id = sh.movie_id LEFT JOIN sessions s on s.id = sh.session_id ORDER BY session_id");

        System.out.println("Название фильма         " + "День недели          " + "Время начала        " + "Длительность        " + "Время начала следующего фильма     " + "Время перерыва");

        while (resSet.next()) {
            String movieName = resSet.getString("name");
            int movieDuration = resSet.getInt("duration");
            String weekday = resSet.getString("weekday");

            LocalTime timeStart = LocalTime.parse(resSet.getString("time_start"));

            int timeStartMovie = timeStart.getHour() * 60 + timeStart.getMinute();
            int timeStartPrevMovie = timeStartPrev.getHour() * 60 + timeStartPrev.getMinute();

            durationBreak = timeStartMovie - timeStartPrevMovie - prevMovieDuration;

            if (durationBreak > 30 && weekday.equals(prevWeekday)) {

                ListMovie listMovie = new ListMovie();
                listMovie.setMovieName(prevMovieName);
                listMovie.setWeekday(prevWeekday);
                listMovie.setTimeStart(timeStartPrev);
                listMovie.setMovieDuration(prevMovieDuration);
                listMovie.setTimeStartPrevMovie(timeStart);
                listMovie.setDurationBreak(durationBreak);
                listMovies.add(listMovie);
            }

            prevMovieName = movieName;
            prevMovieDuration = movieDuration;
            timeStartPrev = timeStart;
            prevWeekday = weekday;
        }

        listMovies.stream().sorted(Comparator.comparingInt(ListMovie::getDurationBreak))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void showListMovie() throws ClassNotFoundException, SQLException {

        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT name, count(ts.ticket_id) as count, sum(price) as sum FROM movies mo " +
                "LEFT JOIN schedule sh on mo.id = sh.movie_id " +
                "LEFT JOIN tickets_sold ts on sh.id = ts.schedule_id " +
                "LEFT JOIN sessions s on s.id = sh.session_id and ts.schedule_id = sh.id " +
                "group BY name order by sum desc");

        System.out.println("Название фильма    " + "Общее число посетителей    " + "Общая сумма сборов");

        while (resSet.next()) {
            String name = resSet.getString("name");
            int count = resSet.getInt("count");
            String sum = resSet.getString("sum");

            System.out.println(name + "                        " + count + "                    " + sum);
            System.out.println();
        }
    }

    public static void showCountVisitorsSumBayTickets() throws ClassNotFoundException, SQLException {
        statmt = conn.createStatement();
        int countVisitorsOnePeriod = 0;
        int sumBayTicketsOnePeriod = 0;
        int countVisitorsTwoPeriod = 0;
        int sumBayTicketsTwoPeriod = 0;
        int countVisitorsThreePeriod = 0;
        int sumBayTicketsThreePeriod = 0;

        resSet = statmt.executeQuery("SELECT time_start, count(ts.ticket_id) as count, sum(price) as sum FROM sessions s " +
                "LEFT JOIN schedule sh on s.id = sh.session_id " +
                "LEFT JOIN tickets_sold ts on sh.id = ts.schedule_id " +
                "group BY s.id ;");

        System.out.println("Время сеанса         " + "Число посетителей     " + "Кассовый сбор");

        while (resSet.next()) {
            int count = resSet.getInt("count");
            int sum = resSet.getInt("sum");
            String time_start = resSet.getString("time_start");

            if ((time_start.equals("08:00") || time_start.equals("10:00")) && count != 0) {
                countVisitorsOnePeriod += count;
                sumBayTicketsOnePeriod += sum;
            }

            if ((time_start.equals("13:00") || time_start.equals("16:00")) && count != 0) {
                countVisitorsTwoPeriod += count;
                sumBayTicketsTwoPeriod += sum;
            }

            if ((time_start.equals("19:00") || time_start.equals("22:00")) && count != 0) {
                countVisitorsThreePeriod += count;
                sumBayTicketsThreePeriod += sum;
            }
        }

        System.out.println("c 80:00 до 13:00         " + countVisitorsOnePeriod + "                   " + sumBayTicketsOnePeriod);
        System.out.println();

        System.out.println("c 13:00 до 19:00         " + countVisitorsTwoPeriod + "                   " + sumBayTicketsTwoPeriod);
        System.out.println();

        System.out.println("c 19:00 до 00:00         " + countVisitorsThreePeriod + "                   " + sumBayTicketsThreePeriod);
        System.out.println();
    }

    // --------Закрытие--------
    public static void closeDB() throws ClassNotFoundException, SQLException {
        conn.close();

        System.out.println("Соединения закрыты");
    }
}
