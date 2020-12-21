using System;

namespace doubleDispatch.csharp{
    class OrkSavageGunship: OrkShip {
        public void fireUpon(OrkShip enemy) {
            Console.WriteLine("Der is enemy out der, but I don't see it!");
        }

        public void fireUpon(OrkSavageGunship enemy) {
            Console.WriteLine("Firing all 4 Heavy gunz. "
                    + "We should hit 'em good fer at least 2 booms!");
        }
    }
}
