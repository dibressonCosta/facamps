package quartzo_analytics;

import java.util.ArrayList;
import java.util.List;

public class Tend_central {

    public static double Media(double[] valores, int position) {
        double media;
        double soma = 0;
        for (int i = 0; i < position + 1; i++) {
            soma = soma + valores[i];
        }
        media = soma / (position + 1);
        return media;
    }

    public static double Mediana(double[] valores, int position) {
        double mediana;
        double aux;
        int quantidade = position + 1;
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1; j++) {
                if (valores[j] < valores[j + 1]) {
                    aux = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = aux;
                }
            }
        }
        if (quantidade % 2 == 0) {
            mediana = (valores[quantidade / 2] + valores[(quantidade / 2) - 1]) / 2;
        } else {
            mediana = valores[(quantidade - 1) / 2];
        }
        return mediana;
    }

    public static double DesvioPadrao(double[] valores, int position) {
        int quantidade = position + 1;
        double soma = 0;
        for (int i = 0; i < quantidade; i++) {
            soma = soma + Math.pow(valores[i] - Media(valores, position), 2);
        }
        double desvioPadrao = Math.sqrt(soma / quantidade);
        return desvioPadrao;
    }

    public static double Coeficiente_de_variacao(double[] valores, int position) {
        double CV = DesvioPadrao(valores, position) / Media(valores, position) * 100;
        return CV;
    }

    public static String coeficiente_de_assimetria(double media, double mediana, double moda) {
        String simetria = "Apresenta assimetria";
        if (media == mediana && mediana == moda) {
            simetria = "Os dados são simétricos";
        } else if ((media / mediana >= 0.9 && media / mediana <= 1.1) && (media / moda >= 0.9 && media / moda <= 1.1)) {
            simetria = "Os dados são aproximadamente simétricos";
        }
        if (media > mediana && mediana > moda) {
            simetria = "Assimetria positiva, Média > Mediana > Moda";
        }
        if (media < mediana && mediana < moda) {
            simetria = "Assimetria negativa, Moda > Mediana > Média";
        }
        if (moda > media && media > mediana || mediana > media && media > moda || mediana > moda && moda > media || media > moda && moda > mediana) {
            simetria = "Apresenta assimetria";
        }
        return simetria;
    }

    public static String analiseVar(double var) {
        String analiseVar;

        if (var < 50) {
            analiseVar = "Baixa dispersão dos dados";
        } else {
            analiseVar = "Alta dispersão dos dados";
        }

        return analiseVar;
    }

    public static double[][] freq(double[] valores, int position) {
        int auxFreq = 0;
        int quantidade = position + 1;
        double auxx;
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1; j++) {
                if (valores[j] > valores[j + 1]) {
                    auxx = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = auxx;
                }
            }
        }

        int k = 0, cont = 0;
        double aux[][] = new double[quantidade][2];
        for (int i = 0, j = 0; j < aux.length; i++, j++) {
            while (k < quantidade && valores[k] == valores[k + 1]) {
                cont++;
                k++;
            }
            aux[i][0] = valores[k];
            aux[i][1] = cont + 1;
            j += cont;
            cont = 0;
            k++;
            auxFreq++;
        }

        double freq[][] = new double[auxFreq][2];
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[0].length; j++) {
                freq[i][j] = aux[i][j];
            }
        }

        return freq;
    }

    public static double[][] freqArredondar(double[] valores, int position) {
        int quantidade = position + 1;
        double auxx;
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1; j++) {
                if (valores[j] > valores[j + 1]) {
                    auxx = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = auxx;
                }
            }
        }

        int[] arredondado = new int[quantidade];
        for (int i = 0; i < arredondado.length; i++) {
            arredondado[i] = (int) valores[i];
        }

        int maiorValor = arredondado[quantidade - 1];
        int menorValor = arredondado[0];
        int tamanho = maiorValor - menorValor + 1;

        int k = 0, cont = 0;
        double freq[][] = new double[tamanho][2];
        for (int i = menorValor, j = 0; i <= maiorValor && j < freq.length; i++, j++) {
            while (k < arredondado.length && arredondado[k] == i) {
                cont++;
                k++;
            }
            freq[j][0] = i;
            freq[j][1] = cont;
            cont = 0;
        }

        return freq;
    }
}
