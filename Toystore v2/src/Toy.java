import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

class Toy implements Comparable<Toy> {
    int id;
    String name;
    int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Toy other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class ToyShop {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>();
    private Random random = new Random();

    public void put(int id, String name, int weight) {
        Toy toy = new Toy(id, name, weight);
        toyQueue.add(toy);
    }

    public int get() {
        int randomNumber = random.nextInt(100);

        if (randomNumber < 20) {
            return 1;
        } else if (randomNumber < 40) {
            return 2;
        } else {
            return 3;
        }
    }

    public void processAndGet(int numOfIterations) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < numOfIterations; i++) {
                int toyWeight = get();
                Toy selectedToy = null;

                for (Toy toy : toyQueue) {
                    if (toy.weight == toyWeight) {
                        selectedToy = toy;
                        break;
                    }
                }

                if (selectedToy != null) {
                    writer.write("Got Toy: " + selectedToy.id + " - " + selectedToy.name + "\n");
                } else {
                    writer.write("No Toy Available for Weight: " + toyWeight + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

