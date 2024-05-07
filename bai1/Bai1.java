package bai1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập 1 câu : ");
        String input = scanner.nextLine();
        scanner.close();

        String[] words = input.split(" ");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase(); // Chuyển đổi tất cả các chữ cái thành chữ thường để phân biệt không phân biệt hoa thường
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println("Chữ " + entry.getKey() + " " + entry.getValue() + " lần");
        }
    }
}
