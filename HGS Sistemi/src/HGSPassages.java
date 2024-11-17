public abstract class HGSPassages {
    protected String date;
    protected String exitGate;
    protected String entryGate;
    protected double fee;

    public HGSPassages(String date, String entryGate, String exitGate, double fee) {
        this.date = date;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.fee = fee;
    }

    public abstract void recordPassage();
}