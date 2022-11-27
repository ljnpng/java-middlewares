package org.example.mongodb.mapper;

import org.example.mongodb.model.Feedback;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DbObjectMapper {

    DbObjectMapper dbObjectMapper = Mappers.getMapper(DbObjectMapper.class);


    //    @Mapping(target = "id", source = "id")
//    @Mapping(target = "reporter", source = "reporter")
//    @Mapping(target = "clueId", source = "clueId")
//    @Mapping(target = "appended", source = "appended")
//    Feedback toEntity(Map<String, Object> map);

    //    @Mapping(source = "", target = "", defaultExpression = "java(new TimeAndFormat( s.getTime(), s.getFormat() ))")
//    HashMap<String, Object> toMap(Feedback feedback);

//    default String str(Object value) {
//        return (String) value;
//    }

//    default boolean bool(Object value) {
//        return (boolean) value;
//    }

//    default Map<String, Object> map(Object value) {
//        return (Map<String, Object>) value;
//    }


}
