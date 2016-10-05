
public class Main {

    public static void main(String[] args) {

        /* Example usage */

        /* Create checker */
        ValidityChecker checker = new ValidityChecker();

        /* Create checks */
        ValidityCheck check1 = new IsPersonNumber("190103203451");          // true
        ValidityCheck check2 = new IsPersonNumber("0103203451");            // true
        ValidityCheck check3 = new IsPersonNumber(190103203451L);           // true
        ValidityCheck check4 = new IsPersonNumber("190103203452");          // false
        ValidityCheck check5 = new IsPersonNumber(190103203452L);           // false
        ValidityCheck check6 = new IsPersonNumber("\n 190103203451 \n");    // true
        ValidityCheck check7 = new IsPersonNumber(null);                    // false

        ValidityCheck check8 = new NotNull();       // true
        ValidityCheck check9 = new NotNull(null);   // false

        /* Add checks to checker then run */
        checker.addValidityCheck(check1);
        checker.addValidityCheck(check2);
        checker.addValidityCheck(check3);
        checker.addValidityCheck(check4);
        checker.addValidityCheck(check5);
        checker.addValidityCheck(check6);
        checker.addValidityCheck(check7);
        checker.addValidityCheck(check8);
        checker.addValidityCheck(check9);
        
        checker.run();


        /* Or run checks by parameter */
        // checker.run(check6);
        // checker.run(check5, check2, check3);
    }

}
