import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
	private int NumExperiments;
	private Percolation Groupsites;
	private double [] threshold;
	
	public PercolationStats(int n, int trials){
		
		if(n > 0 && trials >0){
		NumExperiments = trials;
		threshold = new double[trials];
		for(int i = 0; i < NumExperiments; i++){
			Groupsites = new Percolation(n);
			 //int openedSites = 0;
		while (!Groupsites.percolates()){
			int row = StdRandom.uniform(1, n + 1);
			int col = StdRandom.uniform(1, n + 1);
			Groupsites.open(row, col);

		
				}
		threshold[i] = (double)Groupsites.numberOfOpenSites()/(n*n);
		}
		}
		else{
			throw new java.lang.IllegalArgumentException();
			
		}
	}     //perform trials independent experiments on an n-by-n grid
	   public double mean() {
		   return StdStats.mean(threshold);
	   }                         // sample mean of percolation threshold
	   public double stddev() {
		   return StdStats.stddev(threshold);
		   
	   }                       // sample standard deviation of percolation threshold
	   public double confidenceLo(){
		   return mean() - 1.96*stddev()/Math.sqrt(NumExperiments);
	   }                  // low  endpoint of 95% confidence interval
	   public double confidenceHi()  {
		   return mean() + 1.96*stddev()/Math.sqrt(NumExperiments);
	   }                // high endpoint of 95% confidence interval

	   public static void main(String[] args){
		   PercolationStats main1 = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		   StdOut.println("mean                    = " + main1.mean());
		   StdOut.println("stddev                  = " + main1.stddev());
		   StdOut.println("95% confidence interval = " + main1.confidenceLo() + ", " + main1.confidenceHi());
		   
	   }        // test client (described below)
}