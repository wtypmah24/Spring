package org.example.service;

import jakarta.validation.constraints.NotBlank;
import org.example.dao.stat.StatisticsDao;
import org.example.entity.statistics.ClientAppStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class StatisticsService {
    private final StatisticsDao statisticsDao;

    @Autowired
    public StatisticsService(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }

    public void addUserClientApp(@NotBlank String clientApp) {
        statisticsDao.addStatistics(clientApp);
    }

    public List<ClientAppStatistic> getStatistics() {
        return statisticsDao.getStatistics();
    }
}
