public class Main {

    public static void main(String[] args) {

        /* Example usage */

        /* Create checks */
        ValidityCheck isPersonNumber = new IsPersonNumber();
        ValidityCheck notNull = new NotNull();

        /* Create ValidityChecker */
        ValidityCheck[] checkObjects = {isPersonNumber, notNull};
        ValidityChecker checker = new ValidityChecker(checkObjects);

        checker.check("190103203451");
        checker.check("190103203452");
        checker.check(null);

    }

}
