package com.pkh.springtrading.mapper;

import com.pkh.springtrading.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface MemberMapper {

    @Select("select * from members where email = #{email} and password = #{password}")
    Member getMember(@RequestParam("email") String email, @RequestParam("password") String password);
}
