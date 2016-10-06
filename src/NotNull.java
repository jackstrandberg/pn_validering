
public class NotNull implements ValidityCheck {

    @Override
    public boolean check(Object candidateData) {
        return (candidateData != null);
    }

    @Override
    public String toString(){
        return "NotNull";
    }

}
