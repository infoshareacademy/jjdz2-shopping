package com.jars.shopping.Statistics;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by pwieczorek on 27.11.16.
 */
@Stateless
public class StatisticsLogger {

    @PersistenceContext
    EntityManager entityManager;

        public void logNewStatistics(@Observes NewStatisticUpdateEvent event) {
        Statistic stat = new Statistic();

        stat.setUsername(event.getUsername());
        stat.setQuestion(event.getQuestion());
        stat.setAnswer(event.getAnswer());

        entityManager.persist(stat);
    }


}

