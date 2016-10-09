import static org.junit.Assert.*;
import org.junit.Test;

public class UFQuickFindTest
{
    @Test
    public void testIt()
    {
        UFQuickFind uf = new UFQuickFind(5);
        uf.union(0,4);
        assertTrue(uf.connected(0,4));
    }
}
