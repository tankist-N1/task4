import java.util.Arrays;

public class MazeSolver {
    public static String[] labirint(int[][] maze) {
        int n = maze.length;
        int[][] costs = new int[n][n];
        String[][] paths = new String[n][n];

        for (int[] row : costs) Arrays.fill(row, Integer.MAX_VALUE);
        costs[n - 1][n - 1] = maze[n - 1][n - 1];
        paths[n - 1][n - 1] = String.valueOf(maze[n - 1][n - 1]);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (maze[i][j] < 0) continue;
                if (i > 0 && maze[i - 1][j] >= 0) {
                    int newCost = costs[i][j] + maze[i - 1][j];
                    if (newCost < costs[i - 1][j]) {
                        costs[i - 1][j] = newCost;
                        paths[i - 1][j] = paths[i][j] + "-" + maze[i - 1][j];
                    }
                }
                if (j > 0 && maze[i][j - 1] >= 0) {
                    int newCost = costs[i][j] + maze[i][j - 1];
                    if (newCost < costs[i][j - 1]) {
                        costs[i][j - 1] = newCost;
                        paths[i][j - 1] = paths[i][j] + "-" + maze[i][j - 1];
                    }
                }
            }
        }

        if (costs[0][0] == Integer.MAX_VALUE) {
            return new String[]{"Прохода нет"};
        } else {
            return new String[]{paths[0][0], String.valueOf(costs[0][0])};
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(labirint(new int[][]{{1, 3, 1}, {1, -1, 1}, {4, 2, 1}}))); // ["1-1-1-3-1","7"]
        System.out.println(Arrays.toString(labirint(new int[][]{{2, -7, 3}, {-4, -1, 8}, {4, 5, 9}}))); // ["Прохода нет"]
    }
}