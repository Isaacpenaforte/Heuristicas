import java.util.ArrayList;

public class BestFirstSearch {

    static ArrayList<int[]> celulas = new ArrayList();
    static int passos = 0;
    
    public static int[] verificarCaminhos(int[] user, int[] obj, int[][] grid ) {
        // Verifica menor caminho para obj[] e retorna novas posições de x,y
        int distanciaCima = 1000;
        int distanciaBaixo = 1000;
        int distanciaEsquerda = 1000;
        int distanciaDireita = 1000;

        int x = user[0];
        int y = user[1];
        int n = grid.length; // Tamanho do grid
        //

        celulas.add(new int[]{user[0], user[1],passos});

        // cima
        if (x > 0) {
            if (grid[x - 1][y] != 1) {
                distanciaCima = DistanceCalculator.manhattanDistance(x - 1, y, obj[0], obj[1]);
            }
        }
        // baixo
        if (x < n - 1) {
            if (grid[x + 1][y] != 1) {
                distanciaBaixo = DistanceCalculator.manhattanDistance(x + 1, y, obj[0], obj[1]);
            }
        }
        // esquerda
        if (y > 0) {
            if (grid[x][y - 1] != 1) {
                distanciaEsquerda = DistanceCalculator.manhattanDistance(x, y - 1, obj[0], obj[1]);
            }
        }
        // direita
        if (y < n - 1) {
            if (grid[x][y + 1] != 1) {
                distanciaDireita = DistanceCalculator.manhattanDistance(x, y + 1, obj[0], obj[1]);
            }
        }

        int menorDistancia = Math.min(Math.min(distanciaCima, distanciaBaixo), Math.min(distanciaEsquerda, distanciaDireita));
        int[] posicaoRetorno = user; // Posição padrão é a posição atual

        // Atualizar retorno com base na menor distância
        if (menorDistancia == distanciaBaixo && (distanciaBaixo < distanciaCima)) {
            System.out.println("Moveu para baixo!");
            posicaoRetorno = new int[]{x + 1, y};
        } else if (menorDistancia == distanciaCima && (distanciaCima < distanciaBaixo)) {
            System.out.println("Moveu para cima!");
            posicaoRetorno = new int[]{x - 1, y};
        } else if (menorDistancia == distanciaDireita && (distanciaDireita < distanciaEsquerda)) {
            System.out.println("Moveu para direita!");
            posicaoRetorno = new int[]{x, y + 1};
        } else if (menorDistancia == distanciaEsquerda && (distanciaEsquerda < distanciaDireita)) {
            System.out.println("Moveu para esquerda!");
            posicaoRetorno = new int[]{x, y - 1};
        } else {
            System.out.println("Sem movimentos possíveis!");
        }

        return posicaoRetorno;
    }
}
