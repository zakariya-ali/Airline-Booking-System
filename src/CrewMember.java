public class CrewMember extends Person {
    public CrewMember(String name, int passportNumber){
        super(name, passportNumber);
    }

    @Override
    public double calculatePersonWeight(){
        return 0;
    }
}
