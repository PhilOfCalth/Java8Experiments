package doubleDispatch.java;

public class DauntlessCruiser extends ImperialShip {

    public void fireUpon(ImperialShip enemy){
        System.out.println("I know there is an enemy there, but I see no specifics!");
    }

    public void fireUpon(DauntlessCruiser enemy){
        System.out.println("Firing all 4 starboard batteries at the enemy. "
                            + "We expect to get at least 1 hit through their shields!");
    }
}
