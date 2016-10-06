
public class NotNull implements ValidityCheck {

    @Override
    public boolean check(Object candidateData) {
            return notNull(candidateData);
    }

    private boolean notNull(Object candidateData) {
            return (candidateData != null);
    }

}
