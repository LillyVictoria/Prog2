public record Patient(String name, int id) implements Displayable {
    public int getPatientId() {
        return id;
    }
    @Override
    public void displayInfo() {
        System.out.printf("Patient name: %s, Patient ID: %d%n", name, id);
    }
}
