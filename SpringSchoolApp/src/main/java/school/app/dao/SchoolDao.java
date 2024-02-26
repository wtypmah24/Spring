package school.app.dao;

import school.app.entity.Schoolkid;

import java.util.List;

public interface SchoolDao {
    Schoolkid add(Schoolkid schoolkid);
    List<Schoolkid> read(String fullName, String schoolClass);
    List<Schoolkid> readAll();

    List<Schoolkid> readByClass(String schoolClass);
}
