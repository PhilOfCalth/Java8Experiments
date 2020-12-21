namespace doubleDispatch.csharp{
    class SpaceSimulatorClient {

        public static void Main(string[] args) {
            OrkShip unscannedShip = new OrkShip();
            OrkShip enemyUnscannedShip = new OrkShip();

            OrkShip scannedShip = new OrkSavageGunship();
            OrkShip enemyScannedShip = new OrkSavageGunship();

            OrkSavageGunship enemyShipInVisualRange = new OrkSavageGunship();

            unscannedShip.fireUpon((dynamic) enemyUnscannedShip);
            unscannedShip.fireUpon((dynamic) enemyScannedShip);
            unscannedShip.fireUpon((dynamic) enemyShipInVisualRange);

            ((dynamic) scannedShip).fireUpon((dynamic) enemyUnscannedShip);
            ((dynamic) scannedShip).fireUpon((dynamic) enemyScannedShip);
            ((dynamic) scannedShip).fireUpon((dynamic) enemyShipInVisualRange);

        }
    }
}
