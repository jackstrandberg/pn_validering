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


        checker.check("190103203451");    // pass
        checker.check("0103203451");      // pass
        checker.check("190103203452");    // fail, not correct control digit
        checker.check(null);              // fail
        checker.check();                  // no test performed
    }

}
