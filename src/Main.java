package validering;

public class Main {

    public static void main(String[] args) {

        /* Example usage */

        /* Create checks */
        ValidityCheck isPersonNumber = new IsPersonNumber();
        ValidityCheck notNull = new NotNull();

        /* Create ValidityChecker */
        ValidityCheck[] checkObjects = {isPersonNumber, notNull};
        ValidityChecker checker = new ValidityChecker(checkObjects);


        checker.check("19010320341");  // pass
        checker.check(null);            // fail
        checker.check();
    }

}
