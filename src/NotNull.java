package validering;


public class NotNull implements ValidityCheck {

    @Override
    public boolean check(Object candidateData) {
        try {
            return notNull(candidateData);
        } catch (Exception e) {
            System.out.println("Error unhandled input: " + e.getMessage());
            return false;
        }
    }

    private boolean notNull(Object candidateData) {
            return (candidateData != null);
    }

}
