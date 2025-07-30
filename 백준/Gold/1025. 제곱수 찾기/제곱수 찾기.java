import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int y, x;
    static int[][] map;
    static long max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        y = Integer.parseInt(size[0]);
        x = Integer.parseInt(size[1]);

		map = new int[y][x];
		for (int i = 0; i < y; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				for (int dy = -y; dy <= y; dy++) {
					for (int dx = -x; dx <=x; dx++) {

						if (dy == 0 && dx == 0) continue;

						int a = i;
						int b = j;
						
						StringBuilder sb = new StringBuilder();
						while (a >= 0 && b >= 0 && a < y && b < x) {

							sb.append(map[a][b]);
							long num = Long.parseLong(sb.toString());
							long root = (long) Math.sqrt(num);

							if (num == root * root) {
								max = Math.max(max, num);
							}
							
							a += dy;
							b += dx;

						}

					}
				}
			}
		}


        System.out.println(max);
    }

}