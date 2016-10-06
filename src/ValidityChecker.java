
import java.util.logging.Logger;

public class ValidityChecker {

    private ValidityCheck[] checkObjects;
    static Logger LOGGER = Logger.getLogger(ValidityChecker.class.getName());

    public ValidityChecker(ValidityCheck[] checkObjects) {
        this.checkObjects = checkObjects;
    }

    public void check() {
        LOGGER.info("No input. No check performed.");
    }

    public boolean check(Object candidateData) {
        boolean passedAllChecks = true;
        for (ValidityCheck checkObject : checkObjects) {
            if (!checkObject.check(candidateData)) {
                LOGGER.info("failed " + checkObject.getClass().getSimpleName() + " with input: " + candidateData);
                passedAllChecks = false;
            }
        }
        return passedAllChecks;
    }

}
