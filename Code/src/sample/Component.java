package sample;

import javafx.beans.property.SimpleStringProperty;

public class Component {
    private SimpleStringProperty type;

    private SimpleStringProperty num;

    private SimpleStringProperty footprint;

    private SimpleStringProperty location;

    Component(String type, String num, String footprint, String location) {
        this.type = new SimpleStringProperty(type);
        this.num = new SimpleStringProperty(num);
        this.footprint = new SimpleStringProperty(footprint);
        this.location = new SimpleStringProperty(location);
    }

    Component() {}

    public String getType() {
        return this.type.get();
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }

    public String getNum() {
        return this.num.get();
    }

    public void setNum(String num) {
        this.num = new SimpleStringProperty(num);
    }

    public String getFootprint() {
        return this.footprint.get();
    }

    public void setFootprint(String footprint) {
        this.footprint = new SimpleStringProperty(footprint);
    }

    public String getLocation() {
        return this.location.get();
    }

    public void setLocation(String location) {
        this.location = new SimpleStringProperty(location);
    }
}