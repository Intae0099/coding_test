import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String word;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            word = br.readLine();
            if(word.length()<M){
                continue;
            }

            map.put(word, map.getOrDefault(word, 0) + 1);

        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(Integer.compare(map.get(o1), map.get(o2))!=0){
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                else if(o1.length()!=o2.length()){
                    return o2.length() - o1.length();
                }
                else{
                    return o1.compareTo(o2);
                }
            }
        });
//        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for(String k : list){
            sb.append(k + "\n");
        }
        System.out.println(sb);

    }
}