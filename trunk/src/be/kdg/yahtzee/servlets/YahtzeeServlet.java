package be.kdg.yahtzee.servlets;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.beans.OnlineUsersBean;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.beans.factory.BeanFactory;

public class YahtzeeServlet extends HttpServlet {
    private ServletContext servletContext;

    protected YahtzeeController findYahtzeeController() {
        servletContext = getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        BeanFactory beanFactory = (BeanFactory)ctx;
        return   (YahtzeeController) beanFactory.getBean("yahtzeeController");
    }

    protected OnlineUsersBean findOnlineUsersBean() {
        servletContext = getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        BeanFactory beanFactory = (BeanFactory)ctx;
        return (OnlineUsersBean) beanFactory.getBean("onlineUsersBean");
    }

        protected void forward(String url, ServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, url + " not found");
            } catch (IOException e1) {
                throw new Error("cannot forward");
            }
        } catch (IOException e) {
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, url + " not found");
            } catch (IOException e1) {
                throw new Error("cannot forward");
            }
        }
    }
    
}
