package com.example.packmon.Model;

import java.util.ArrayList;

public class PakmonResponse {
    private int count;
    private String next,previos;
    private ArrayList<Pokmen> results;

    public PakmonResponse(int count, String next, String previos, ArrayList<Pokmen> results) {
        this.count = count;
        this.next = next;
        this.previos = previos;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevios() {
        return previos;
    }

    public void setPrevios(String previos) {
        this.previos = previos;
    }

    public ArrayList<Pokmen> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokmen> results) {
        this.results = results;
    }
}
