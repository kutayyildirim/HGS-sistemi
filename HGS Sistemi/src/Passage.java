public class Passage extends HGSPassages {

    public Passage(String date, String entryGate, String exitGate, double fee) {
        super(date, entryGate, exitGate, fee);
    }

    @Override
    public void recordPassage() {
        System.out.println("Geçiş kaydedildi:");
        System.out.println("Tarih: " + date);
        System.out.println("Giriş Gişesi: " + entryGate);
        System.out.println("Çıkış Gişesi: " + exitGate);
        System.out.println("Ücret: " + fee + " TL");
    }
}
