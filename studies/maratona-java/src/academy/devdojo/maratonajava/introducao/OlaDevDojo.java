package academy.devdojo.maratonajava.introducao;

import java.util.Arrays;

public class OlaDevDojo {

    public static void main(String[] args) {

        // Tipos Primitivos (8): Numéricos!
        // boolean | 1 bit
        // char    | 2 bytes
        // byte    | 1 byte  | -128 ... 127
        // short   | 2 bytes
        // int     | 4 bytes
        // long    | 8 bytes
        // float   | 4 bytes | 0.0f
        // double  | 8 bytes | 0.0d

        byte byteExemplo = 127;
        char caractere = '\u0041'; // Unicode

        System.out.println("OlaDevDojo");
        System.out.println("Caractere: "+caractere);
        System.out.println("byteExemplo: "+byteExemplo);

        System.out.println("args = " + Arrays.deepToString(args));

        // Java 10
        var testeString = "testeString";
        System.out.println(testeString);

        int n1 = 10;
        int n2 = 20;
        System.out.println(n1 / (double) n2);

        int resto = 21 % 2;
        System.out.println(resto);


    }

}
