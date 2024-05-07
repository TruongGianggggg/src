package bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi ký tự: ");
        String s = scanner.nextLine();

        System.out.println("Chuỗi ký tự đầu tiên không lặp liên tiếp là: " + findFirstNonConsecutiveChar(s));

        scanner.close();
    }

    public static String findFirstNonConsecutiveChar(String s) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                list.add(String.valueOf(s.charAt(i)));
                continue;
            }

            if (list.size() > 0 && list.get(list.size() - 1).equals(String.valueOf(s.charAt(i)))) {
                list.remove(list.size() - 1);
                if (list.size() > 0) {
                    break;
                }
            }

            if (s.charAt(i - 1) == s.charAt(i)) {
                continue;
            }

            list.add(String.valueOf(s.charAt(i)));
        }

        StringBuilder result = new StringBuilder();
        for (String ch : list) {
            result.append(ch);
        }
        return result.toString();
    }
}
