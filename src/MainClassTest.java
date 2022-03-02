import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    //Test_1
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
            System.out.println("PASS:testGetLocalNumber:Result_test:" + z);
        }
    }

    //Test_2
    @Test
    public void testGetClassNumber()
    {
        int z = this.getClassNumber();

        if (z <= 45)
        {
            Assert.fail("FAIL:testGetLocalNumber:Result_test:"+ z);
        }
        else
        {
         System.out.println("PASS:testGetLocalNumber:Result_test:" + z);
        }
    }
}
