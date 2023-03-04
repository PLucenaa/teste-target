import java.io.File;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class Faturamento {
    public static void main(String[] args) {

        String fileContent = new Scanner(new File("banco.json")).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(fileContent);
        JSONArray jsonArray = jsonObject.getJSONArray("faturamentoDiario");

        int soma = 0;
        int qntDiasFaturamento = 0;
        int menorFaturamento = Double.MIN_VALUE;
        int maiorFaturamento = Double.MAX_VALUE;

        for (int i = 0; i < jsonArray.length(); i++){
            Double faturamento = jsonArray.getDouble(i);
            if (faturamento!= null && faturamento > 0){
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
            Double faturamento = jsonArray.getDouble(i);
            if (faturamento != null && faturamento>mediaMensal){
                qntDiasAcimaMedia++;
            }
        }

        System.out.println("Menor Valor de faturamento: " + menorFaturamento);
        System.out.println("Maior Valor de faturamento: " + maiorFaturamento);
        System.out.println("Numeros de dias com faturamento acima da media mensal: " + qntDiasAcimaMedia);
    }
}
