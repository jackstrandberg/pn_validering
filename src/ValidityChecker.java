package validering;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidityChecker {

    private ValidityCheck[] checkObjects;
    private final static Logger LOGGER = Logger.getLogger(ValidityChecker.class.getName());


    public ValidityChecker(ValidityCheck[] checkObjects) {
        this.checkObjects = checkObjects;
    }

    public void check() {
        LOGGER.warning("no input. No check performed.");
    }

    public boolean check(Object candidateData) {
        boolean passedAllChecks = true;
        for (ValidityCheck checkObject : checkObjects) {
            if (!checkObject.check(candidateData)) {
                LOGGER.info("input " + candidateData + " failed " + checkObject.getClass().getName());
                passedAllChecks = false;
            }
        }
        return passedAllChecks;
    }

}
