import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덩치 (https://www.acmicpc.net/problem/7568)
 */
public class Problem_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfPeople = Integer.parseInt(br.readLine());
        int[][] people = new int[numOfPeople][2];
        for(int i=0; i<numOfPeople; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(tokens.nextToken()); // 키
            people[i][1] = Integer.parseInt(tokens.nextToken()); // 몸무게
        }

        StringBuilder output = new StringBuilder();
        for(int i=0; i<numOfPeople; i++) {
            int rank = 1;
            for(int j=0; j<numOfPeople; j++) {
                if(i==j) continue;

                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank++;
                }
            }
            output.append(rank).append(" ");
        }
        System.out.println(output.toString());
    }
}
