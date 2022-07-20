import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> list = new LinkedHashMap<>();
        while(true){
            String[] command = scanner.nextLine().split(" -> ");
            if(command[0].equals("End"))
                break;
            String companyName = command[0];
            String employeeId = command[1];
            if(!list.containsKey(companyName)){
                list.put(companyName, "\n-- " + employeeId);
                continue;
            }
            if(list.get(companyName).contains(employeeId) && list.containsKey(companyName))
                continue;
            list.put(companyName, list.get(companyName) + "\n-- " + employeeId);
        }
        list.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + entry.getValue());
        });
    }
}
