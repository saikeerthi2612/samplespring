package com.anudip.Library;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {
       Configuration con=new Configuration();
       con.configure("/com/anudip/Library/hibernate.cfg.xml");
       con.addAnnotatedClass(Library.class);
       SessionFactory sf=con.buildSessionFactory();
       Session s=sf.openSession();
       Library l=new Library();
       l.setlId(103);
       l.setBookName("dsd");
       l.setAuthor("sda");
       s.beginTransaction();
       s.save(l);
       s.getTransaction().commit();
       s.close();
       Session s1=sf.openSession();
       List<Library> li=s1.createQuery("from Library",Library.class).list();
       li.forEach(lib->System.out.println(lib.getlId()+" "+lib.getBookName()+" "+lib.getAuthor()));
       s1.close();
    }
}
