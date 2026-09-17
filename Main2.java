class Doctor {
    private final int doctorId;
    private final String name;
    private final String specialization;
    private final double consultationFee;

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }

    public void displayDoctor() {
        System.out.println("Doctor ID: " + doctorId + " | Name: Dr. " + name + 
                           " | Specialization: " + specialization + " | Fee: $" + consultationFee);
    }
}

class Patient {
    private final int patientId;
    private final String name;
    private final String disease;
    private final int age;
    private Doctor assignedDoctor;

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public void assignDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void displayPatientInfo() {
        System.out.println("Patient ID: " + patientId + " | Name: " + name + 
                           " | Age: " + age + " | Disease: " + disease);
        if (assignedDoctor != null) {
            System.out.print("  Assigned ");
            assignedDoctor.displayDoctor();
        } else {
            System.out.println("  No doctor assigned.");
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Doctor doc1 = new Doctor(1, "Sarah Connor", "Cardiology", 150.0);
        Doctor doc2 = new Doctor(2, "Gregory House", "Neurology", 200.0);

        Patient p1 = new Patient(101, "John Doe", "Heart Condition", 45);
        Patient p2 = new Patient(102, "Jane Roe", "Migraine", 30);
        Patient p3 = new Patient(103, "Bob Martin", "Arrhythmia", 60);

        // Assign patients based on specialization
        p1.assignDoctor(doc1);
        p2.assignDoctor(doc2);
        p3.assignDoctor(doc1);

        Patient[] patients = {p1, p2, p3};
        Doctor[] doctors = {doc1, doc2};

        System.out.println("=== Patient and Assigned Doctor Details ===");
        for (Patient p : patients) {
            p.displayPatientInfo();
            System.out.println();
        }

        System.out.println("=== Total Consultation Fees Collected ===");
        for (Doctor doc : doctors) {
            int count = 0;
            for (Patient p : patients) {
                if (p.getAssignedDoctor() != null && p.getAssignedDoctor().getDoctorId() == doc.getDoctorId()) {
                    count++;
                }
            }
            double totalFee = count * doc.getConsultationFee();
            System.out.println("Dr. " + doc.getName() + " (" + doc.getSpecialization() + 
                               "): Assigned Patients = " + count + " | Total Fee Collected = $" + totalFee);
        }
    }
}