package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @title: DFS
 * @difficulty: Easy
 * @tags: DFS
 * @Problem ID: 1012
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, M, K;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[][] array = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                array[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            boolean[][] visited = new boolean[N][M];

            int answer = 0;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && array[i][j] == 1) {
                        dfs(array, visited, i, j, dx, dy, N, M);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static void dfs(int[][] array, boolean[][] visited, int i, int j, int[] dx, int[] dy, int N, int M){
        visited[i][j] = true;
        array[i][j] = 0;
        int nx,ny;
        for(int q = 0; q < 4; q++){
            nx = i + dx[q];
            ny = j + dy[q];
            if(nx > -1 && ny > -1 && nx < N && ny < M && !visited[nx][ny] && array[nx][ny] == 1){
                dfs(array, visited, nx, ny, dx, dy, N, M);
            }
        }
    }
}

