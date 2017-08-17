package com.kornden.ukrdrugs;

/**
 * Created by kornden on 16-Aug-17.
 * TODO: create this objects from excel files.
 * TODO: add examples of recipes (need another class recipe?).
 */


public class Drug {
    private String name;
    private String dozes;
    private String group;
    private String latinName;

    /**
     *
     * @param name must be international nonproprietary name of Drug in native language
     * @param latinName international nonproprietary name of Drug in Latin
     * @param group Types of medicines (For the digestive system, For the cardiovascular system etc)
     * @param dozes Dozes, which can be prescribed(30mg, 100mkg/d, 2.0ml - 3% etc).
     */
    public Drug(String name,String latinName, String group, String dozes){
        this.latinName = latinName;
        this.name = name;
        this.group = group;
        this.dozes = dozes;
    }

    /**
     * temporary constructor?
     * @param name must be international nonproprietary name of Drug in native language
     * @param latinName international nonproprietary name of Drug in Latin
     * @param dozes Dozes, which can be prescribed(30mg, 100mkg/d, 2.0ml - 3% etc).
     */
    public Drug(String name,String latinName, String dozes){
        this.latinName = latinName;
        this.name = name;
        this.group = "";
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
    public String getLatinName(){
        return latinName;
    }
}
