import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;

/* Samim Hakimi created on 8/26/20*/
public class Util {

    public String getMerkleNode(ArrayList<String> list){


        MerkleNode node0 = new MerkleNode();
        MerkleNode node1 = new MerkleNode();
        MerkleNode node2 = new MerkleNode();
        MerkleNode node3 = new MerkleNode();
        MerkleNode node4 = new MerkleNode();
        MerkleNode node5 = new MerkleNode();
        MerkleNode node6 = new MerkleNode();


        // leaves
        node0.mHash = generateHash(list.get(0));

        node1.mHash = generateHash(list.get(1));
        node2.mHash = generateHash(list.get(2));
        node3.mHash = generateHash(list.get(3));

        //child
        populateMerkleNode(node4, node0, node1 );
        populateMerkleNode(node5, node2,node3 );
        //parent or root
        populateMerkleNode(node6, node4, node5 );
        print("DEBUG: root hash: " + node6.mHash);
        return node6.mHash;


    }

    private void populateMerkleNode(MerkleNode node, MerkleNode leftNode, MerkleNode rightNode) {
        node.mLeft = leftNode;
        node.mRight = rightNode;
        //adding the two hashes and create the new next node
        node.mHash = generateHash(leftNode.mHash + rightNode.mHash);
    }

    private synchronized String generateHash(String hash){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] mEncode = digest.digest(hash.getBytes(StandardCharsets.UTF_8));

            return bytesToHex(mEncode);

        }catch (Exception e){
            print("hash error: " + e.getMessage());
            return null;
        }
    }

    private static String bytesToHex(byte[] hash){
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append(0);
            hexString.append(hex);
        }
        return hexString.toString();
    }


    public String promptUser(String s) {
        return JOptionPane.showInputDialog(s);
    }

    public void randomSleep(String s){
        //get numbers between 0 and 5 add 3
        int mSleepTime = new SecureRandom().nextInt(5) + 3;
        print(s + ", sleeping for " + mSleepTime + " sec");
        sleepTime(mSleepTime);
    }

    public void sleepTime(int sec){
        try {
            Thread.sleep(sec * 1000);
        }catch (Exception e){
            print("Error " + e.getMessage());
        }
    }

    //print the list
    public void printList(ArrayList<String> list){
        for(String s: list){
            print(s + " ");
        }
    }


    public static void print(String s){
        System.out.println(s);
    }
}
