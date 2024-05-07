package bai3;

public class diningPhilosophers {

    private final Object[] chopsticks;
    private final Philosopher[] philosophers;

    public diningPhilosophers(int numPhilosophers) {
        chopsticks = new Object[numPhilosophers];
        philosophers = new Philosopher[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Object();
            int leftChopstick = i;
            int rightChopstick = (i + 1) % numPhilosophers;

            philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
        }
    }

    public void startDining() {
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    private class Philosopher extends Thread {
        private final int leftChopstick;
        private final int rightChopstick;

        public Philosopher(int leftChopstick, int rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        private void act(String message) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " " + message);
            Thread.sleep((long) (Math.random() * 100));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    act("is thinking");
                    synchronized (chopsticks[leftChopstick]) {
                        act("picked up the left chopstick");
                        synchronized (chopsticks[rightChopstick]) {
                            act("picked up the right chopstick and is eating");
                        }
                        act("put down both chopsticks, stopped eating and is thinking");
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        diningPhilosophers diningPhilosophers = new diningPhilosophers(5);
        diningPhilosophers.startDining();
    }
}

