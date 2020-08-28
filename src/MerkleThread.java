import java.util.ArrayList;

/* Samim Hakimi created on 8/26/20*/
public class MerkleThread implements Runnable{

    public static volatile ArrayList<String> mListWords;
    private Util util = new Util();


    @Override
    public void run() {
        MerkleManager manager = new MerkleManager();
        mListWords = new ArrayList<>();
        while (true){
            util.randomSleep("Merkle Thread sleeping, ");
            String mNewWord = manager.grabWord();

            //validating the user input
            if (mNewWord != null){
                print("Merkle grabbed the word!" );
                mListWords.add(mNewWord);
                int mMerkleTreeInputs = 4;
                if(mListWords.size() == mMerkleTreeInputs){
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
