package web.listener;

/**
 * Created by Admin on 2018/3/25.
 */
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session ");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session ");
    }

}