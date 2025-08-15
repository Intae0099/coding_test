import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static HashSet<Character> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            processLine(line);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void processLine(String line) {
        String[] words = line.split(" ");
        boolean assigned = false;

        // 1차: 각 단어의 첫 글자로 단축키 지정
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue; // 빈 문자열 처리
            char upper = Character.toUpperCase(words[i].charAt(0));
            if (!set.contains(upper)) {
                set.add(upper);
                words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
                assigned = true;
                break;
            }
        }

        // 2차: 첫 글자로 지정 불가하면, 왼쪽부터 가능한 알파벳 지정
        if (!assigned) {
            outer:
            for (int i = 0; i < words.length; i++) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < words[i].length(); j++) {
                    char ch = words[i].charAt(j);
                    char upper = Character.toUpperCase(ch);
                    if (ch != ' ' && !set.contains(upper)) {
                        set.add(upper);
                        tmp.append("[").append(ch).append("]");
                        tmp.append(words[i].substring(j + 1));
                        words[i] = tmp.toString();
                        assigned = true;
                        break outer;
                    }
                    tmp.append(ch);
                }
            }
        }

        sb.append(String.join(" ", words));
    }
}
