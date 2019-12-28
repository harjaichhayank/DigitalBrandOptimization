package com.digitalbrandoptimization;



import java.io.Serializable;

public class Globals  implements Serializable {
    private static Globals instance;
    private String pName,vLocation,vDate,vOccasion;
    private Globals(){}

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getvLocation() {
        return vLocation;
    }

    public void setvLocation(String vLocation) {
        this.vLocation = vLocation;
    }

    public String getvDate() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
    }

    public String getvOccasion() {
        return vOccasion;
    }

    public void setvOccasion(String vOccasion) {
        this.vOccasion = vOccasion;
    }


    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }


}