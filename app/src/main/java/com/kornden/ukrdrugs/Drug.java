package com.kornden.ukrdrugs;

/**
 * Created by kornd on 16-Aug-17.
 */

public class Drug {
    private String name;
    private String dozes;
    private String group;

    public Drug(String name, String group){
        this.name = name;
        this.group = group;
        dozes = "";
    }
    public Drug(String name){
        this.name = name;
        this.group = "";
        this.dozes = "";
    }
    public Drug(String name, String group, String dozes){
        this.name = name;
        this.group = group;
        this.dozes = dozes;
    }

    public String getName(){
        return name;
    }
    public String getDozes(){
        return dozes;
    }
    public String getGroup(){
        return group;
    }
}
