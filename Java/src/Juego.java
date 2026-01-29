import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Juego {
    public String obtenerPalabra() {
        try {
            URL url = new URL ("https://random-word-api.herokuapp.com/word?lang=es&length=5");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String respuesta = br.readLine();
            br.close();

            String palabra = respuesta
                    .replace("[", "")
                    .replace("]", "")
                    .replace("\"", "")
                    .toUpperCase();

            return palabra;

        } catch (Exception e) {
            System.out.println("Error al obtener palabra");
            return null;
        }
    }

    public static void tablero (String [] intentoPalabra, int [][] coloresLetra, int intento) {

        final String VERDE = "\u001B[42m";
        final String AMARILLO = "\u001B[43m";
        final String ROJO = "\\u001B[41m";

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                String color = "";

                switch (coloresLetra[i][j]) {
                    case 0:
                        color = VERDE;
                        break;
                    case 1:
                        color = AMARILLO;
                        break:
                    case 2:
                        color =  ROJO;
                        break;
                }
            }
        }
    }
}
