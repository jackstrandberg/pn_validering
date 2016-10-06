package validering;


public class NotNull implements ValidityCheck {

    @Override
    public boolean check(Object candidateData) {
        try {
            return notNull(candidateData);
        } catch (Exception e) {
            LOGGER.warning("input " + candidateData + e.getMessage());
            return false;
        }
    }

    private boolean notNull(Object candidateData) {
            return (candidateData != null);
    }

}
