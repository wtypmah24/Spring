package school.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import school.app.entity.Schoolkid;
import school.app.mapper.SchoolKidDaoMapper;

import java.util.List;
import java.util.Objects;

@Component
public class SchoolDaoImpl implements SchoolDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SchoolDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Schoolkid add(Schoolkid schoolkid) {
        Objects.requireNonNull(schoolkid, "You have to provide valid schoolkid data!");
        jdbcTemplate.update("INSERT INTO schoolkids (fullname, school_class, subject_to_scores) values (?, ?, ?);",
        schoolkid.fullName(), schoolkid.schoolClass(), schoolkid.subjectToScores());
        return readAll().stream().filter(s -> s.fullName().equals(schoolkid.fullName())).findFirst().orElseThrow();
    }

    @Override
    public List<Schoolkid> read(String fullName, String schoolClass) {
        return jdbcTemplate.query("SELECT * FROM schoolkids WHERE school_class=? and full_name=?;",
                new SchoolKidDaoMapper(),
                schoolClass,
                fullName);
    }

    @Override
    public List<Schoolkid> readAll() {
        return jdbcTemplate.query("SELECT * FROM schoolkids;", new SchoolKidDaoMapper());

    }

    @Override
    public List<Schoolkid> readByClass(String schoolClass) {
        return jdbcTemplate.query("SELECT * FROM schoolkids WHERE school_class=?;",
                new SchoolKidDaoMapper(),
                schoolClass);
    }
}