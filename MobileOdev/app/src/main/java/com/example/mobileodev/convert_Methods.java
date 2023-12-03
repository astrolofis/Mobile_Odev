package com.example.mobileodev;

public class convert_Methods {

    public String Convert_Decimal(String deger, String convert){

        int gelen_Deger=Integer.parseInt(deger);
        String donusmus="";

        switch (convert){
            case "Binary": {
                StringBuilder toBinary= new StringBuilder();
                if (gelen_Deger == 0) {
                    return "0";
                }
                else {
                    while (gelen_Deger > 0) {
                        int aracı = gelen_Deger % 2;
                        toBinary.insert(0, aracı);
                        gelen_Deger = gelen_Deger / 2;
                    }
                    donusmus = toBinary.toString()  ;
                    break;
                }
            }

            case "Oktal": {
                StringBuilder toOktal= new StringBuilder();
                if (gelen_Deger == 0) {
                    return "0";
                }
                else {
                    while (gelen_Deger > 0) {
                        int aracı = gelen_Deger % 8;
                        toOktal.insert(0, aracı);
                        gelen_Deger = gelen_Deger / 8;
                    }
                }
                donusmus = String.valueOf(toOktal);
                break;
            }
            case "Hexadecimal" :{
                StringBuilder toHexadecimal= new StringBuilder();
                if (gelen_Deger == 0) {
                    return "0";
                }
                else {
                    while (gelen_Deger > 0) {
                        int aracı = gelen_Deger % 16;
                        char hexChar=(aracı<10)?(char) ('0' + aracı): (char)('A' + aracı - 10);
                        toHexadecimal.insert(0, hexChar);
                        gelen_Deger = gelen_Deger / 16;
                    }
                }
                 donusmus = String.valueOf(toHexadecimal);
                break;
            }

        }

        return donusmus;
    }

    public String Convert_MegaByte(String deger, String convert){
        int gelen = Integer.parseInt(deger);
        String giden="";
        switch (convert){
            case "KB":
                giden = String.valueOf(gelen*1024);
                break;
            case "Byte":
                giden = String.valueOf(gelen* Math.pow(1024,2));
                break;
            case "Bit":
                giden= String.valueOf(gelen* Math.pow(1024,2)*8);
                break;
        }
        return giden + " "+ convert;
    }

    public String Convert_Celcius(String deger, String convert){
        double gelen = Integer.parseInt(deger);
        String giden="";
            switch (convert){
                case "Fahrenayt":
                    giden= String.valueOf((gelen*9)/5+32);
                    break;
                case "Kelvin":
                    giden= String.valueOf(gelen+273.15);
                    break;
            }


        return giden;
    }
}
