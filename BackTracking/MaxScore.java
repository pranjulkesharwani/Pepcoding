import java.io.*;
import java.util.*;

public class MaxScore {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }

        int sno = 0 + solution(words, farr, score, idx + 1);

        int sword = 0;
        String word = words[idx];
        boolean flag = true;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (farr[ch - 'a'] == 0) {
                flag = false;
            }
            farr[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        int syes = 0;
        if (flag) {
            syes = sword + solution(words, farr, score, idx + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }
        return Math.max(sno, syes);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nofWords = sc.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.next();
        }
        int nofLetters = sc.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = sc.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));
    }
}
