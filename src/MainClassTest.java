import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int z = this.getLocalNumber();

        if (z != 14)
        {
            Assert.fail("FAIL:testGetLocalNumber:Result_test:"+ z);
        }
        else
        {
         System.out.println("TRUE:testGetLocalNumber:Result_test:" + z);
        }
    }
}
