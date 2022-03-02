public class MainClass
{
    //Test_1
    public int getLocalNumber()
    {
        int x = 14;
        return x;
    }

    //Test_2
    private int class_number = 46;

    public int getClassNumber()
    {
        int m = this.class_number;
        //System.out.println(m);
        return m;
    }

    //Test_3
    private String class_string = "Hello, world";

    public String getClassString()
    {
        String m = this.class_string;
        //System.out.println(m);
        return m;
    }
}
