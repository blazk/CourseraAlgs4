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
        p.open(1, 1);
        assertFalse(p.percolates());
    }

    @Test
    public void test2x2NotPercolating3()
    {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 2);
        assertFalse(p.percolates());
    }

    @Test
    public void test2x2Percolating()
    {
        Percolation p = new Percolation(2);
        p.open(1, 2);
        p.open(2, 2);
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
        p.open(1, 1);
        assertTrue(p.percolates());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInvalidGridSize()
    {
        Percolation p = new Percolation(0);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testIsOpenOutsideGrid()
    {
        Percolation p = new Percolation(3);
        p.isOpen(1, 4);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testIsFullOutsideGrid()
    {
        Percolation p = new Percolation(3);
        p.isFull(1, 4);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testOpenOutsideGrid()
    {
        Percolation p = new Percolation(3);
        p.open(1, 4);
    }
}
