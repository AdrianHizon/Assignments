import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MerkleTree {

    public String buildFrom(Transaction[] transactions) throws NoSuchAlgorithmException {
        //the existing code here is given to help you learn how SHA is used etc.
        //the code is not complete. It does not build a Merkle tree, just iterates over transactions and takes their hash
        //You can change this function how ever you want. You can delete the code, and rewrite your own.
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String[] hashArray = new String[transactions.length];
        for(int i=0; i<transactions.length; i=i+1){
            Transaction tx1 = transactions[i];
            hashArray[i] = UtilityFunctions.getSHA256(digest, tx1.toString());
        }
        
        recursiveHash(hashArray, 0, hashArray.length, digest);
        String topHash = hashArray[0];
        System.out.println("Top hash is: " + topHash);
        return topHash;
    }
    
    public static void recursiveHash(String[] a, int level, int levelLength, MessageDigest digest) {
		System.out.println("Merkle Tree, Bottom Up, Level: "+ level +", number of hashes: " + levelLength);
		if(levelLength != 1) {
			for(int i = 0; i < levelLength / 2; i++) {
				a[i] = UtilityFunctions.getSHA256(digest, a[2 * i] + a[(2 * i) + 1]);
			}
			if(levelLength % 2 == 0) {
				recursiveHash(a, level + 1, levelLength/2, digest);
			}
			else {
				a[levelLength / 2] = a[levelLength - 1];
				recursiveHash(a, level + 1, (levelLength/2) + 1, digest);
			}
		}
    }
}
