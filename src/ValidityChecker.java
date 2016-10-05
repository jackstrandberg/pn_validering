public class ValidityChecker {

    private ValidityCheck[] checkObjects;

    public ValidityChecker(ValidityCheck[] checkObjects) {
        this.checkObjects = checkObjects;
    }

    public boolean check(Object candidateData) {

        boolean passedAllChecks = true;
        for (ValidityCheck checkObject : checkObjects) {
            if (!checkObject.check(candidateData)) {
                //log
                passedAllChecks = false;
            }
        }
        if (passedAllChecks) {
            System.out.println("passed");
            return true;
        } else {
            System.out.println("failed");
            return false;
        }
    }

}
