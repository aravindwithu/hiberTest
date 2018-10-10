package projects.wsaudit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Util util = new Util("twenty","twentyth century");
        Thread.sleep(1000);
        util.stage();
    }
}
