package org.example;

import java.util.Scanner;

public class App
{
    private static String path = "C:\\Users\\Akshi Vasaniya\\Downloads";
    public static void main( String[] args )
    {
        startProgram();
    }

    private static void startProgram() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hii, the maximum size file you can download is 100MB\n");
        System.out.print("Please provide the URL of file: ");
        String url = sc.nextLine();
        System.out.println("\nDefault path: "+path);
        System.out.println("Do you want to change the path? Yes or No");
        System.out.print("-> ");
        if (sc.nextLine().equalsIgnoreCase("Yes")) {
            System.out.print("Please provide the path: ");
            path = sc.nextLine();
        }

//        startDownload(url);
    }
}
