package sample;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class UptadeBloodInfoHospital implements Serializable{
    private String Id ;
    private LocalDate date;
    private int[] available = new int[8];
    private int[] needed = new int[8];

    public UptadeBloodInfoHospital(String id, LocalDate date, int[] available, int[] needed) {
        Id = id;
        this.date = date;
        this.available = available;
        this.needed = needed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int[] getAvailable() {
        return available;
    }

    public void setAvailable(int[] available) {
        this.available = available;
    }

    public int[] getNeeded() {
        return needed;
    }

    public void setNeeded(int[] needed) {
        this.needed = needed;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "UptadeBloodInfoHospital{" +
                "Id='" + Id + '\'' +
                ", date=" + date +
                ", available=" + Arrays.toString(available) +
                ", needed=" + Arrays.toString(needed) +
                '}';
    }
}
