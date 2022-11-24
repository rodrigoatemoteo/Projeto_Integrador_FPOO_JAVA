import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BiffException, IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o endereço do arquivo Excel:");
        String enderecoExcel = sc.next();
        CriarPlanilha cp = new CriarPlanilha(enderecoExcel);
        cp.gerarPlanilha();
        LerEscreverExcel teste = new LerEscreverExcel(cp.getEnderecoExcel());
        teste.lerExcel();
        teste.escreverExcel();
    }
}