import java.util.*;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {

	
	double p_graph;
	double p_malicious;
	double p_txDistribution;
	int numRounds;
	boolean [] followees;
	Set <Transaction> pendingTransactions;
	Set <Candidate> candidates;
	
	
	
    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
		this.p_graph = p_graph;
		this.p_malicious = p_malicious;
		this.p_txDistribution = p_txDistribution;
		this.numRounds = numRounds;
    }

    public void setFollowees(boolean[] followees) {
        // IMPLEMENT THIS
		this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // IMPLEMENT THIS
		this.pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> sendToFollowers() {
        // IMPLEMENT THIS
		return this.pendingTransactions;
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        // IMPLEMENT THIS
		Set <Transaction> tx = null;
		this.candidates = candidates;
		Iterator<Candidate> setIterator = this.candidates.iterator();
        while(setIterator.hasNext()){
           
			Candidate candidate = setIterator.next();
			
			if (candidate.tx == null)
			{
				this.followees[candidate.sender] = false;
				continue;
			}
			if (this.followees[candidate.sender] != true){
			     setIterator.remove();
				 continue;
			 }
			
			 tx.add(candidate.tx);
        }
		this.setPendingTransaction(tx);
		
    }
}
