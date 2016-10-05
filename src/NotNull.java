
class NotNull extends ValidityCheck {

    public NotNull() {
        this.candidateData = "";
    }

    public NotNull(Object candidateData) {
        this.candidateData = candidateData;
    }

    @Override public boolean check() {
        try {
            return notNull();
        } catch (Exception e) {
            System.out.println("Error unhandled input: " + e.getMessage());
            return false;
        }
    }

    private boolean notNull() {
        try {
            return (this.candidateData != null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}
