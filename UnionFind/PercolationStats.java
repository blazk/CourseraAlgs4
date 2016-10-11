import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats
{
   private int trials;
   private double[] thresholds;

   public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
   {
       if (n < 1 || trials < 1) throw new IllegalArgumentException();
       this.trials = trials;
       thresholds = new double[trials];
       for (int trial = 0; trial < trials; trial++)
       {
           Percolation p = new Percolation(n);
           int threshold = 0;
           while (true)
           {
               int i = StdRandom.uniform(1, n + 1);
               int j = StdRandom.uniform(1, n + 1);
               if (p.isOpen(i, j)) continue;
               p.open(i, j);
               threshold++;
               if (p.percolates()) break;
           }
           thresholds[trial] = (threshold*1.0) / (n*n);
       }
   }

   public double mean()                          // sample mean of percolation threshold
   {
       return StdStats.mean(thresholds);
   }

   public double stddev()                        // sample standard deviation of percolation threshold
   {
       if (trials == 1) return Double.NaN;
       return StdStats.stddev(thresholds);
   }

   public double confidenceLo()                  // low  endpoint of 95% confidence interval
   {
       if (trials == 1) return Double.NaN;
       return mean() - (1.96 * stddev()) / Math.sqrt(trials);
   }

   public double confidenceHi()                  // high endpoint of 95% confidence interval
   {
       if (trials == 1) return Double.NaN;
       return mean() + (1.96 * stddev()) / Math.sqrt(trials);
   }

   public static void main(String[] args)        // test client (described below)
   {
       int n = Integer.parseInt(args[0]);
       int trials = Integer.parseInt(args[1]);
       PercolationStats ps = new PercolationStats(n, trials);
       StdOut.println("mean                    = " + Double.toString(ps.mean()));
       StdOut.println("stddev                  = " + Double.toString(ps.stddev()));
       StdOut.println("95% confidence interval = " + Double.toString(ps.confidenceLo())
                                                   + ", " + Double.toString(ps.confidenceHi()));
   }
}
