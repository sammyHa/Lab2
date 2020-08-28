/* Samim Hakimi created on 8/26/20*/
public class MonitorThread implements Runnable{
    Util util = new Util();
    
    @Override
    public void run() {
        while (true){
            if (MerkleManager.mMerkleRoot != null){

                if (MerkleManager.mMerkleRoot.equals(MerkleManager.mUserEnteredWord)){

                    print("You win " + MerkleManager.mMerkleRoot);
                    System.exit(0);
                }else{
                    print("root: " + MerkleManager.mMerkleRoot);
                    print("user: " + MerkleManager.mUserEnteredWord);

                    print("The root does not match and you have lost!");
                    System.exit(0);
                }
            }else if(MerkleManager.mStrikes == 3){
                print("3 Strikes: you lost!");
                System.exit(0);
            }
            util.sleepTime(1); // sleep for one sec to give the util object time to update
        }

    }
    public static void print(String s){
        System.out.println(s);
    }
}
