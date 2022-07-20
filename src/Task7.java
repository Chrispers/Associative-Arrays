import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if(!students.containsKey(name)){
                students.put(name, grade);
            }else{
                students.put(name, (students.get(name) + grade) / 2);
            }
        }
        students.entrySet().forEach(entry -> {
            if(entry.getValue() >= 4.50) {
                System.out.printf(entry.getKey() + " -> " + "%.2f\n", entry.getValue());
            }
        });
    }
}
