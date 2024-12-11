import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        System.out.println("Hello world! Inicio!");
        // Configuração dos vetores
        int n = 10;      // Tamanho dos vetores
        double p = 0.3; // Possibilidade de obstaculo por cela

        // Posição inicial - (x,y)
        int[] user = {0, 0};

        // Objetivo - (x,y)
        int[] obj = {n - 1, n - 1};

        // Gera a matrix de tamanho NxN
        int[][] grid = GridGenerator.generateGrid(n, p, obj[0], obj[1], user[0], user[1]); // (Tamanho dos vetores, chance de obstaculo)

        System.out.println("Qual busca usar?");
        System.out.println("1- Hill Climbing Search");
        System.out.println("2- Best First Search");
        int escolha = ler.nextInt();

        int quantidadeIteracoes=0;

        if(escolha == 1){
            HillClimbingSearch hillClimbingSearch = new HillClimbingSearch();
            while(true){

                user = hillClimbingSearch.verificarCaminhos(user, obj, grid);

                // Contagem de execuções
                quantidadeIteracoes++;

                // Se verificarCaminhos não obter melhor caminho termina o loop
                if (user == null){
                    System.out.println("Nenhum movimento melhor!\nTerminando!");
                    break;
                }

                GridGenerator.imprimirGridComUsuario(grid,user);

                // Se a posição do usuário for a mesma do objetivo termina o loop
                if (Arrays.equals(user, obj)) {
                    System.out.println("Objetivo alcançado!");
                    break;
                }
            }
        }else if(escolha == 2){
            BestFirstSearch bestFirstSearch = new BestFirstSearch(grid);
            while(true){

                user = bestFirstSearch.verificarCaminhos(user, obj, grid);

                // Contagem de execuções
                quantidadeIteracoes++;

                // Se verificarCaminhos não obter melhor caminho termina o loop
                if (user == null){
                    System.out.println("Nenhum movimento melhor!");
                    break;
                }

                GridGenerator.imprimirGridComUsuario(grid,user);

                // Se a posição do usuário for a mesma do objetivo termina o loop
                if (Arrays.equals(user, obj)) {
                    System.out.println("Objetivo alcançado!");
                    break;
                }
            }
        }

        System.out.println("Número de execuções: "+quantidadeIteracoes);
        System.out.println("Terminou!!");
    }

}
