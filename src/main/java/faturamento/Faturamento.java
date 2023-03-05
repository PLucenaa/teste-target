package faturamento;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Faturamento {
    public static void main(String[] args) throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("C:\\Users\\Pedro\\Downloads\\dados.json")));
        JSONArray jsonArray = new JSONArray(jsonString);

        int soma = 0;
        int qntDiasFaturamento = 0;
        double menorFaturamento = Double.MIN_VALUE;
        double maiorFaturamento = Double.MAX_VALUE;

        for (int i = 0; i < jsonArray.length(); i++){
            double faturamento = jsonArray.getDouble(i);
            if (faturamento > 0){
                soma+= faturamento;
                qntDiasFaturamento++;
            }
            if (faturamento > maiorFaturamento){
                maiorFaturamento = faturamento;
            }
            if (faturamento < menorFaturamento){
                menorFaturamento =  faturamento;
            }
        }

        double mediaMensal = (double) soma/qntDiasFaturamento;

        int qntDiasAcimaMedia = 0;
        for (int i = 0; i < jsonArray.length(); i++){
            double faturamento = jsonArray.getDouble(i);
            if (faturamento>mediaMensal){
                qntDiasAcimaMedia++;
            }
        }

        System.out.println("Menor Valor de faturamento: " + menorFaturamento);
        System.out.println("Maior Valor de faturamento: " + maiorFaturamento);
        System.out.println("Numeros de dias com faturamento acima da media mensal: " + qntDiasAcimaMedia);
    }
}
