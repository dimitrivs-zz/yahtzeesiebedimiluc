package be.kdg.yahtzee.dao;


import be.kdg.yahtzee.model.game.Highscore;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public interface HighscoreDao {
    public Highscore getHighscore(int highscoreId);

    public void saveHighscore(Highscore highscore);

    public void deleteHighscore(Highscore highscore);

    public List getHighscores();

    public List<Highscore> getSortedHighscores();

    public HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory);
}
