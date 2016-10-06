
import java.util.logging.Logger;

public interface  ValidityCheck {

    Logger LOGGER = Logger.getLogger(ValidityChecker.class.getName());

    boolean check(Object candidateData);

}
