package com.jgc.mysql;

import com.jgc.bean.Person;
import org.apache.ibatis.io.ExternalResources;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author:jgc
 * @create:2020-04-08 20:44
 */
public class SqlSessionTest {

    private static final Logger log = LoggerFactory.getLogger(SqlSessionTest.class);

    public static void  main(String[] args){

        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionMag().getSqlSession();
            Person person = sqlSession.selectOne("getPersonByID", 1);
            log.info(person.toString());
        } catch (Exception e) {
            log.error("异常", e);
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
