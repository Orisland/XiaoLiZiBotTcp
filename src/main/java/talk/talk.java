package talk;

public class talk {
    private String from;
    private int id;
    private String key;
    private String value;
    private String power;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "talk{" +
                "from='" + from + '\'' +
                ", id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
