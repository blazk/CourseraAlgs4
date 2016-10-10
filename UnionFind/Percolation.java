import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
   private int n;
   private int[] grid;
   private WeightedQuickUnionUF uf;

   public Percolation(int n)               // create n-by-n grid, with all sites blocked
   {
       this.n = n;
       this.grid = new int[n*n];
       this.uf = new WeightedQuickUnionUF((n*n)+2);
       // connect top and bottom row to virtual sites
       int v1 = n*n;
       int v2 = n*n + 1;
       for (int j=0; j<n; j++)
       {
           uf.union(j, v1);
           uf.union((n-1)*n + j, v2);
       }
   }

   public void open(int i, int j)          // open site (row i, column j) if it is not open already
   {
       if (!isOpen(i, j))
           return;
       int a = i * n + j;
       grid[a] = 1;
       i--;
       if (i >= 0)
       {
           int b = i * n + j;
           if (isOpen(i, j)) uf.union(a, b);
       }
       i++; j--;
       if (j >= 0)
       {
           int b = i * n + j;
           if (isOpen(i, j)) uf.union(a, b);
       }
       i++; j++;
       if (i < n)
       {
           int b = i * n + j;
           if (isOpen(i, j)) uf.union(a, b);
       }
       i--; j++;
       if (j < n)
       {
           int b = i * n + j;
           if (isOpen(i, j)) uf.union(a, b);
       }
   }

   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
   {
       return grid[i * n + j] == 1;
   }

   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   {
       return grid[i * n + j] == 0;
   }

   public boolean percolates()             // does the system percolate?
   {
       return uf.connected(n*n, n*n + 1);
   }

   public static void main(String[] args)  // test client (optional)
   {
   }
}

