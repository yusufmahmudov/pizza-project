package pizza.project.mapper;

import org.mapstruct.Mapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pizza.project.dto.UserInfoDto;
import pizza.project.entity.Authorities;
import pizza.project.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserInfoDto userInfoDto);

    default SimpleGrantedAuthority convert(Authorities auth){
        return new SimpleGrantedAuthority(auth.getName());
    }

    UserInfoDto toDto(User user);
}
