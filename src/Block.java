import java.util.Date;

public class Block {
    private int id; //Nombre d'itérations du bloc
    private int nonce; // Sorte de facteur avec lequel on va multiplier le hash précédent pour obtenir le hash actuel.
    private long timestamp; //"chrono" du bloc en millisecondes.
    private String hash; //hash du bloc actuel
    private String previousHash; //hash du bloc précédent.
    private String transaction;

    public Block(int id, String transaction, String previousHash){
        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime(); // On créée notre premier bloc, on a donc besoin de l'instant présent pour son "chrono".

        generateHash();
    }

    public void generateHash(){
        String dataToHash = Integer.toString(id) + previousHash + Long.toString(timestamp) + Integer.toString(nonce) + transaction.toString();
        String hashValue = SHA256.generateHash(dataToHash);

        this.hash = hashValue;
    }

    public void setHash(String hash) { //Setter de hash
        this.hash = hash;
    }

    public String getHash(){ //Getter de hash
        return this.hash;
    }

    public void setPreviousHash(String previousHash) { //Setter de previousHash
        this.previousHash = previousHash;
    }

    public String getPreviousHash() { //Getter de previousHash
        return previousHash;
    }

    public void incrementNonce(){
        this.nonce++;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.transaction + "-" + this.hash + "-" + this.previousHash;
    }
}
