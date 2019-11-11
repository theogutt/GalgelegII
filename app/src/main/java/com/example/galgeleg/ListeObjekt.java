package com.example.galgeleg;

public class ListeObjekt {
    private int image;
    private String linje1;
    private String linje2;

    public ListeObjekt(int image, String linje1, String linje2){
        this.image=image;
        this.linje1=linje1;
        this.linje2=linje2;
    }

    public int getImage() {
        return image;
    }

    public String getLinje1() {
        return linje1;
    }

    public String getLinje2() {
        return linje2;
    }
}
