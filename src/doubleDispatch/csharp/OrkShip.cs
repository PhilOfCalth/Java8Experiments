using System;

namespace doubleDispatch.csharp{
    class OrkShip {
        public void fireUpon(OrkShip enemy) {
            Console.WriteLine("Who is they? Who is us?! I is so confusted boss!");
        }

        public void fireUpon(OrkSavageGunship enemy) {
            Console.WriteLine("I sees de gunship, where is our gunz?!");
        }
    }
}
