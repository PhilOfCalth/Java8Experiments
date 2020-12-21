package doubleDispatch.java;

public class SpaceSimulatorClient {

    public static void main(String[] args){
        ImperialShip unscannedShip = new ImperialShip();
        ImperialShip enemyUnscannedShip = new ImperialShip();

        ImperialShip scannedShip = new DauntlessCruiser();
        ImperialShip enemyScannedShip = new DauntlessCruiser();

        DauntlessCruiser enemyShipInVisualRange = new DauntlessCruiser();

        unscannedShip.fireUpon(enemyUnscannedShip);
        unscannedShip.fireUpon(enemyScannedShip);
        unscannedShip.fireUpon(enemyShipInVisualRange);

        scannedShip.fireUpon(enemyUnscannedShip);
        scannedShip.fireUpon(enemyScannedShip);
        scannedShip.fireUpon(enemyShipInVisualRange);

    }
}
