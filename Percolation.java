
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
	private final WeightedQuickUnionUF quickUnionStructure;
	private int gridsize ;
	private boolean[][] grid; 
	private int TopSite;
    private int BottomSite;

	
	public Percolation(int n)        {
		if (n <= 0) {
			throw new java.lang.IllegalArgumentException("The grid size must be greater than zero.");	
		}
		this.gridsize = n;
		this.grid = new boolean [n][n];
		quickUnionStructure = new WeightedQuickUnionUF(gridsize*gridsize + 2);
		BottomSite = n * n + 1 ;
		TopSite = 0;
	}       // create n-by-n grid, with all sites blocked
	   public void open(int row, int col) {
		   if(row <= 0 || row > gridsize || col <= 0 || col > gridsize ){
			   throw new java.lang.IndexOutOfBoundsException();
		   }
		   if(!isOpen(row, col)){
				this.grid[row - 1][col - 1] = true;
			}// open the assigned site
		   
		   if(row == 1){
			   quickUnionStructure.union(getIndex(row, col), TopSite);
		   }
		   if(row == gridsize){
			   quickUnionStructure.union(getIndex(row, col), BottomSite);
		   }
		   if(col > 1 && isOpen(row, col - 1)){
			   quickUnionStructure.union(getIndex(row, col), getIndex(row, col - 1));
		   }
		   if (col < gridsize && isOpen(row, col + 1)){
			   quickUnionStructure.union(getIndex(row, col), getIndex(row, col + 1));
		   }
		   if(row > 1 && isOpen(row - 1, col)){
			   quickUnionStructure.union(getIndex(row, col), getIndex(row - 1, col));
		   }
		   if(row < gridsize && isOpen(row + 1, col)){
			   quickUnionStructure.union(getIndex(row, col), getIndex(row + 1, col));
		   }
	   }   // open site (row, col) if it is not open already
	   public boolean isOpen(int row, int col) {
		   if(row <= 0 || row > gridsize || col <= 0 || col > gridsize ){
			   throw new java.lang.IndexOutOfBoundsException();
		   }
		   return this.grid[row - 1][col - 1];
		   
	   } // is site (row, col) open?
	   public boolean isFull(int row, int col){
		   if(row <= 0 || row > gridsize || col <= 0 || col > gridsize ){
			   throw new java.lang.IndexOutOfBoundsException();
		   }
		   return quickUnionStructure.connected(getIndex(row, col), TopSite);
	   }  // is site (row, col) full?
	   public int numberOfOpenSites() {
		   int Countnumber = 0;
		   for(int i = 1; i < grid.length + 1; i++){
			   for (int j = 1; j < grid[i - 1].length + 1; j++) {
				if (isOpen(i, j)){
				   Countnumber++;}
			}
		   }
		   return Countnumber;
		   
	   }      // number of open sites contains an error
	   public boolean percolates()  {
		   return quickUnionStructure.connected(TopSite, BottomSite);
	   }            // does the system percolate?

	   private int getIndex(int row, int col){
		   return (row - 1) * gridsize + col ;
	   }
	   public static void main(String[] args){
		   
	   }   // test client (optional)


}