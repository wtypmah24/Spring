package school.app.mapper;

import org.springframework.stereotype.Component;
import school.app.dto.SchoolKidDto;
import school.app.entity.Schoolkid;

@Component
public class SchoolMapper {
    public SchoolKidDto toSchoolKidDto(Schoolkid schoolkid){
        return new SchoolKidDto(schoolkid.id(), schoolkid.fullName(), schoolkid.schoolClass(), schoolkid.subjectToScores());
    }

    public Schoolkid toSchoolKid(SchoolKidDto schoolKidDto){
        return new Schoolkid(schoolKidDto.id(), schoolKidDto.fullName(), schoolKidDto.schoolClass(), schoolKidDto.subjectToScores());
    }

}
