
public class NotNull implements ValidityCheck {

    @Override
    public boolean check(Object candidateData) {
        try {
            return notNull(candidateData);
        } catch (Exception e) {
            LOGGER.warning("unhandled input " + candidateData + e.getMessage());
            return false;
        }
    }

    private boolean notNull(Object candidateData) {
            return (candidateData != null);
    }

}
