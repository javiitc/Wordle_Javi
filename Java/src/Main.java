import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        try {
            URL url = new URL ("https://random-word-api.herokuapp.com/word?lang=es&length=5");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String respuesta = br.readLine();
            br.close();

            String palabra = respuesta
                    .replace("[", "")
                    .replace("]", "")
                    .replace("\"", "");

            System.out.println(palabra);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
