import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 
        String idNumber;
        while (true) {
            System.out.print("Kimlik Numaranızı Giriniz (11 haneli): ");
            idNumber = scanner.nextLine();

            if (idNumber.matches("\\d{11}")) {
                break;
            } else {
                System.out.println("Geçersiz kimlik numarası! Lütfen 11 haneli rakamlardan oluşan bir numara girin.");
            }
        }

        System.out.print("Adınızı Giriniz: ");
        String firstName = scanner.nextLine();

        System.out.print("Soyadınızı Giriniz: ");
        String lastName = scanner.nextLine();


        String vehicleClass;
        Map<Integer, String> vehicleClasses = new HashMap<>();
        vehicleClasses.put(1, "Otomobil");
        vehicleClasses.put(2, "Kamyon");
        vehicleClasses.put(3, "Otobüs");
        vehicleClasses.put(4, "Minibüs");
        vehicleClasses.put(5, "Motosiklet");

        while (true) {
            System.out.println("Araç Sınıfınızı Seçiniz:");
            vehicleClasses.forEach((key, value) -> System.out.println(key + ". " + value));
            System.out.print("Seçiminiz (1-5): ");
            String choice = scanner.nextLine();

            try {
                int choiceInt = Integer.parseInt(choice);
                if (vehicleClasses.containsKey(choiceInt)) {
                    vehicleClass = vehicleClasses.get(choiceInt);
                    break;
                } else {
                    System.out.println("Geçersiz seçim! Lütfen 1 ile 5 arasında bir sayı girin.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı girin.");
            }
        }


        double balance;
        while (true) {
            try {
                System.out.print("Başlangıç Bakiyenizi Giriniz: ");
                balance = Double.parseDouble(scanner.nextLine());
                if (balance >= 0) {
                    break;
                } else {
                    System.out.println("Bakiye negatif olamaz! Lütfen geçerli bir değer girin.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz bakiye! Lütfen bir sayı girin.");
            }
        }


        Individual account = new Individual(idNumber, lastName, firstName, vehicleClass, balance);
        System.out.println("Hesabınız başarıyla oluşturuldu!");


        Map<Integer, Passage> routes = new LinkedHashMap<>();
        routes.put(1, new Passage("2024-11-17", "Ankara", "İstanbul", calculateFee(vehicleClass, 200.0)));
        routes.put(2, new Passage("2024-11-17", "İstanbul", "Çanakkale", calculateFee(vehicleClass, 150.0)));
        routes.put(3, new Passage("2024-11-17", "Çanakkale", "Ankara", calculateFee(vehicleClass, 180.0)));
        routes.put(4, new Passage("2024-11-17", "Bursa", "Antalya", calculateFee(vehicleClass, 250.0)));
        routes.put(5, new Passage("2024-11-17", "İzmir", "Trabzon", calculateFee(vehicleClass, 300.0)));


        while (true) {
            System.out.println("\nMevcut güzergahlar:");
            for (Map.Entry<Integer, Passage> entry : routes.entrySet()) {
                Passage route = entry.getValue();
                System.out.println(entry.getKey() + ". " + route.entryGate + " - " + route.exitGate + ": " + route.fee + " TL");
            }

            System.out.print("\nBir güzergah seçin (Çıkış için 0 girin): ");
            String routeChoice = scanner.nextLine();

            try {
                int choice = Integer.parseInt(routeChoice);
                if (choice == 0) {
                    break; // Çıkış
                }

                if (routes.containsKey(choice)) {
                    Passage selectedRoute = routes.get(choice);
                    account.addPassage(selectedRoute);
                } else {
                    System.out.println("Geçersiz seçim, lütfen listeden bir güzergah seçin.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş! Lütfen bir sayı girin.");
            }
        }


        account.displayableDeposite();
        account.displayableRoutes();

        scanner.close();
    }

    private static double calculateFee(String vehicleClass, double baseFee) {
        switch (vehicleClass) {
            case "Otomobil":
                return baseFee;
            case "Kamyon":
                return baseFee * 1.5;
            case "Otobüs":
                return baseFee * 2;
            case "Minibüs":
                return baseFee * 1.2;
            case "Motosiklet":
                return baseFee * 0.8;
            default:
                return baseFee;
        }
    }
}
