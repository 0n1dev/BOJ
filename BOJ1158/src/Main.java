import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제
 * */
public class Main {

    private static Queue<Integer> queue;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int queueSize = Integer.parseInt(tokenizer.nextToken());
            int removeIndex = Integer.parseInt(tokenizer.nextToken());

            if (initializationQueue(queueSize)) {
                System.out.print("<");
                for (int i = 0; i < queueSize - 1; i++) {
                    System.out.print(removeElement(removeIndex) + ", ");
                }

                System.out.print(queue.poll() + ">");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean initializationQueue(int queueSize) {
        queue = new LinkedList<>();

        for (int i = 0; i < queueSize; i++) {
            queue.offer(i + 1);
        }

        if (queue.size() != queueSize) {
            return false;
        }

        return true;
    }

    static int removeElement(int removeIndex) {
        for (int i = 0; i < removeIndex - 1; i++) {
            int tmp = queue.poll();
            queue.offer(tmp);
        }

        return queue.poll();
    }
}
