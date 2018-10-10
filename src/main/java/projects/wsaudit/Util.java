package projects.wsaudit;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Util 
{
	private SessionFactory sessionFactory = null;
	private ServiceRegistry serviceRegistry = null;
	private Session session = null;
	private TestEntity test = null;
		
	public Util(String val, String desc){
       Configuration config = 
    		   new Configuration()
    		   .configure("projects/wsaudit/hibernate.cfg.xml")
    		   .addAnnotatedClass(TestEntity.class);

       serviceRegistry = 
        		new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        
       sessionFactory = config.buildSessionFactory(serviceRegistry);
       session = sessionFactory.openSession();
        
       test = new TestEntity();
       test.setValueSet(val);
       test.setDescription(desc);
       Timestamp timestamp = new Timestamp(System.currentTimeMillis());
       System.out.println("InTime -> "+timestamp);
       test.setT1(timestamp);
	}
	
	public void stage() throws Exception{
		try{
			Thread thread = new Thread(new Runnable(){
				public void run(){
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			        test.setT1(timestamp);
			        System.out.println("OutTime -> "+timestamp);
			        try {
						inserOrUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			thread.start();
		}
		catch(Exception e){
			throw new Exception("inserOrUpdate: " + e); 
		}
	}
	
	private void inserOrUpdate() throws Exception{
		try{
	        Transaction trans = session.beginTransaction();
	        session.saveOrUpdate(test);
	        trans.commit();
		}
		catch(Exception e){
			throw new Exception("inserOrUpdate: " + e); 
		}		
		finally{
			session.close();
			serviceRegistry.close();
			sessionFactory.close();
		}
	}
}