import java.util.ArrayList;
import java.util.Random;

public class HillClimbingSearch {

    HillClimbingSearch(){
    }

    // Verifica menor caminho para obj[] e retorna novas posições de x,y
    public int[] verificarCaminhos(int[] user, int[] objetivo, int[][] grid ) {

        // Inicializa distancia
        int distanciaTopo = 1000;
        int distanciaBaixo = 1000;
        int distanciaEsquerda = 1000;
        int distanciaDireita = 1000;

        // Posição do usuário
        int x = user[0];
        int y = user[1];
        int n = grid.length; // Tamanho do grid

        // Posição de cada ponto ao redor do usuário
        int[] posicaoTopo = {x-1, y};
        int[] posicaoBaixo = {x+1, y};
        int[] posicaoEsquerda = {x, y-1};
        int[] posicaoDireita = {x, y+1};

        // Calculo distancia Topo
        if (x > 0) {
            if (grid[x - 1][y] != -1) {
                distanciaTopo = DistanceCalculator.manhattanDistance(posicaoTopo, objetivo);
                System.out.println("Distancia Topo: "+ distanciaTopo);
            }
        }
        // Calculo distancia baixo
        if (x < n - 1) {
            if (grid[x + 1][y] != -1) {
                distanciaBaixo = DistanceCalculator.manhattanDistance(posicaoBaixo, objetivo);
                System.out.println("Distancia Baixo: "+ distanciaBaixo);
            }
        }
        // Calculo distancia esquerda
        if (y > 0) {
            if (grid[x][y - 1] != -1) {
                distanciaEsquerda = DistanceCalculator.manhattanDistance(posicaoEsquerda, objetivo);
                System.out.println("Distancia Esquerda: "+ distanciaEsquerda);
            }
        }
        // Calculo distancia direita
        if (y < n - 1) {
            if (grid[x][y + 1] != -1) {
                distanciaDireita = DistanceCalculator.manhattanDistance(posicaoDireita, objetivo);
                System.out.println("Distancia Direita: "+ distanciaDireita);
            }
        }

        int distanciaAtual = DistanceCalculator.manhattanDistance(user,objetivo);

        // Recebe a menor distancia dos pontos disponiveis
        int menorDistancia = Math.min(Math.min(distanciaTopo, distanciaBaixo), Math.min(distanciaEsquerda, distanciaDireita));

        // Retorna null caso não haja um caminho melhor
        if (distanciaAtual < menorDistancia){ // Retornar se não houver opções melhores
            System.out.println("Sem movimentos possiveis");
            return null;
        }

        // Cria uma lista que armazena os caminhos possiveis com a mesma distancia
        ArrayList<String> caminhos = new ArrayList<>();
        if (menorDistancia == distanciaBaixo) {
            caminhos.add("Baixo");
        }
        if (menorDistancia == distanciaTopo) {
            caminhos.add("Topo");
        }
        if (menorDistancia == distanciaDireita) {
            caminhos.add("Direita");
        }
        if (menorDistancia == distanciaEsquerda) {
            caminhos.add("Esquerda");
        }

        System.out.println("Caminhos possiveis:");
        for(int i = 0; caminhos.size()>i;i++){
            System.out.println(caminhos.get(i));
        }

        // Seleciona uma das opções disponíveis na lista de caminhos de forma aleatória
        Random random = new Random();
        int randomN = random.nextInt(caminhos.size());
        System.out.println("Caminho escolhido: "+ caminhos.get(randomN));

        switch (caminhos.get(randomN)){
            case "Baixo":
                return posicaoBaixo;
            case "Topo":
                return posicaoTopo;
            case "Esquerda":
                return posicaoEsquerda;
            case "Direita":
                return posicaoDireita;
        }

        return null;
    }
}
