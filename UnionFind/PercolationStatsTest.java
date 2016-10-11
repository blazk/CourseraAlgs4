import static org.junit.Assert.*;
import org.junit.Test;

public class PercolationStatsTest
{
    @Test
    public void test1TrialWith1x1Grid()
    {
        PercolationStats p = new PercolationStats(1, 1);
        assertEquals(p.mean(), 1.0, 0.0);
        assertEquals(p.stddev(), Double.NaN, 0.0);
        assertEquals(p.confidenceLo(), Double.NaN, 0.0);
        assertEquals(p.confidenceHi(), Double.NaN, 0.0);
    }

    @Test
    public void test1TrialWith10x10Grid()
    {
        PercolationStats p = new PercolationStats(10, 1);
        assertEquals(p.mean(), 0.5, 0.5);
        assertEquals(p.stddev(), Double.NaN, 0.0);
        assertEquals(p.confidenceLo(), Double.NaN, 0.0);
        assertEquals(p.confidenceHi(), Double.NaN, 0.0);
    }

    @Test
    public void test30TrialsWith20x20Grid()
    {
        PercolationStats p = new PercolationStats(20, 30);
        assertEquals(p.mean(), 0.5, 0.5);
        assertEquals(p.stddev(), 0.5, 0.5);
        assertEquals(p.confidenceLo(), 0.5, 0.5);
        assertEquals(p.confidenceHi(), 0.5, 0.5);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInvalidNumTrials()
    {
        PercolationStats p = new PercolationStats(0, 10);
    }
}
