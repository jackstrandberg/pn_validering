
public class NotNull implements ValidityCheck {

    @Override public boolean check(Object candidateData) {
        try {
            return notNull(candidateData);
        } catch (Exception e) {
            System.out.println("Error unhandled input: " + e.getMessage());
            return false;
        }
    }

    private boolean notNull(Object candidateData) {
        try {
            return (candidateData != null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}
