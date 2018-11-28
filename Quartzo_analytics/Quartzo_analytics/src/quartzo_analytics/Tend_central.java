package quartzo_analytics;

import java.util.ArrayList;

public class Tend_central {

     static ArrayList dados = new ArrayList<>();
     static double soma;

    public static double media() {

        for(int i = 0; i < dados.size(); i++) {
            soma = soma + (double) dados.get(i);
        }

        return soma / dados.size();
    }

    public static double mediana() {
        double mediana;
        int n = dados.size();
        if (dados.size() % 2 == 0) {
            int m = n / 2;
            // mediana para dados com n sendo par
            mediana = ((double) dados.get(m) + (double) dados.get(m + 1)) / 2;
        } else {
            //mediana para dados com n sendo impar
            mediana = (double) dados.get((n + 1) / 2);
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
                if ((double) dados.get(i) > (double) dados.get(j)) {
                    aux = (double) dados.get(i);
                    dados.set(i, dados.get(j));
                    dados.set(j, aux);
                }
            }
        }
        for (int i = 0; i <dados.size(); i++) {
            if ((double) dados.get(i) == (double) dados.get(i+1)) {
                contador++;
            }else{
                contador = 0;
            }
            if(contador > cmoda){
                cmoda = contador;
                moda = (double)dados.get(i);
            }
        }
        return moda;
    }
}
