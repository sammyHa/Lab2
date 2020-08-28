/* Samim Hakimi created on 8/26/20*/
public class RogueThread implements Runnable{

    @Override
    public void run() {
        Util util = new Util();
        MerkleManager manager = new MerkleManager();
            while (true){

                util.randomSleep("Rogue Thread");
                String sNewWord = manager.grabWord();
                if (sNewWord != null) {
                    Util.print("Rogue grabbed the word: STRIKE AGAIN!");
                    MerkleManager.iStrikes++;
                }

        }
    }


}
