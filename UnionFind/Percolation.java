import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
   private int n;
   private int[] grid;
   private WeightedQuickUnionUF uf;

   public Percolation(int n)               // create n-by-n grid, with all sites blocked
   {
       if (n < 1) throw new IllegalArgumentException();
       this.n = n;
       grid = new int[n*n];
       uf = new WeightedQuickUnionUF((n*n)+2);
   }

   private boolean coordsValid(int i, int j)
   {
       return i >= 1 && i <= n && j >= 1 && j <= n;
   }

   private int idx(int i, int j)
   {
       return (i - 1) * n + (j - 1);
   }

   public void open(int i, int j)          // open site (row i, column j) if it is not open already
   {
       if (isOpen(i, j))
           return;
       int a = idx(i, j);
       grid[a] = 1;
       // if first or last row, connect to virtual site
       if (i == 1) uf.union(a, n * n);
       if (i == n) uf.union(a, n * n + 1);
       // connect to neighbours if they are open
       i--;
       if (i >= 1)
       {
           int b = idx(i, j);
           if (isOpen(i, j)) uf.union(a, b);
       }
       i++;
       j--;
       if (j >= 1)
       {
           int b = idx(i, j);
           if (isOpen(i, j)) uf.union(a, b);
       }
       i++;
       j++;
       if (i <= n)
       {
           int b = idx(i, j);
           if (isOpen(i, j)) uf.union(a, b);
       }
       i--;
       j++;
       if (j <= n)
       {
           int b = idx(i, j);
           if (isOpen(i, j)) uf.union(a, b);
       }
   }

   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
   {
       if (!coordsValid(i, j))
           throw new IndexOutOfBoundsException();
       return grid[idx(i, j)] == 1;
   }

   public boolean isFull(int i, int j)     // is site (row i, column j) full?
   {
       if (!coordsValid(i, j))
           throw new IndexOutOfBoundsException();
       return uf.connected(n*n, idx(i, j));
   }

   public boolean percolates()             // does the system percolate?
   {
       return uf.connected(n*n, n*n + 1);
   }

   public static void main(String[] args)  // test client (optional)
   {
   }
}

