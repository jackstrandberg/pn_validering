package validering;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidityChecker {

    private final static Logger LOGGER = Logger.getLogger(ValidityChecker.class.getName());
    private ValidityCheck[] checkObjects;

    public ValidityChecker(ValidityCheck[] checkObjects) {
        this.checkObjects = checkObjects;
    }

    public void check() {
        //log no input, no check performed
    }


    public boolean check(Object candidateData) {
        LOGGER.setLevel(Level.INFO);

        boolean passedAllChecks = true;
        for (ValidityCheck checkObject : checkObjects) {
            if (!checkObject.check(candidateData)) {
                LOGGER.info("input " + candidateData + " failed " + checkObject.getClass().getName());
                passedAllChecks = false;
            }
        }
        return passedAllChecks;
/*
        if (passedAllChecks) {
            System.out.println("passed");
            return true;
        } else {
            System.out.println("failed");
            return false;
*/
        }

}
