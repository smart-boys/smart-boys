package com.ewo.admin.auth.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ewo.admin.auth.mapper.SbMenuMapper;
import com.ewo.admin.auth.mapper.SbUserOauthMapper;
import com.ewo.admin.auth.model.SbUserOauth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author wangruiheng
 */
@RequiredArgsConstructor
@Service
public class SbUserOauthServiceImpl implements UserDetailsService {

    private final SbUserOauthMapper sbUserOauthMapper;
    private final SbMenuMapper sbMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SbUserOauth sbUsers = sbUserOauthMapper.selectOne(Wrappers.<SbUserOauth>lambdaQuery().eq(SbUserOauth::getUsername, username));
        if(sbUsers==null){
            throw new UsernameNotFoundException("Cannot find username");
        }
        sbUsers.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(sbMenuMapper.getMenuCodeByUserId(sbUsers.getUserId())));
        return sbUsers;
    }
}
