package org.example.dao.stat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.statistics.ClientAppStatistic;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StatisticsDaoImpl implements StatisticsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ClientAppStatistic> getStatistics() {
        return entityManager.createQuery("SELECT s FROM ClientAppStatistic s", ClientAppStatistic.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void addStatistics(String agent) {
        Optional<ClientAppStatistic> current = getStatistics().stream()
                .filter(s -> s.getClientAppName().equals(agent))
                .findFirst();
        if (current.isEmpty()) entityManager.persist(new ClientAppStatistic(null, agent, 1));
        else {
            ClientAppStatistic stat = current.get();
            stat.setClientAppCount(stat.getClientAppCount() + 1);
            entityManager.merge(stat);
        }
    }
}
