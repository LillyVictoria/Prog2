
void main() throws FileNotFoundException {
    NameGenerator nameGenerator = new NameGenerator("src/res/NameElements.txt");
    List<Displayable> hospitalPeeps = new ArrayList<>();
    Set<Patient> patients = new HashSet<>();
    Map<Integer, Doctor> doctors = new HashMap<>();
    for(int i = 0; i < 20; i++) {
        if(Math.random() < 0.5) {
            Patient p = new Patient(nameGenerator.next(), (int) (Math.random() * 10_000));
            hospitalPeeps.add(p);
            patients.add(p);
        } else {
            Doctor d = new Doctor(nameGenerator.next(), (int)(Math.random() * 10_000));
            hospitalPeeps.add(d);
            doctors.put(d.getDoctorId(), d);
        }
    }

    System.out.println("Selective list of some people in the hospital:");
    for(Displayable peep : hospitalPeeps) {
        peep.displayInfo();
    }

    System.out.printf("%nUnordered list of all patients:%n");
    for(Patient patient : patients) {
        patient.displayInfo();
    }

    System.out.printf("%nUnordered list of all doctors:%n");
    for(Doctor doctor : doctors.values()) {
        doctor.displayInfo();
    }
}
