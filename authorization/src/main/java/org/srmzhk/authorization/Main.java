package org.srmzhk.authorization;

import java.util.Scanner;

public class Main {
    public static void main( String[] args )
    {
        try {
            App app = new App();
            app.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
