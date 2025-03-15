package View;

import Model.Cep;

import java.util.Scanner;

public class View {

    private static Scanner sc = new Scanner(System.in);

    public static String solicitaCEP(){
        System.out.println("\nDigite o CEP que deseja pesquisar ou digite 'sair' para encerrar: ");
        String cep = sc.nextLine();
        System.out.println("\n---------------\n");
        cep = cep.replace("-","");

        if(cep.matches("\\d{8}")){
            return cep;

        } else if (cep.equalsIgnoreCase("sair")) {
            return cep;

        } else{
          while(!cep.matches("\\d{8}")){
              System.out.println("Digite um CEP válido: ");
              cep = sc.nextLine();
              cep = cep.replace("-","");
          }
            return cep;
        }
    }

    public static void apresentaEndereco(Cep end){
        System.out.println(end.toString());
    }

    public static void finisher(){
        System.out.println("Programa finalizado com sucesso!");
    }
}
