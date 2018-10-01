package projects.wsaudit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        e.setKeySet(20);
        e.setValueSet("twenty");
       
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
