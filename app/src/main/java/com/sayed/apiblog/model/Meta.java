package com.sayed.apiblog.model;
/*
"current_page":1,
        "from":1,
        "last_page":7,
        "path":"http:\/\/apiblog\/api\/articles",
        "per_page":5,
        "to":5,
        "total":32
 */

public class Meta {
    private String current_page;
    private String from;
    private String last_page;
    private String path;
    private String per_page;
    private String to;
    private String total;

    public Meta(String current_page, String from, String last_page, String path, String per_page, String to, String total) {
        this.current_page = current_page;
        this.from = from;
        this.last_page = last_page;
        this.path = path;
        this.per_page = per_page;
        this.to = to;
        this.total = total;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public String getFrom() {
        return from;
    }

    public String getLast_page() {
        return last_page;
    }

    public String getPath() {
        return path;
    }

    public String getPer_page() {
        return per_page;
    }

    public String getTo() {
        return to;
    }

    public String getTotal() {
        return total;
    }

    public void setCurrrent_page(String current_page) {
        this.current_page = current_page;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setLast_page(String last_page) {
        this.last_page = last_page;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "currrent_page='" + current_page + '\'' +
                ", from='" + from + '\'' +
                ", last_page='" + last_page + '\'' +
                ", path='" + path + '\'' +
                ", per_page='" + per_page + '\'' +
                ", to='" + to + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
