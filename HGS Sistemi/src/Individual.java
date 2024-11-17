import java.util.ArrayList;
import java.util.List;

public class Individual extends HGSAccounts implements DisplayableDeposite, DisplayableRoutes {
    private List<HGSPassages> passagesList = new ArrayList<>();

    public Individual(String idNumber, String lastName, String firstName, String vehicleClass, double balance) {
        super(idNumber, lastName, firstName, vehicleClass, balance);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Ad: " + firstName + " " + lastName);
        System.out.println("Kimlik Numarası: " + idNumber);
        System.out.println("Araç Sınıfı: " + vehicleClass);
        System.out.println("Bakiye: " + balance);
    }

    @Override
    public void deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " TL geçiş ücreti düşüldü. Yeni bakiye: " + balance);
        } else {
            System.out.println("Yetersiz bakiye! Geçiş yapılamıyor.");
        }
    }


    @Override
    public void addBalance(double amount) {
        balance += amount;
        System.out.println(amount + " TL bakiye eklendi. Yeni bakiye: " + balance);
    }

    public void addPassage(HGSPassages passage) {
        if (balance >= passage.fee) {
            passagesList.add(passage);
            passage.recordPassage();
            deductBalance(passage.fee);
        } else {
            System.out.println("Yetersiz bakiye! Geçiş eklenemedi.");
        }
    }


    @Override
    public void displayableDeposite() {
        displayAccountInfo();
    }

    @Override
    public void displayableRoutes() {
        System.out.println("Bireysel hesap için tüm güzergahlar:");
        for (HGSPassages passage : passagesList) {
            System.out.println("Tarih: " + passage.date + ", Giriş Gişesi: " + passage.entryGate +
                    ", Çıkış Gişesi: " + passage.exitGate + ", Ücret: " + passage.fee + " TL");
        }
    }
}
