import java.io.*;
import java.util.*;

public class Main {
    static class Lecture {
        int id, s, e;

        Lecture(int id, int s, int e) {
            this.id = id;
            this.s = s;
            this.e = e;
        }
    }

    static class Room {
        int end, id;

        Room(int end, int id) {
            this.end = end;
            this.id = id;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        Lecture[] lectures = new Lecture[N];
        int maxId = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(idx, s, e);
            if (idx > maxId)
                maxId = idx;
        }

        Arrays.sort(lectures, (a, b) -> {
            if (a.s != b.s)
                return a.s - b.s;
            return a.e - b.e;
        });

        PriorityQueue<Room> pq = new PriorityQueue<>((r1, r2) -> {
            if (r1.end != r2.end)
                return r1.end - r2.end;
            return r1.id - r2.id;
        });

        int[] assign = new int[Math.max(maxId, N) + 1];

        int roomCount = 0;
        for (Lecture lec : lectures) {
            if (pq.isEmpty() || pq.peek().end > lec.s) {
                roomCount++;
                assign[lec.id] = roomCount;
                pq.offer(new Room(lec.e, roomCount));
            } else {
                Room r = pq.poll();
                assign[lec.id] = r.id;
                pq.offer(new Room(lec.e, r.id));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(roomCount).append('\n');
        for (int i = 1; i <= N; i++) {
            sb.append(assign[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
