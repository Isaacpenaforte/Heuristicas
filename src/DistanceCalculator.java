public class DistanceCalculator {

    // Calcula a distância de Manhattan entre dois pontos
    public static int manhattanDistance(int[] posicao, int[] objetivo) {
        return Math.abs(posicao[0] - objetivo[0]) + Math.abs(posicao[1] - objetivo[1]);
    }
}
