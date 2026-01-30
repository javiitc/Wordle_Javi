## WORDLE
# Como funciona el programa
El programa imita el reconocido juego Wordle. Se juega en consola (aún no sé como hacerlo con una interfaz gráfica pa que se vea chido xd), y funciona exactamente cómo Wordle
Se genera una palabra de 5 letras al azar, la cuál se obtiene a través de una API, y una vez generada, es cuestión de poner palabras, hasta un máximo de 5 intentos, hasta que se adivine la palabra.
# Como se marcan las letras
- Verde: La letra está en la posición correcta
- Amarillo: La letra existe en la palabra pero no esta en la posición correcta 
- Rojo: La letra no existe en la palabra
# Datos técnicos
Se usan sobretodo bucles for para rellenar la matriz dónde se albergan los intentos, además de usar bucles for para realizar las comprobaciones y asignar los colores a las letras.
Además, se usan varios métodos para que así el Main quede más limpio, los cuáles se usan para validar que la palabra sea correcta (que no lleve numeros o sea de más, o menos, de 5 letras), para asignar los colores, etc...

PD: Nacho por favor valora este código porque casi pierdo la cabeza haciéndolo (como con el juego RPG) porque al principio no entendía nada xd.