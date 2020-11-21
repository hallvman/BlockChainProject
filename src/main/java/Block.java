public class Block {

    private String fraName;
    private String tilName;
    private int sum;
    private String previousHash;
    private String blockHash;
    private int nonce;

    public Block(String fraName, String tilName, int sum, String previousHash){
        super();
        this.fraName = fraName;
        this.tilName = tilName;
        this.sum = sum;
        this.previousHash = previousHash;
        this.blockHash = calculateHash();
    }

    public String calculateHash(){
        String calculatedHash = StringUtil.applySha256(
                fraName +
                        tilName +
                        sum +
                        previousHash
        );
        return calculatedHash;
    }

    public String getName() {
        return fraName;
    }

    public void setName(String fraName) {
        this.fraName = fraName;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!blockHash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            blockHash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + blockHash);
    }

    @Override
    public String toString() {
        return "Block{" +
                "name='" + fraName + '\'' +
                ", tilName='" + tilName + '\'' +
                ", sum=" + sum +
                ", previousHash=" + previousHash +
                ", blockHash=" + blockHash +
                '}';
    }
}
