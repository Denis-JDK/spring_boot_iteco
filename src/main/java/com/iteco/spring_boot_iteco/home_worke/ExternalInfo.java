package com.iteco.spring_boot_iteco.home_worke;

import org.springframework.stereotype.Component;

@Component
public class ExternalInfo {
    private Integer id;
    private String info;

    public ExternalInfo() {
    }

    public ExternalInfo(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setName(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ExternalInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
