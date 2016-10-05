
import java.util.ArrayList;
import java.util.List;

public class ValidityChecker {

    private List<ValidityCheck> checkObjects = new ArrayList<ValidityCheck>();


    public void addValidityCheck(ValidityCheck checkObject) {
        checkObjects.add(checkObject);
    }

    public void reset() {
        checkObjects = new ArrayList<ValidityCheck>();
    }

    public void run() {
        for (ValidityCheck checkObject : checkObjects) {
            checkObject.check();
        }
    }

    public void run(ValidityCheck... checkObjects) {
        for (ValidityCheck checkObject : checkObjects) {
            System.out.println(checkObject.check());
        }
    }

}
