import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        System.out.println("Hello world! Inicio!");
        // Configuração dos vetores
        int n = 10;      // Tamanho dos vetores
        double p = 0.3; // Possibilidade de obstaculo por cela
        // Posição inicial - (x,y)
        int x = 0;
        int y = 0;
        int[] user = {x, y};
        // Objetivo - (x,y)
        int xf = n - 1;
        int yf = n - 1;
        int[] ob = {xf, yf};
        boolean chegou = false;

        int[][] grid = GridGenerator.inicializarGrid(n, p); // (Tamanho dos vetores, chance de obstaculo)

        while (!chegou) {

            System.out.println("Sua posicao: (" + user[0] + "," + user[1] + ")");
            GridGenerator.imprimirGridComUsuario(grid,user);

            //user = HillClimbingSearch.verificarCaminhos(user, ob, grid);
            user = BestFirstSearch.verificarCaminhos(user, ob, grid);

            if (Arrays.equals(user, ob)) {
                chegou = true;
                System.out.println("Objetivo alcançado!");
            } else {
                System.out.println("Deseja continuar? (Digite 2 para parar)");
                String resposta = ler.next();

                if (resposta.equals("2")) {
                    chegou = true;
                }
            }
        }
        System.out.println("Terminou!!");
    }

}
