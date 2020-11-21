import java.util.Arrays;
import java.util.ArrayList;

public class BlockChain {

    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int difficulty = 1;

    public BlockChain() {

    }

    // Check if the chain is valid
    public boolean isValid(){
        for (int i = 1; i < blockChain.size(); i++) {
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i - 1);

            if (!currentBlock.getBlockHash().equals(currentBlock.calculateHash())){
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getBlockHash())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Block firstBlock = new Block("hASS", "aASS", 100, "0");
        Block secondBlock = new Block("aASS", "mASS", 1000, firstBlock.getBlockHash());
        blockChain.add(firstBlock);
        blockChain.add(secondBlock);

        BlockChain bc = new BlockChain();

        System.out.println("Is blockchain valid? " + bc.isValid());

        // Miner block 1 and 2. Even with diff set at 1 it takes a long time to be mined
        //blockChain.get(0).mineBlock(difficulty);
        //blockChain.get(1).mineBlock(difficulty);

        System.out.println("The blockchain: " + blockChain.toString());
    }
}
