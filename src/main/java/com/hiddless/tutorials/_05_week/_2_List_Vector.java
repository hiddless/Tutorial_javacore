package com.hiddless.tutorials._05_week;

import java.util.Vector;

public class _2_List_Vector {

    /// Vector
    private static void vectorNoGenericsData() {
        Vector vector = new Vector();
        vector.add("London");
        vector.add(44);
        vector.add("Warshaw");
        vector.add("Eskişehir");
        vector.add("Berlin");
        vector.add("Berlin");

        System.out.println("Eleman Sayısı:"+vector.size());

        for(   Object temp : vector){
            System.out.print(temp+" ");
        }
    }

    // VECTOR (GENERICS)
    private static void vectorGenericsData(){
        Vector<String> vector= new Vector<String> ();
        vector.add("London");;
        vector.add("Warshaw");
        vector.add("Eskişehir");
        vector.add("Berlin");
        vector.add("Berlin");

        System.out.println("Eleman Sayısı:"+vector.size());

        for(   Object temp : vector){
            System.out.print(temp+" ");
        }
    }

    // VECTOR (SPECIAL SPACE AREA)
    private static void vectorSpecialGenericsData(){
        Vector<String> vector= new Vector<String> (4);
        vector.add("London");;
        vector.add("Warshaw");
        vector.add("Eskişehir");
        vector.add("Berlin");
        vector.add("Berlin");

        System.out.println("Eleman Sayısı:"+vector.size());

        for(   Object temp : vector){
            System.out.print(temp+" ");
        }
    }

    public static void main(String[] args) {
        //vectorNoGenericsData();
        //vectorGenericsData();
        vectorSpecialGenericsData();
    }
}
