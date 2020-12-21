package doubleDispatch.java;

public class ImperialShip {
    public void fireUpon(ImperialShip enemy){
        System.out.println("Apologies captain, but I do not know the specifies of this vessel, nor the enemy!");
    }

    public void fireUpon(DauntlessCruiser enemy){
        System.out.println("I see the Dauntless, but I do not know the specifies of our vessel!");
    }
}
