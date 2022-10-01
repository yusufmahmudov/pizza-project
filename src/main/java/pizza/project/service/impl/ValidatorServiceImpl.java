package pizza.project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pizza.project.dto.UserInfoDto;
import pizza.project.dto.ValidatorDto;
import pizza.project.service.ValidatorService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidatorServiceImpl implements ValidatorService {



    @Override
    public List<ValidatorDto> validatorUser(UserInfoDto userInfoDto) {

        List<ValidatorDto> errors = new ArrayList<>();

        if (StringUtils.hasText(userInfoDto.getName())){
            errors.add(new ValidatorDto("name", "Ma'lumot yo'q"));
        }

        if (StringUtils.hasText(userInfoDto.getUsername())){
            errors.add(new ValidatorDto("username", "Ma'lumot yo'q"));
        }
        
        if (StringUtils.hasText(userInfoDto.getPassword())){
            errors.add(new ValidatorDto("password", "Ma'lumot yo'q"));
        } else if (userInfoDto.getPassword().length() < 8) {
            errors.add(new ValidatorDto("password", "8ta belgidan kam!"));
        } else if (userInfoDto.getPassword().length() > 16) {
            errors.add(new ValidatorDto("password", "16ta belgidan ko'p!"));
        }
        
        if (StringUtils.hasText(userInfoDto.getEmail())){
            errors.add(new ValidatorDto("email", "Ma'lumot yo'q"));
        } else if (userInfoDto.getEmail().endsWith("@gmail.com") && userInfoDto.getEmail().length() < 11) {
            errors.add(new ValidatorDto("email", "Email yaroqsiz"));
        }
        
        if (StringUtils.hasText(userInfoDto.getPhoneNumber())){
            errors.add(new ValidatorDto("phone number", "Ma'lumot yo'q"));
        } else if (userInfoDto.getPhoneNumber().startsWith("+998") && userInfoDto.getPhoneNumber().length() != 13) {
            errors.add(new ValidatorDto("phone number", "Telefon raqam yaroqsiz"));
        }

        if (userInfoDto.getAccount() == null){
            errors.add(new ValidatorDto("account", "Ma'lumot yo'q"));
        } else if (userInfoDto.getAccount() < 0){
            errors.add(new ValidatorDto("account", "Manfiy qiymat"));
        }

        return errors;
    }


}
