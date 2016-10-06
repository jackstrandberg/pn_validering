package validering;


import java.time.YearMonth;
import java.util.Calendar;

public class IsPersonNumber implements ValidityCheck{

        /*
        * Decides if input is a valid personnummer/personNumber.
        *
        * calculateCheckDigit() determines a check digit from a 12 digit personNumber string. The check digit
        * should match the final digit of the personNumber for it to be valid.
        *
        *     Example: From "190103203451", the check digit is calculated from the middle digits
        *                 s = "010320345" and should here be 1 for a valid personNumber.
        *
        * Algorithm
        *     1. For even i: s[i] *= 2
        *        For odd  i: s[i] *= 1
        *
        *     2. Two-digit elements, s[i], are then replaced with the
        *                                         sum of its constituent digits.
        *
        *     3. The check digit is then calculated as
        *                             check_digit = [10 - (sum(s) mod10)] mod 10
        *
        *     4. valid if check_digit == final_digit
        */

    private static final int MIN_NUM_LENGTH = 10;
    private static final int MAX_NUM_LENGTH = 13;

    @Override
    public boolean check(Object candidateData) {
            return isPersonNumber(candidateData);
    }

    private boolean isPersonNumber(Object candidateData) throws NullPointerException, IllegalArgumentException {
        // Assure input to be string so that a 10 digit int or long
        // beginning with a 0 is not passed in as octal
        if (!(candidateData instanceof String)) {
            return false;
        }
        String candidateString = candidateData.toString().trim();

        if ((candidateString.length() < MIN_NUM_LENGTH) || (candidateString.length() > MAX_NUM_LENGTH)) {
            return false;
        }

        candidateString = formatPersonNumber(candidateString);
        if (!candidateString.matches("[0-9]+")
                || candidateString.length() != 12
                || !hasValidDate(candidateString)) {
            return false;
        }

        /* Calculate check digit and compare with control digit (last digit of input) */
        int checkDigit = calculateCheckDigit(candidateString);
        int controlDigit = Integer.parseInt(candidateString.substring(candidateString.length() - 1));

        return checkDigit == controlDigit;
    }

    private String formatPersonNumber(String s) {
        boolean hasDash = s.charAt(s.length() - 5) == '-';
        if (hasDash) {
            if (s.length() % 2 == 1) {
                s = s.substring(0, s.length() - 5) + s.substring(s.length() - 4);
            }
        }

        if (s.length() == 10) {
            s = "00" + s;
        }
        return s;
    }

    private boolean hasValidDate(String candidateString) {
        String dateCandidate = candidateString.substring(0, candidateString.length() - 4);
        int yearCandidate = Integer.parseInt(dateCandidate.substring(0,4));
        int monthCandidate = Integer.parseInt(dateCandidate.substring(4,6));
        int dayCandidate = Integer.parseInt(dateCandidate.substring(dateCandidate.length() - 2));

        boolean yearIsValid = (yearCandidate <= Calendar.getInstance().get(Calendar.YEAR));
        boolean monthIsValid = (monthCandidate >= 1 && monthCandidate <= 12);

        if (!yearIsValid || !monthIsValid) {
            return false;
        }
        YearMonth yearMonthObject = YearMonth.of(yearCandidate, monthCandidate);

        return (dayCandidate >= 1 && dayCandidate <= yearMonthObject.lengthOfMonth());
    }

    private int calculateCheckDigit (String candidateString) {
        String checkString = candidateString.substring(2, candidateString.length() - 1);
        int[] checkDigits = new int[checkString.length()];

        int sumDigits = 0;
        for(int i = 0; i < checkString.length(); i++) {
            checkDigits[i] = Integer.parseInt(checkString.substring(i, i + 1));

            checkDigits[i] *= (i % 2 == 0) ? 2 : 1;

            if (checkDigits[i] >= 10) {
                checkDigits[i] = (checkDigits[i] % 10 + checkDigits[i] / 10);
            }
            sumDigits += checkDigits[i];
        }
        return (10 - (sumDigits % 10)) % 10;
    }

}
