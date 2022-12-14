
package com.mycompany.dia_6;

public class Carta {

    public String valor;
    public String palo;
    
    public Carta () {
    
    }
    public Carta (String completo) { //constructor para inicializar las variables
        this.valor = String.valueOf(completo.charAt(0));
        this.palo = String.valueOf(completo.charAt(1));
    }
    
    public void jugada (Carta [] x) { //metodo para calcular que es el mazo de cartas
        //de acuerdo al retorno de las funciones sabemos que son
        if (Poker(x) == 17) {
            System.out.println("POKER");
        }
        if (Full(x) == 13) {
            System.out.println("FULL");
        }
        if (Trio(x) == 11) {
            System.out.println("TRIO");
        }
        if (ParDoble(x) == 9) {
            System.out.println("PAR DOBLE");
        }
        if (Par(x) == 7) {
            System.out.println("PAR");
        }
        if (EscaleraColor(x) == 5) {
            System.out.println("ESCALERA COLOR");
        }
        else if (Escalera(x) == 5) {
            System.out.println("ESCALERA");
        }
        else if (CartaAlta(x) == 5) {
            System.out.println("Carta Alta ");
        }
    }
    
    public int EscaleraColor (Carta [] x)  { //Para saber si es escalera color, basta con saber que sea escalera y color simultaneamente
        
        int color = 0;
        int esca = 0;
        
        color = Color(x);
        esca = Escalera (x);
        if (esca == x.length && color == x.length) {
            return esca;
        }
        return 0;
    }
    public int Poker (Carta [] x) { // para que sea poker deben ser 4 valores iguales
        int cont_aux=0;
        //contamos la cantidad de apariciones
        for (int i=0; i<x.length;i++) {
            for (int j=0; j<x.length;j++) {
                if (x[i].valor.equals(x[j].valor)) {
                    cont_aux++;
                }
            }
        }
        if (cont_aux == 17) {
            return cont_aux;
        }
        return 0;
    }
    public int Full (Carta [] x) { //para que sea full debe ser trio y doble
        int cont = 0;
        cont = Trio(x);
        if (cont == 13) {
            return cont;
        }
        return 0;
    }
    public int Color (Carta [] x) { //para que sea color deben ser todas del mismo palo
       int d=0, h=0,s=0,c=0;
        for (int i=0; i<x.length;i++) { // Para saber de que tipo o que color son
            if (x[i].palo.equals("D")) {
                d++;
            }
            else if (x[i].palo.equals("H")) {
                h++;
            }
            else if (x[i].palo.equals("S")) {
                s++;
            }
            else if (x[i].palo.equals("C")) {
                c++;
            }
        }
        //se cuentan las apariciones de los tipos para saber si son color y para saber de que tipo de palo son
        if (d == x.length) {
            return d;
        }
        else if (h == x.length) {
            return h;
        }
        else if (s == x.length) {
            return s;
        }
        else if (c == x.length) {
            return c;
        }
        return 0;
    }
    public int Escalera (Carta [] x) { //para la escalera los valores tienen que ser consecutivos a excepcion de un caso especial
        int aux=0,cont=0;
        //cambio las letras por valores numericos consecutivos para poder convertir a int y comparar
        for (int i=0;i<x.length; i++) {
            if (x[i].valor.equals("A")) {
                x[i].valor = "1";
            }
            if (x[i].valor.equals("T")) {
                x[i].valor = "10";
            }
            if (x[i].valor.equals("J")) {
                x[i].valor = "11";
            }
            if (x[i].valor.equals("Q")) {
                x[i].valor = "12";
            }
            if (x[i].valor.equals("K")) {
                x[i].valor = "13";
            }
        }
        aux = Integer.parseInt(x[0].valor); //se guarda el primer elemento ya como int para comenzar a comparar
        for (int i=0; i<x.length; i++) {
                if (Integer.parseInt(x[i].valor) == aux) {
                    aux++;
                    cont++;
                    if (aux == 14) { //caso especial para "A"
                        cont++;
                    }
                }           
        }
        if (cont == 5) {
            return cont;
        }
        return 0;
        
    }
    public int Trio (Carta [] x) { //para que sean trio deben tener 3 valores iguales
        int cont_aux=0;
        
        for (int i=0; i<x.length;i++) {
            for (int j=0; j<x.length;j++) {
                if (x[i].valor.equals(x[j].valor)) {
                    cont_aux++;
                }
            }
        }
        if (cont_aux == 11 || cont_aux == 13) { //hay dos posibilidades pq puede ser trio y full
            return cont_aux;
        }
        return 0;
    }
    public int ParDoble (Carta [] x) { //para que sea par doble deben haber dos pares iguales
        int cont_aux=0;
        
        for (int i=0; i<x.length;i++) {
            for (int j=0; j<x.length;j++) {
                if (x[i].valor.equals(x[j].valor)) {
                    cont_aux++;
                }
            }
        }
        if (cont_aux == 9) {
            return cont_aux;
        }
        return 0;
        
    }
    public int Par (Carta [] x) { //para que sean par debe habere dos valores iguales
        int cont_aux=0;
        
        for (int i=0; i<x.length;i++) {
            for (int j=0; j<x.length;j++) {
                if (x[i].valor.equals(x[j].valor)) {
                    cont_aux++;
                }
            }
        }
        if (cont_aux == 7) {
            return cont_aux;
        }
        return 0;
    }
    public int CartaAlta (Carta [] x) { //para carta alta deben ser todos valores distintos y devolver el mayor de ellos
       int cont_aux=0;
        //se cambian las letras por valores numericos para convertir a int
        for (int i=0;i<x.length; i++) {
            if (x[i].valor.equals("A")) {
                x[i].valor = "1";
            }
            if (x[i].valor.equals("T")) {
                x[i].valor = "10";
            }
            if (x[i].valor.equals("J")) {
                x[i].valor = "11";
            }
            if (x[i].valor.equals("Q")) {
                x[i].valor = "12";
            }
            if (x[i].valor.equals("K")) {
                x[i].valor = "13";
            }
        }
        String aux = x[0].valor;//se guarda el primer elemento
        
        for (int i=0; i<x.length;i++) { // se verifica que sean todos valores diferentes y tambien cual es el mayor de ellos
            for (int j=0; j<x.length;j++) {
                if (x[i].valor.equals(x[j].valor)) {
                    cont_aux++;
                }
                if (Integer.parseInt(x[j].valor) > Integer.parseInt(aux)) {
                    aux = x[j].valor +"";
                }
            }
        }
        //se hace una conversion inversa para devolver las cartas a su valor original
        for (int i=0;i<x.length; i++) {
            if (x[i].valor.equals("1")) {
                x[i].valor = "A";
                aux = x[i].valor;
            }
            if (x[i].valor.equals("10")) {
                x[i].valor = "T";
                aux = x[i].valor;
            }
            if (x[i].valor.equals("11")) {
                x[i].valor = "J";
                aux = x[i].valor;
            }
            if (x[i].valor.equals("12")) {
                x[i].valor = "Q";
                aux = x[i].valor;
            }
            if (x[i].valor.equals("13")) {
                x[i].valor = "K";
                aux = x[i].valor;
            }
        }
        System.out.println("La carta alta es: " + aux);
        if (cont_aux == 5) {
            return cont_aux;
        }
        return 0;       
    }
    
    public static void main(String[] args) { //se crea el array de cartas y se prueba llamando a jugada
        
        Carta x = new Carta ();
        Carta [] poker = new Carta [] {new Carta ("TD"),new Carta ("JD"),new Carta ("QD"),new Carta ("KD"),new Carta ("AD")};

        x.jugada(poker);
    }
}
