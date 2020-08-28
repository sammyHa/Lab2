import java.util.ArrayList;

/* Samim Hakimi created on 8/26/20*/
public class MerkleThread implements Runnable{

    public static volatile ArrayList<String> lstWords;
    private Util util = new Util();


    @Override
    public void run() {
        MerkleManager manager = new MerkleManager();
        lstWords = new ArrayList<>();
        while (true){
            util.randomSleep("MerklThread sleeping, ");
            String sNewWord = manager.grabWord();

            //validating the user input
            if (sNewWord != null){
                print("Merkle grabbed the word!" );
                lstWords.add(sNewWord);
                int iMerkleTreeInputs = 4;
                if(lstWords.size() == iMerkleTreeInputs){
                    MerkleManager.sMerkleRoot = util.getMerkleNode(lstWords);

                }
            }
            util.printList(lstWords);

        }

    }


    public static void print(String s){
        System.out.println(s);
    }
}
