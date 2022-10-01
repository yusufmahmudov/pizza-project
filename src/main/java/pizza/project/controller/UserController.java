package pizza.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizza.project.dto.ResponseDto;
import pizza.project.dto.UserInfoDto;
import pizza.project.service.impl.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/add")
    public ResponseDto<String> addUser(@RequestBody UserInfoDto userInfoDto){
        return userService.addUser(userInfoDto);
    }



}
