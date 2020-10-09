package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements Playable{
    public static final int LONG_PLAYING_TIME = 2 * 60 +15;
    //private String title;
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    //private Rating  maturityRating;

    public Movie(String title, be.pxl.ja.opdracht1.Rating rating) {
        super(title, rating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

    public void setDuration(int duration) {
        this.duration = duration;
        if(duration < 0){
           this.duration = duration * -1;
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public boolean isLongPlayingTime(){
        return duration >= LONG_PLAYING_TIME;
    }
    public String getPlayingTime(){
        StringBuilder output = new StringBuilder();
        if(this.duration == 0){
            output.append("?");
        }else{
            int amountHours = this.duration / 60;
            int amountMinutes = this.duration % 60;
            if(amountHours > 0){
                output.append(amountHours + " h");
            }
            if(amountMinutes > 0 && amountHours > 0){
                output.append(" " + amountMinutes + " min");
            }
            if(amountMinutes > 0 && amountHours <= 0){
                output.append(amountMinutes + " min");
            }

        }
        return output.toString();
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        if (releaseDate != null) {
            output.append("  (" + releaseDate.getYear() + ")");
        }
        return output.toString();

    }


}
