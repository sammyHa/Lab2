/* Samim Hakimi created on 8/26/20*/

import java.util.Scanner;

public class MerkleManager {
    // init vars
    public static volatile String mUserEnteredWord;
    public static String sEnteredExpectedRoot;
    public static String sMerkleRoot = null;
    public static int iStrikes = 0;

    public static void manage(){
        // instantiate the Util class
        Util util = new Util();

        //c. initiating the 3 threads
        Thread merkleThread = new Thread(new MerkleThread());
        Thread rogueThread = new Thread(new RogueThread());
        Thread monitorThread = new Thread(new MonitorThread());

        sEnteredExpectedRoot = util.promptUser("Enter the merkle root!: ");


        //starting all the above threads
        merkleThread.start();
        rogueThread.start();
        monitorThread.start();


        // runn the inifite loop
        while (true){
            mUserEnteredWord = util.promptUser("Enter word: ");
            util.print("user enterd words: " + mUserEnteredWord);
        }

    }

    public String grabWord() {
        String temp = mUserEnteredWord;
        mUserEnteredWord = null;
        return temp;
    }
}
