/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.filters;

import be.kdg.yahtzee.beans.UserBean;
import be.kdg.yahtzee.remoteObjects.YahtzeeControllerServiceLocator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter class for protecting hidden pages.
 * If no userBean is detected, the visitor is redirected to the login page.
 * Admins are redirected to the admin page.
 */
public class PlayerFilter implements Filter {
    private ServletContext application;

    /**
     * Initiates the filter class.
     *
     * @param filterConfig filterConfig object
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        application = filterConfig.getServletContext();
    }

    /**
     * Main filter method.
     * Userbean is requested, if none found user is redirected to login.
     * If user is admin, user is redirected to admin page.
     *
     * @param servletRequest  servletRequest object.
     * @param servletResponse servletResponse object.
     * @param filterChain     filterChain object.
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {        //To change body of implemented methods use File | Settings | File Templates.
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("userBean") != null) {
            UserBean userBean = (UserBean) session.getAttribute("userBean");

            YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
            be.kdg.yahtzee.remoteObjects.YahtzeeController yahtzeeController = null;
            try {
                yahtzeeController = serviceLocator.getyahtzee();
            } catch (javax.xml.rpc.ServiceException e) {

            }

            if (yahtzeeController.isAdministrator(userBean.getUsername())) {
                ((HttpServletResponse) servletResponse).sendRedirect("/admin/administrator.jsp");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/");
        }
    }

    /**
     * Method to destroy filter.
     */
    public void destroy() {
    }
}

