    import java.util.Random;

    public class GridGenerator {

        public static int[][] generateGrid(int n, double p, int xf, int yf, int xu, int yu) {

            int[][] grid = new int[n][n];
            Random rand = new Random();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rand.nextDouble() > p) {
                        grid[i][j] = 0; // célula livre
                    } else {
                        grid[i][j] = -1; // obstáculo
                    }
                }
            }

            grid[xf][yf] = 0; // Deixa o objetivo livre
            grid[xu][yu] = 0; // Deixa a posição inicial livre

            printGrid(grid);

            return grid;
        }

        public static void printGrid(int[][] grid) {
            for (int[] row : grid) {
                for (int cell : row) {
                    if(cell==-1){
                        System.out.print("1 ");
                    }else{
                        System.out.print(cell + " ");
                    }

                }
                System.out.println();
            }
        }

        public static void imprimirGridComUsuario(int[][] grid, int[] user) {

            System.out.println("Sua posicao: (" + user[0] + "," + user[1] + ")");

            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == user[0] && j == user[1]) {
                        System.out.print("X "); // Posição do usuário
                    } else if (grid[i][j] == -1) {
                        System.out.print("O "); // Obstáculo
                    } else {
                        System.out.print(". "); // Célula livre
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

    }
