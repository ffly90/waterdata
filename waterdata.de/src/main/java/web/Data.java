package web;

import org.springframework.data.annotation.Id;

public class Data {

    @Id
    private String id;
    private String value;

    public String getValue(String value) {
        return value;
    }
    public String setValue(){
        this.value = value;
    }

}