package com.db;



public class Data {
    private String value;
    private long key;
    private long expiry;

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }



    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
