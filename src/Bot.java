import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.Scanner;

public class Bot {
    private String nome = "JBot";
    private String senha = "221129DS$";
    private String descricao = "Bot criado para auxiliar os usuarios"+
                                " para pesquisar informações do ecommerce";

    private String enderecoExcel = "H:/FPOO/saida.xls";

    LerEscreverExcel teste = new LerEscreverExcel(enderecoExcel);

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void botOpcoes() {
        System.out.println("1 - Ver todos os usuarios cadastrados");
        System.out.println("2 - Ver todos os telefones cadastrados");
        System.out.println("3 - Ver todos os emails cadastrados");
        System.out.println("4 - Ver todas as datas de cadastro");
        System.out.println("5 - Ver todos os dados de um usuario cadastrado");
        System.out.println("Digite a opcao desejada:");
    }

    public void executarBot(int opcao) throws BiffException, IOException {

        Scanner sc = new Scanner(System.in);

        teste.lerExcel();

        switch (opcao) {
            case 1:
                System.out.println("Todos os usuarios cadastrados");
                for (int x = 0; x <= teste.getAs2().length - 1; x++) {
                    System.out.println(teste.getAs2()[x]);
                }
                break;
            case 2:
                System.out.println("Todos os telefones cadastrados");
                for (int x = 0; x <= teste.getAs3().length - 1; x++) {
                    System.out.println(teste.getAs3()[x]);
                }
                break;
            case 3:
                System.out.println("Todos os emails cadastrados");
                for (int x = 0; x <= teste.getAs4().length - 1; x++) {
                    System.out.println(teste.getAs4()[x]);
                }
                break;
            case 4:
                System.out.println("Todas as datas de cadastro");
                for (int x = 0; x <= teste.getAs5().length - 1; x++) {
                    System.out.println(teste.getAs5()[x]);
                }
                break;
            case 5:
                boolean flag = false;
                System.out.println("Digite o código do usuario:");
                String codigo = sc.next();
                System.out.println(teste.getAs1().length);
                for (int x = 0; x <= teste.getAs1().length - 1; x++) {
                    if(teste.getAs1()[x].equals(codigo)){
                        System.out.println("Todos os dados de um usuario cadastrado");
                        System.out.println("Código: "+teste.getAs1()[x]);
                        System.out.println("Nome: "+teste.getAs2()[x]);
                        System.out.println("Telefone: "+teste.getAs3()[x]);
                        System.out.println("Email: "+teste.getAs4()[x]);
                        System.out.println("Data de Cadastro: "+teste.getAs5()[x]);
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("Usuario não encontrado!");
                }
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }

        System.out.println("Desejar escolher outra opcao?S ou N");

    }
}
