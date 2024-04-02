package ru.itmentor.spring.boot_security.demo.configs;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {
    // Spring Security использует объект Authentication, пользователя авторизованной сессии.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin/");
        } else if
            (roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/user/");
        } else {
            httpServletResponse.sendRedirect("/");
        }
    }
}




/*
Метод onAuthenticationSuccess: Этот метод вызывается после успешной аутентификации пользователя. Он принимает три аргумента:
httpServletRequest: Объект HttpServletRequest, представляющий входящий запрос.
httpServletResponse: Объект HttpServletResponse, представляющий исходящий ответ.
authentication: Объект Authentication, представляющий аутентифицированного пользователя и его полномочия.
Извлечение ролей пользователя: Он извлекает набор ролей пользователя из объекта Authentication с помощью метода AuthorityUtils.authorityListToSet.
Проверка роли "ROLE_USER": Он проверяет, содержит ли набор ролей роль "ROLE_USER".
Перенаправление на соответствующую страницу: В зависимости от наличия роли "ROLE_USER" он перенаправляет пользователя на страницу "/user"
или "/", используя метод sendRedirect объекта HttpServletResponse.
 */