public class MainProgram {
    public static void main(String[] args){

        BlockChain blockchain = new BlockChain(); //Création de la blockchain
        Miner miner = new Miner(); //Création du mineur

        Block block0 = new Block(0,"transaction1",Constants.GENESIS_PREV_HASH);
        //Création du bloc de départ (0).

        miner.mine(block0, blockchain);

        Block block1 = new Block(1,"transaction2",blockchain.getBlockChain().get(blockchain.size()-1).getHash());

        miner.mine(block1, blockchain);

        Block block2 = new Block(2,"transaction3", blockchain.getBlockChain().get(blockchain.size()-1).getHash());

        miner.mine(block2, blockchain);

        System.out.println("\n" + "BLOCKCHAIN:\n" + blockchain);
        System.out.println("Miner's reward : " + miner.getReward());
    }
}
