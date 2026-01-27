import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Juego {
    public String ObtenerPalabra() {
        try {
            URL url = new URL ("https://random-word-api.herokuapp.com/word?lang=es&length=5");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String respuesta = br.readLine();
            br.close();

            String palabra = respuesta
                    .replace("[", "")
                    .replace("]", "")
                    .replace("\"", "");


        } catch (Exception e) {
            System.out.println("Error al obtener palabra");
        }
        return "";
    }

}
