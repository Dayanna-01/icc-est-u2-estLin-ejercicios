package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();

        for (int i=0; i<texto.length(); i++){
            pila.push(texto.charAt(i));
        }

        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */

    public boolean validarSimbolos(String expresion) { //para comparar caracteres se usa comilla simple
    Stack<Character> pila = new Stack<>();

    for (int i = 0; i < expresion.length(); i++) {
        char c = expresion.charAt(i);

        // simbolos de apertura
        if (c == '(' || c == '[' || c == '{') {
            pila.push(c);
        }

        // simbolos de cierre
        else if (c == ')' || c == ']' || c == '}') {
            if (pila.isEmpty()) {
                return false;
            }

            char igual = pila.pop(); //pop es una operación que elimina y devuelve el elemento superior de una pila

            if ((c == ')' && igual != '(') ||
                (c == ']' && igual != '[') ||
                (c == '}' && igual != '{')) {
                return false; 
            }
        }
    }
    return pila.isEmpty();
}


    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */

    public List<Integer> ordenarPila(Stack<Integer> pila) {
    Stack<Integer> aux = new Stack<>();

    while (!pila.isEmpty()) {
        int orden = pila.pop(); //pop es una operación que elimina y devuelve el elemento superior de una pila

        while (!aux.isEmpty() && aux.peek() > orden) { // peek para mostrar el elemento en la cima sin quitar
            pila.push(aux.pop()); // push para insertar un elemento
        }

        aux.push(orden);
    }
    List<Integer> resultado = new ArrayList<>();
    while (!aux.isEmpty()) {
        resultado.add(0, aux.pop()); // insertamos al inicio para mantener orden ascendente
    }

    return resultado;
}


    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */

    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
    List<Integer> pares = new ArrayList<>();
    List<Integer> impares = new ArrayList<>();

    for (int numero : original) {
        if (numero % 2 == 0) {
            pares.add(numero);
        } else {
            impares.add(numero);
        }
    }

    pares.addAll(impares);

    return pares;
}

}
