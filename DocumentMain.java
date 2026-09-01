// Marker interface (empty body)
interface Confidential {}

class PublicDocument {
    private final String title;

    public PublicDocument(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class SecretReport implements Confidential {
    private final String title;

    public SecretReport(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

public class DocumentMain {
    public static void checkAccess(Object doc) {
        if (doc instanceof Confidential) {
            System.out.println("[RESTRICTED ACCESS] Document requires high clearance.");
        } else {
            System.out.println("[PUBLIC ACCESS] Document is accessible by all users.");
        }
    }

    public static void main(String[] args) {
        PublicDocument doc1 = new PublicDocument("Company Guidelines.pdf");
        SecretReport doc2 = new SecretReport("Q4_Financial_Audit.pdf");

        checkAccess(doc1);
        checkAccess(doc2);
    }
}