/* Samim Hakimi created on 8/26/20*/

public class MerkleManager {
    // init vars
    public static volatile String mUserEnteredWord;
    public static String mExpectedRoot;
    public static String mMerkleRoot = null;
    public static int mStrikes = 0;

    public static void manage(){
        // instantiate the Util class
        Util util = new Util();

        //c. init the 3 threads
        Thread merkleThread = new Thread(new MerkleThread());
        Thread rogueThread = new Thread(new RogueThread());
        Thread monitorThread = new Thread(new MonitorThread());

        mExpectedRoot = util.promptUser("Enter the merkle root!");


        //starting all the above 3 threads
        merkleThread.start();
        rogueThread.start();
        monitorThread.start();


        // runn the inifinte loop
        while (true){
            mUserEnteredWord = util.promptUser("Enter a word: ");
//            util.print("user enterd words: " + mUserEnteredWord);
        }

    }

    public String grabWord() {
        String temp = mUserEnteredWord;
        mUserEnteredWord = null;
        return temp;
    }
}
