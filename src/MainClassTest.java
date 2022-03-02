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
            Assert.fail("FAIL:testGetClassNumber:Result_test:"+ z);
        }
        else
        {
         System.out.println("PASS:testGetClassNumber:Result_test:" + z);
        }
    }

    //Test_3
    @Test
    public void testGetClassString()
    {
        String z = this.getClassString ();

        if (z.contains("Hello") ||  z.contains("hello"))
        {
            System.out.println("PASS:testGetClassString:Result_test:" + z);
        }
        else
        {
            Assert.fail("FAIL:testGetClassString:Result_test:"+ z);
        }
    }
}

