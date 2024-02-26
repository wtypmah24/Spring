package org.example.controller;

import org.example.entity.statistics.ClientAppStatistic;
import org.example.exception.ErrorMessage;
import org.example.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NotContextException;
import java.util.List;

@RestController
public class StatisticsController {
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public List<ClientAppStatistic> getUsers() throws NotContextException {
        List<ClientAppStatistic> stat = statisticsService.getStatistics();
        if (stat == null || stat.isEmpty()) throw new NotContextException("There is no statistics yet");
        return stat;
    }

    // Перехват сообщений на уровне котроллера
    @ExceptionHandler(NotContextException.class)
    public ResponseEntity<ErrorMessage> handleException(NotContextException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }
}

