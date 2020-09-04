import java.util.ArrayList;

/* Samim Hakimi created on 8/26/20*/
public class MerkleThread implements Runnable{

    private static volatile ArrayList<String> mListWords;
    private int mMerkleTreeInputs = 4;

    private Util util = new Util();
    private MerkleManager manager = new MerkleManager();




    @Override
    public void run() {
        mListWords = new ArrayList<>();

        while (true){
            util.randomSleep("Merkle Thread sleeping, ");
            String mNewWord = manager.grabWord();

            //validating the user input
            if (mNewWord != null){
                print("Merkle grabbed the word!" );
                mListWords.add(mNewWord);
                if(mListWords.size() == mMerkleTreeInputs){
                    print("mListOfWords Size: " + mListWords.size());
                    MerkleManager.mMerkleRoot = util.getMerkleNode(mListWords);

                }
            }
            //words that merkle has grabbed
            util.printList(mListWords);

        }

    }


    public static void print(String s){
        System.out.println(s);
    }
}
