package com.roily.booknode.javatogod._11thread.threadLocal;

import cn.hutool.db.Session;
import lombok.Data;

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

}
