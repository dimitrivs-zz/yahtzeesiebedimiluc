/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.filters;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.model.YahtzeeController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    private ServletContext application;

    public void init(FilterConfig filterConfig) throws ServletException {
        application = filterConfig.getServletContext();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {        //To change body of implemented methods use File | Settings | File Templates.
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("userBean") != null) {
            UserBean userBean = (UserBean) session.getAttribute("userBean");

            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
            BeanFactory beanFactory = (BeanFactory) ctx;
            YahtzeeController yahtzeeController = (YahtzeeController) beanFactory.getBean("yahtzeeController");

            if (yahtzeeController.isAdministrator(userBean.getUsername())) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                if (yahtzeeController.isPlayer(userBean.getUsername())) {
                    ((HttpServletResponse) servletResponse).sendRedirect("/player/gameRoom.jsp");
                } else {
                    ((HttpServletResponse) servletResponse).sendRedirect("/");
                }
            }
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        }
    }

    public void destroy() {
    }
}
