package pief;

import java.util.List;

public class Tend_central {

    static List<Double> dados = Janela.DadosList;

    static double soma;

    public static double media() {
        double media;
        for (int i = 0; i < dados.size(); i++) {
            soma += dados.get(i);
        }
        media = soma / dados.size();
        return media;
    }

    public static double mediana() {
        double mediana;
        int n = dados.size();
        if (dados.size() % 2 == 0) {
            int m = n / 2;
            // mediana para dados com n sendo par
            mediana = (dados.get(m) + dados.get(m + 1)) / 2;
        } else {
            //mediana para dados com n sendo impar
            mediana = dados.get((n + 1) / 2);
        }
        return mediana;
    }

    public static double moda() {
        int contador = 0;
        int cmoda = 0;
        double aux;
        double moda = 0;
        //ordena vetor
        for (int i = 0; i < dados.size(); i++) {
            for (int j = 0; j < dados.size(); j++) {
                if (dados.get(i) > dados.get(j)) {
                    aux = dados.get(i);
                    dados.set(i, dados.get(j));
                    dados.set(j, aux);
                }
            }
        }
        for (int i = 0; i < dados.size(); i++) {
            //verifica se o elemento atual é igual ao proximo
            
            if (dados.get(i).equals(dados.get(i + 1))) {
                
                contador++;
                if (contador > cmoda) {
                    cmoda = contador;
                    moda =(double) dados.get(i);
                }
            } else {
                contador = 0;
            }
        }
        System.out.println("saiu");
        System.out.println(moda+"fora");
        return moda;
    }
}
