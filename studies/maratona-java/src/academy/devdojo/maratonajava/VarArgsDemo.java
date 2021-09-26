package academy.devdojo.maratonajava;

public class VarArgsDemo {

    public void soma(int... numeros) {
        int soma = 0;
        for (int n : numeros) {
            soma += n;
        }
        System.out.println("Soma: " + soma);
    }

}
