package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class App
{
    private static String savePath = "D:\\Programming\\Java\\Java-Projects\\Multi-Thread_Downloader\\src\\main\\java\\org\\example\\Data\\Atomic Habits Original.pdf";
    public static void main( String[] args )
    {
        startProgram();
    }

    private static void startProgram() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hii, the maximum size file you can download is 100MB\n");
        System.out.print("Please provide the URL of file: ");
        String url = sc.nextLine().trim();
        System.out.println("\nDefault path: "+savePath);
        System.out.println("Do you want to change the path? Y or N");
        System.out.print("-> ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
            System.out.print("Please provide the path: ");
            savePath = sc.nextLine();
        }


        try (HttpClient client = HttpClient.newHttpClient()) {
            startDownload(client, url, savePath);
        } catch (Exception ex) {
            System.out.println("startProgram | Exception: "+ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

    }

    private static void startDownload(HttpClient client, String url, String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of(path)));
        System.out.println("Download complete at: "+path);

        // Test basic connectivity first
//        HttpRequest test = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .method("HEAD", HttpRequest.BodyPublishers.noBody())
//                .build();
//
//        HttpResponse<Void> res = client.send(test, HttpResponse.BodyHandlers.discarding());
//        System.out.println("Status code: " + res.statusCode());
//        System.out.println("Headers: " + res.headers().map());
    }
}
