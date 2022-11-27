package org.example.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import org.example.mybatis.plus.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User good = new User().setId(7L).setAge(1).setName("jj").setEmail("test@gmial.com");
        Assertions.assertEquals(1, userMapper.insert(good));

        Assertions.assertEquals(good, userMapper.selectOne(new QueryWrapper<>(good).lambda().eq(User::getId, good.getId())));
        Assertions.assertEquals(good, userMapper.selectOne(new QueryWrapper<>(good).eq("id", good.getId())));
        Assertions.assertEquals(good, userMapper.selectOne(Wrappers.lambdaQuery(good).eq(User::getId, good.getId())));
        Assertions.assertEquals(good, userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getId, good.getId())));
        Assertions.assertEquals(good, userMapper.selectOne(Wrappers.query(good).eq("id", good.getId())));

        Assertions.assertEquals(good, ChainWrappers.lambdaQueryChain(userMapper).eq(User::getId, good.getId()).one());

        Assertions.assertTrue(ChainWrappers.lambdaUpdateChain(userMapper).eq(User::getId, good.getId()).remove());

    }


}