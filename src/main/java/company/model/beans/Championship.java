package company.model.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Championship {
    private String name;
    private String status;
    private String region;
    private String slots;
    private String start;
    private String min;
    private String max;

    private Date date;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Championship(String name, String status, String region, String slots, long start, String min, String max) {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        this.name = name;
        this.status = status;
        this.region = region;
        this.slots = slots;
        this.start = sdf.format(start);
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", region='" + region + '\'' +
                ", slots='" + slots + '\'' +
                ", start='" + start + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                '}';
    }
}
