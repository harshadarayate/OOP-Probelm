import java.util.*;

public class IntegerListManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");

            String command = parts[0];

            try {
                switch (command) {
                    case "insert":
                        int insertIndex = Integer.parseInt(parts[1]);
                        int insertValue = Integer.parseInt(parts[2]);
                        if (insertIndex >= 0 && insertIndex <= list.size()) {
                            list.add(insertIndex, insertValue);
                        } else {
                            System.out.println("Invalid insert index");
                        }
                        System.out.println(list);
                        break;

                    case "delete":
                        int deleteIndex = Integer.parseInt(parts[1]);
                        if (deleteIndex >= 0 && deleteIndex < list.size()) {
                            list.remove(deleteIndex);
                        } else {
                            System.out.println("Invalid delete index");
                        }
                        System.out.println(list);
                        break;

                    case "update":
                        int updateIndex = Integer.parseInt(parts[1]);
                        int newValue = Integer.parseInt(parts[2]);
                        if (updateIndex >= 0 && updateIndex < list.size()) {
                            list.set(updateIndex, newValue);
                        } else {
                            System.out.println("Invalid update index");
                        }
                        System.out.println(list);
                        break;

                    case "sum":
                        int start = Integer.parseInt(parts[1]);
                        int end = Integer.parseInt(parts[2]);
                        if (start >= 0 && end < list.size() && start <= end) {
                            int sum = 0;
                            for (int i = start; i <= end; i++) {
                                sum += list.get(i);
                            }
                            System.out.println(sum);
                        } else {
                            System.out.println("Invalid range for sum");
                        }
                        break;

                    default:
                        System.out.println("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input format");
            }
        }

        sc.close();
    }
}
