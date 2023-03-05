package distribuidora;

import java.util.HashMap;
import java.util.Map;

public class Distribuidora {
    public static void main(String[] args) {

        Map<String, Double> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);

        double valorTotalMensal = faturamentoPorEstado.values().stream().mapToDouble(Double::doubleValue).sum();

        Map<String, Double> percentualPorEstado = new HashMap<>();
        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = faturamento / valorTotalMensal * 100;
            percentualPorEstado.put(estado, percentual);
        }

        for (Map.Entry<String, Double> entry : percentualPorEstado.entrySet()) {
            String estado = entry.getKey();
            double percentual = entry.getValue();
            System.out.println("Representação de " + estado + ": " + percentual + "%");
        }
    }
}
