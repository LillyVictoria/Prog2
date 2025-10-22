public record Doctor(String name, int id) implements Displayable {
    public int getDoctorId() {
        return id;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Doctor name: %s, Doctor ID: %d%n", name, id);
    }
}
