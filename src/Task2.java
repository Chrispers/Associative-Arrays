import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> ore = new LinkedHashMap<>();
        String command;
        while(true){
            command = scanner.nextLine();
            if(command.equals("stop"))
                break;
            String key = command;
            command = scanner.nextLine();
            long value = Integer.parseInt(command);
            if(!ore.containsKey(key)){
                ore.put(key, value);
            }else{
                ore.put(key, ore.get(key) + value);
            }
        }
        ore.entrySet().forEach(entry -> System.out.println(entry.getKey() +
                " -> " + entry.getValue()));
    }
}
