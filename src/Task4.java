import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        String[] command;
        while(true){
            command = scanner.nextLine().split(" ");
            if(command[0].equals("buy"))
                break;
            String name = command[0];
            double price = Double.parseDouble(command[1]);
            int quantity = Integer.parseInt(command[2]);
            if(!productPrice.containsKey(name)){
                productPrice.put(name, price);
                productQuantity.put(name, quantity);
            }else{
                productPrice.put(name, price);
                productQuantity.put(name, productQuantity.get(name) + quantity);
            }
        }
        productPrice.entrySet().forEach(entry -> {
            double totalCost = entry.getValue() * productQuantity.get(entry.getKey());
            System.out.printf(entry.getKey() + " -> " + "%.2f%n", totalCost);
        });
    }
}
