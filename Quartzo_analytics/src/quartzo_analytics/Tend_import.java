
package quartzo_analytics;

import java.util.ArrayList;
import java.util.List;


public class Tend_import {
    static List<Double> dados = Tela.DadosList;

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
        List <Integer> tmeds = new ArrayList<>();
        int n = dados.size();
        for (int i = 0; i < n; i++) {
            //Integer d = new Integer(((DefaultTableModel)Tela.
        }
        return 1.4;
    }
    
}
