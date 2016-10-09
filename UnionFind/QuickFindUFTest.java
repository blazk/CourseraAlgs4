import static org.junit.Assert.*;
import org.junit.Test;

public class QuickFindUFTest
{
    @Test
    public void testIt()
    {
        QuickFindUF uf = new QuickFindUF(5);
        uf.union(0,4);
        assertTrue(uf.connected(0,4));
    }
}
