package com.jgc.mysql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @description:
 * @author:jgc
 * @create:2020-04-10 11:44
 */
public class SqlSessionMag {

    public SqlSession getSqlSession () throws Exception{
        String resource = "mysql/mybatis/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


}
