package org.example.dao.stat;

import org.example.entity.statistics.ClientAppStatistic;

import java.util.List;

public interface StatisticsDao {
    List<ClientAppStatistic> getStatistics();
    void addStatistics(String agent);
}
