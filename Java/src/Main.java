import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Juego juego = new Juego();

        System.out.println("=======================");
        System.out.println("        WORDLE");
        System.out.println("=======================");
        System.out.println("Dispones de 6 intentos para adivinar la palabra");
        System.out.println("Recuerda: \n" +
                "VERDE: La letra esta en el sitio correcto \n" +
                "AMARILLO: La letra existe pero no esta en el sitio correcto \n" +
                "ROJO: La letra no existe");

        String palabraSecreta = juego.obtenerPalabra();
        int intentoActual = 0;
        int intentosMax = 6;
        String [] intentoPalabra = new  String[intentosMax];
        int [][] coloresLetra = new int[intentosMax][5];
        System.out.println("Palabra generada!");
        boolean ganador = false;

        while (intentoActual < intentosMax && !ganador) {

            String intento =  sc.nextLine().toUpperCase();

            if (!juego.palabraValida(intento)) {
                continue;
            }

            intentoPalabra[intentoActual] = intento;
            int [] resultado = juego.comparacionPalabras (intento,  palabraSecreta);
            coloresLetra[intentoActual] = resultado;

            juego.tablero(intentoPalabra, coloresLetra, intentoActual);

            if (intento.equals(palabraSecreta)) {
                System.out.println("Enhorabuena! Has adivinado la palabra!");
                ganador = true;
            }
            intentoActual++;
            if (intentoActual == intentosMax) {
                System.out.println("Bruh, es adivinar una palabra y ni eso has podido?");
            }
        }

    }
}
