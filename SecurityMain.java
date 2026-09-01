interface BasicSecurity {
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity {
    void authenticateFingerprint();
    void authenticateFace();
}

class BankingApplication implements AdvancedSecurity {
    private final String username;

    public BankingApplication(String username) {
        this.username = username;
    }

    @Override
    public void login() {
        System.out.println(username + " logged in with password.");
    }

    @Override
    public void logout() {
        System.out.println(username + " logged out successfully.");
    }

    @Override
    public void authenticateFingerprint() {
        System.out.println("Fingerprint scanner verified for " + username);
    }

    @Override
    public void authenticateFace() {
        System.out.println("Face recognition verified for " + username);
    }
}

public class SecurityMain {
    public static void main(String[] args) {
        AdvancedSecurity app = new BankingApplication("Pranay");
        
        app.authenticateFingerprint();
        app.authenticateFace();
        app.login();
        app.logout();
    }
}