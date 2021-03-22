package company.model.beans;

public class Championship {
    private String name;
    private String status;
    private String region;
    private String slots;
    private String start;
    private String min;
    private String max;

    public Championship(String name, String status, String region, String slots, String start, String min, String max) {
        this.name = name;
        this.status = status;
        this.region = region;
        this.slots = slots;
        this.start = start;
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
