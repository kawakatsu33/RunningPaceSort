import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunningPaceSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Runner> runners = new ArrayList<>();

        while (true) {
            System.out.print("名前を入力(入力したらEnterしていって): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                name = "名無しさん";
            }

            System.out.print(name + "の走行距離(km): ");
            double distance = scanner.nextDouble();

            System.out.print(name + "の走行時間(分): ");
            double time = scanner.nextDouble();
            scanner.nextLine(); 

            runners.add(new Runner(name, distance, time));

            System.out.print("他にランナーがいますか？(yes/no): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }

        insertionSort(runners);

        System.out.println("\nペース（分/km）でソートされたランナー:");
        for (Runner runner : runners) {
            System.out.println(runner);
        }

        scanner.close(); 
    }

    public static void insertionSort(List<Runner> runners) {
        for (int i = 1; i < runners.size(); i++) {
            Runner key = runners.get(i);
            int j = i - 1;

            while (j >= 0 && runners.get(j).pace > key.pace) {
                runners.set(j + 1, runners.get(j));
                j = j - 1;
            }
            runners.set(j + 1, key);
        }
    }
}

class Runner {
    String name;
    double distance;
    double time;
    double pace;

    public Runner(String name, double distance, double time) {
        this.name = name;
        this.distance = distance;
        this.time = time;
        this.pace = time / distance;
    }

    @Override
    public String toString() {
        return name + " - " + String.format("%.2f", pace) + " 分/km";
    }
}
