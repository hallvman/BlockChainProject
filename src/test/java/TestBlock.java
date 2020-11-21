import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBlock {

    @Test
    public void TestBlock(){
        Block block = new Block("Hallvard", "Andreas", 100, "0");
        assertEquals("Hallvard", block.getFraName());
        assertEquals("Andreas", block.getTilName());
        assertEquals("0", block.getPreviousHash());

        Block secondBlock = new Block("aASS", "mASS", 1000, block.getBlockHash());

        assertEquals(block.getBlockHash(), secondBlock.getPreviousHash());
    }
}
