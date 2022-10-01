package pizza.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pizza.project.dto.ResponseDto;
import pizza.project.dto.UserInfoDto;
import pizza.project.dto.ValidatorDto;
import pizza.project.entity.User;
import pizza.project.mapper.UserMapper;
import pizza.project.repository.UserRepository;
import pizza.project.service.ValidatorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ValidatorService validatorService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findFirstByUsername(username);

        Optional<UserInfoDto> userInfoDto = user.map(userMapper::toDto);

        return userInfoDto.orElse(null);
    }


    public ResponseDto<String> addUser(UserInfoDto userInfoDto){

        List<ValidatorDto> errors = validatorService.validatorUser(userInfoDto);

        if (!errors.isEmpty()){
            return ResponseDto.<String>builder()
                    .data("Successfully failed!")
                    .message("Validator error!")
                    .error(errors)
                    .code(-1)
                    .success(false)
                    .build();
        }

        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));

        userRepository.save(userMapper.toEntity(userInfoDto));

        return ResponseDto.<String>builder()
                .data("Successfully saved")
                .message("OK")
                .error(null)
                .code(0)
                .success(true)
                .build();
    }


}
