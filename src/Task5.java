import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            if(command[0].equals("register")){
                registerCar(cars, command[1], command[2]);
            }
            if(command[0].equals("unregister")){
                unregisterCar(cars, command[1]);
            }
        }
        cars.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        });
    }

    public static void registerCar(Map<String, String> cars, String username, String plate){
        if(!cars.containsKey(username)){
            cars.put(username, plate);
            System.out.println(username + " registered " + plate + " successfully");
        }else{
            System.out.println("ERROR: already registered with plate number " +
                    cars.get(username));
        }
    }

    public static void unregisterCar(Map<String, String> cars, String username){
        if(!cars.containsKey(username)){
            System.out.println("ERROR: user " + username + " not found");
        }else{
            cars.remove(username);
            System.out.println(username + " unregistered successfully");
        }
    }
}
