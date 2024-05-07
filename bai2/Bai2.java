package bai2;

import java.util.Random;
import java.util.Scanner;

public class Bai2 {

    static class Horse extends Thread {
        private int number;
        private int distance = 0;
        private int steps = 0;

        public Horse(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (distance < 100) {
                int step = new Random().nextInt(10) + 1;
                steps++;
                distance += step;
                if (distance > 100) {
                    distance = 100;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("| %-15s | %-15s | %-10s |\n", "Con ngựa thứ " + number, "đã về đích", steps + " bước chạy");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng ngựa: ");
        int numOfHorses = scanner.nextInt();

        System.out.println("+-----------------+-----------------+------------+");
        System.out.println("| Con ngựa       | Trạng thái     | Bước chạy |");
        System.out.println("+-----------------+-----------------+------------+");

        Horse[] horses = new Horse[numOfHorses];

        for (int i = 0; i < numOfHorses; i++) {
            horses[i] = new Horse(i + 1);
        }

        for (Horse horse : horses) {
            horse.start();
        }

        for (Horse horse : horses) {
            try {
                horse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("+-----------------+-----------------+------------+");
    }
}

