import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlockChain {
    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    private int difficulty = 1;

    @Test
    public void TestBlockChain(){
        Block block = new Block("Hallvard", "Andreas", 100, "0");
        Block secondBlock = new Block("aASS", "mASS", 1000, block.getBlockHash());
        blockChain.add(block);
        blockChain.add(secondBlock);

        assertEquals("Hallvard", block.getFraName());
        assertEquals("Andreas", block.getTilName());
        assertEquals("0", block.getPreviousHash());

        BlockChain bc = new BlockChain();

        assertEquals(bc.isValid(), true);
    }
}
