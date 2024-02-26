package school.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.app.dao.SchoolDao;
import school.app.dto.SchoolKidDto;
import school.app.mapper.SchoolMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolDao schoolDao;
    private final SchoolMapper mapper;

    @Autowired
    public SchoolService(SchoolDao schoolDao, SchoolMapper mapper) {
        this.schoolDao = schoolDao;
        this.mapper = mapper;
    }

    public SchoolKidDto addSchoolkid(SchoolKidDto schoolKidDto){
        return mapper.toSchoolKidDto(schoolDao.add(mapper.toSchoolKid(schoolKidDto)));
    }

    public List<SchoolKidDto> read(String fullName, String schoolClass){
        return schoolDao.read(fullName, schoolClass).stream().map(mapper::toSchoolKidDto).collect(Collectors.toList());
    }

    public List<SchoolKidDto> readAll(){
        return schoolDao.readAll().stream().map(mapper::toSchoolKidDto).collect(Collectors.toList());
    }

    public List<SchoolKidDto> readByClass(String schoolClass){
        return schoolDao.readByClass(schoolClass).stream().map(mapper::toSchoolKidDto).collect(Collectors.toList());
    }
}
