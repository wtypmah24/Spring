package school.app.mapper;

import org.springframework.jdbc.core.RowMapper;
import school.app.entity.Schoolkid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolKidDaoMapper implements RowMapper<Schoolkid> {
    @Override
    public Schoolkid mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Schoolkid(rs.getLong("id"),
                rs.getString("full_name"),
                rs.getString("school_class"),
                rs.getString("subject_to_scores"));
    }
}
