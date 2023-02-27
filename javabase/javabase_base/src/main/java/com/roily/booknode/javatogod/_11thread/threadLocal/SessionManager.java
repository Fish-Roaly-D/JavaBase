package com.roily.booknode.javatogod._11thread.threadLocal;

import cn.hutool.db.Session;
import lombok.Data;
import org.junit.Assert;

/**
 * @author: rolyfish
 */
public class SessionManager {
    private static final ThreadLocal threadSession = new ThreadLocal();

    //public static Session getSession()  {
    //    Session s = (Session) threadSession.get();
    //    if (s == null) {
    //        s = getSessionFactory().openSession();
    //        threadSession.set(s);
    //    }
    //    return s;
    //}


    public static void main(String[] args) {

        final ClassLoader app = SessionManager.class.getClassLoader();
        final ClassLoader ext = app.getParent();
        final ClassLoader boot = ext.getParent();
        System.out.println(app);
        System.out.println(ext);
        System.out.println(boot);

        final ClassLoader app1 = String.class.getClassLoader();
        System.out.println(app1);
    }

}
