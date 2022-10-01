package pizza.project.service;

import pizza.project.dto.UserInfoDto;
import pizza.project.dto.ValidatorDto;

import java.util.List;

public interface ValidatorService {

    List<ValidatorDto> validatorUser(UserInfoDto userInfoDto);
}
