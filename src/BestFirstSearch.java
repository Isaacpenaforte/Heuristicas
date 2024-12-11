import java.util.ArrayList;
import java.util.Random;

public class BestFirstSearch {

    int[][] gridAuxiliar;

    BestFirstSearch(int[][] grid){
        gridAuxiliar = grid;
    }

    // Verifica menor caminho para obj[] e retorna novas posições de x,y
    public int[] verificarCaminhos(int[] user, int[] objetivo, int[][] grid ) {

        // Inicializa peso
        int pesoTopo=0;
        int pesoBaixo=0;
        int pesoEsquerda=0;
        int pesoDireita=0;

        // Inicializa distancia
        int distanciaTopo = 1000;
        int distanciaBaixo = 1000;
        int distanciaEsquerda = 1000;
        int distanciaDireita = 1000;

        // Posição do usuário
        int x = user[0];
        int y = user[1];
        int n = grid.length; // Tamanho do grid

        // Finaliza caso esteja preso em um ambiente fechado
        if(gridAuxiliar[x][y]>10){
            return null;
        }

        // Posição de cada ponto ao redor do usuário
        int[] posicaoTopo = {x-1, y};
        int[] posicaoBaixo = {x+1, y};
        int[] posicaoEsquerda = {x, y-1};
        int[] posicaoDireita = {x, y+1};

        int qntPosOcupadas = 0;

        // Calculo distancia Topo
        if (x > 0) {
            if (grid[x - 1][y] != -1) {
                distanciaTopo = DistanceCalculator.manhattanDistance(posicaoTopo,objetivo);
                System.out.println("Distancia Topo: "+ distanciaTopo);
                pesoTopo = distanciaTopo + gridAuxiliar[posicaoTopo[0]][posicaoTopo[1]];
            }else {
                pesoTopo = 1000;
                qntPosOcupadas++;
            }
        }else{
            pesoTopo = 1000;
            qntPosOcupadas++;
        }

        // Calculo distancia baixo
        if (x < n - 1) {
            if (grid[x + 1][y] != -1) {
                distanciaBaixo = DistanceCalculator.manhattanDistance(posicaoBaixo,objetivo);
                System.out.println("Distancia Baixo: "+ distanciaBaixo);
                pesoBaixo = distanciaBaixo + gridAuxiliar[posicaoBaixo[0]][posicaoBaixo[1]];
            }else {
                pesoBaixo = 1000;
                qntPosOcupadas++;
            }
        }else{
            pesoBaixo = 1000;
            qntPosOcupadas++;
        }

        // Calculo distancia esquerda
        if (y > 0) {
            if (grid[x][y - 1] != -1) {
                distanciaEsquerda = DistanceCalculator.manhattanDistance(posicaoEsquerda,objetivo);
                System.out.println("Distancia Esquerda: "+ distanciaEsquerda);
                pesoEsquerda = distanciaEsquerda + gridAuxiliar[posicaoEsquerda[0]][posicaoEsquerda[1]];
            }else {
                pesoEsquerda = 1000;
                qntPosOcupadas++;
            }
        }else{
            pesoEsquerda = 1000;
            qntPosOcupadas++;
        }

        // Calculo distancia direita
        if (y < n - 1) {
            if (grid[x][y + 1] != -1) {
                distanciaDireita = DistanceCalculator.manhattanDistance(posicaoDireita,objetivo);
                System.out.println("Distancia Direita: "+ distanciaDireita);
                pesoDireita = distanciaDireita + gridAuxiliar[posicaoDireita[0]][posicaoDireita[1]];
            }else {
                pesoDireita = 1000;
                qntPosOcupadas++;
            }
        }else{
            pesoDireita = 1000;
            qntPosOcupadas++;
        }

        int distanciaAtual = DistanceCalculator.manhattanDistance(user,objetivo);

        // Recebe a menor caminho dos pontos disponiveis considerando os passos percorridos
        int menorCaminho = Math.min(Math.min(pesoDireita,pesoEsquerda),Math.min(pesoTopo,pesoBaixo));
        System.out.println(menorCaminho);

        // Cria uma lista que armazena os caminhos possiveis com a mesma distancia
        ArrayList<String> caminhos = new ArrayList<>();
        if (menorCaminho == pesoBaixo) {
            caminhos.add("Baixo");
        }
        if (menorCaminho == pesoTopo) {
            caminhos.add("Topo");
        }
        if (menorCaminho == pesoDireita) {
            caminhos.add("Direita");
        }
        if (menorCaminho == pesoEsquerda) {
            caminhos.add("Esquerda");
        }

        System.out.println("Caminhos possiveis:");
        for(int i = 0; caminhos.size()>i;i++){
            System.out.println(caminhos.get(i));
        }

        // Seleciona uma das opções disponíveis na lista de caminhos de forma aleatória
        Random random = new Random();
        int randomN = random.nextInt(caminhos.size());
        int adicional = 10;
        switch (caminhos.get(randomN)){
            case "Baixo":
                if(qntPosOcupadas==3){
                    gridAuxiliar[posicaoBaixo[0]][posicaoBaixo[1]]=+10;
                }else{
                    gridAuxiliar[posicaoBaixo[0]][posicaoBaixo[1]]++;
                }
                return posicaoBaixo;
            case "Topo":
                if(qntPosOcupadas==3){
                    gridAuxiliar[posicaoTopo[0]][posicaoTopo[1]]=+10;
                }else{
                    gridAuxiliar[posicaoTopo[0]][posicaoTopo[1]]++;
                }
                return posicaoTopo;
            case "Esquerda":
                if(qntPosOcupadas==3){
                    gridAuxiliar[posicaoEsquerda[0]][posicaoEsquerda[1]]=+10;
                }else{
                    gridAuxiliar[posicaoEsquerda[0]][posicaoEsquerda[1]]++;
                }
                return posicaoEsquerda;
            case "Direita":
                if(qntPosOcupadas==3){
                    gridAuxiliar[posicaoDireita[0]][posicaoDireita[1]]=+10;
                }else{
                    gridAuxiliar[posicaoDireita[0]][posicaoDireita[1]]++;
                }
                return posicaoDireita;
        }

        return null;
    }
}
