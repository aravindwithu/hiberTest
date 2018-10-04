package projects.wsaudit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.Timestamp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        TestEntity  e= new TestEntity();
        e.setValueSet("twenty");
        e.setDescription("twenty first century");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        e.setT1(timestamp);
       
        Configuration con = new Configuration().configure().addAnnotatedClass(TestEntity.class) ;
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(e);
        trans.commit();
        
        e.setValueSet(e.getValueSet()+"-one");
        
        trans = session.beginTransaction();
        session.saveOrUpdate(e);
        trans.commit();
    }
}
