package com.gabekim.api.common;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

@Component
public class TokenGenerator {
//
//    @Autowired
//    JwtTokenProvider jwtTokenProvider;
//
//    @Autowired
//    LoginDao loginDao;

    public HashMap<String,Cookie> getUserToken(AuthVO authVO) throws IOException, SQLException {
//
//        LoginVO auth = new LoginVO();
//
//        auth.setUserId(authVO.getId());
//        auth.setUserPasswd(authVO.getPw());
//        LoginVO adminInfo = loginDao.selectUserAccount(auth);
//
//
//        Account account = Account.builder()
//                .userNo(adminInfo.getUserNo())
//                .userId(adminInfo.getUserId())
//                .userName(adminInfo.getUserName())
//                .userRole(adminInfo.getUserRole())
//                .userEmail(adminInfo.getUserEmail())
//                .userIp("127.0.0.1")
//                .loginType(Account.LoginType.ID_AND_PASSWORD)
//                .build();
//
//        TokenDTO tokenDto = jwtTokenProvider.generateTokenDto(account);
//        int now = (int) (new Date()).getTime();
//
//        Cookie accessToken =  CookieUtils.createCookie(JwtTokenProvider.ACCESS_TOKEN_NAME
//                , tokenDto.getAccessToken()
//                , "/"
//                , now + JwtTokenProvider.accessTokenValidTime);
//
//        Cookie refreshToken  = CookieUtils.createCookie(JwtTokenProvider.REFRESH_TOKEN_NAME
//                , tokenDto.getRefreshToken()
//                , "/"
//                , now + JwtTokenProvider.refreshTokenValidTime);


        HashMap<String,Cookie> tokenMap = new HashMap<String,Cookie>();

        tokenMap.put("accessToken",null);
        tokenMap.put("refreshToken",null);

        return tokenMap;

    }

}
