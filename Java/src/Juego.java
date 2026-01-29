import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLOutput;

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

        final String VERDE = "\u001B[42m\u001B[37m";
        final String AMARILLO = "\u001B[43m\u001B[30m";
        final String ROJO = "\u001B[41m\u001B[37m";
        final String GRIS = "\u001B[42m\u001B[37m";
        final String RESET = "\u001B[0m";

        for (int i = 0; i < 6; i++) {
            if (i <= intento) {
                String palabra = intentoPalabra[i];

                for (int j = 0; j < 5; j++) {
                    String color = "";
                    switch (coloresLetra[i][j]) {
                        case 0:
                            color = VERDE;
                            break;
                        case 1:
                            color = AMARILLO;
                            break;
                        case 2:
                            color =  ROJO;
                            break;
                    }
                    System.out.println(color + palabra.charAt(j) + " " + RESET + " ");
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    System.out.println(GRIS + " _ " + RESET + " ");
                }
            }
            System.out.println();
        }
    }

    public static int [] comparacionPalabras (String intento, String palabraSecreta) {

        int [] resultado = new int[5];
        boolean [] letraUsada = new boolean[5];

        for  (int i = 0; i < 5; i++) {
            if (intento.charAt(i) == palabraSecreta.charAt(i)) {
                resultado[i] = 0;
                letraUsada[i] = true;
            } else if (intento.charAt(i) != palabraSecreta.charAt(i)) {
                resultado[i] = 2;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (resultado[i] == 0) {
                continue;
            }
            for (int j = 0; j < 5; j++) {
                if (!letraUsada[j] && intento.charAt(i) == palabraSecreta.charAt(j)) {
                    resultado[i] = 1;
                    letraUsada[j] = true;
                    break;
                }
            }
        }
        return resultado;
    }

    public static boolean palabraValida (String palabra) {
        if  (palabra.length() != 5) {
            System.out.println("La palabra tine que ser de 5 letras. Intentelo de nuevo");
            return false;
        }
        if (!palabra.matches("[a-zA-Z]")) {
            System.out.println("Solo se permiten letras. Intentelo de nuevo ");
        }
        return true;
    }
}
