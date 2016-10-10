import static org.junit.Assert.*;
import org.junit.Test;

public class PercolationTest
{
    @Test
    public void test2x2NotPercolating1()
    {
        Percolation p = new Percolation(2);
        assertFalse(p.percolates());
    }

    @Test
    public void test2x2NotPercolating2()
    {
        Percolation p = new Percolation(2);
        p.open(0, 0);
        assertFalse(p.percolates());
    }

    @Test
    public void test2x2NotPercolating3()
    {
        Percolation p = new Percolation(2);
        p.open(0, 0);
        p.open(1, 1);
        assertFalse(p.percolates());
    }

    @Test
    public void test2x2Percolating()
    {
        Percolation p = new Percolation(2);
        p.open(0, 1);
        p.open(1, 1);
        assertTrue(p.percolates());
    }

    @Test
    public void test1x1NotPercolating()
    {
        Percolation p = new Percolation(1);
        assertFalse(p.percolates());
    }

    @Test
    public void test1x1Percolating()
    {
        Percolation p = new Percolation(1);
        p.open(0, 0);
        assertTrue(p.percolates());
    }
}
