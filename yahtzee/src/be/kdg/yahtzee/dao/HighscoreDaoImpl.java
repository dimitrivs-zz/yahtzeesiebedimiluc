/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.game.Highscore;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class HighscoreDaoImpl extends HibernateDaoSupport implements HighscoreDao {
    //private HibernateTemplate hibernateTemplate;

    public HighscoreDaoImpl() {
        //this.hibernateTemplate = getHibernateTemplate();
    }

    public Highscore getHighscore(int highscoreId) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return (Highscore) hibernateTemplate.get(Highscore.class, highscoreId);
    }

    public void saveHighscore(Highscore highscore) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.saveOrUpdate(highscore);
    }

    public void deleteHighscore(Highscore highscore) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.delete(highscore);
    }

    public List<Highscore> getHighscores() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from Highscore");
    }

    public List<Highscore> getSortedHighscores() {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        return hibernateTemplate.find("from Highscore order by score desc");
    }


    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return super.createHibernateTemplate(sessionFactory);
    }
}
