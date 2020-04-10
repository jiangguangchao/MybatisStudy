package com.jgc.mysql;

import com.jgc.bean.Person;
import com.jgc.mapper.PersonMapper;
import org.apache.ibatis.io.ExternalResources;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author:jgc
 * @create:2020-04-08 20:44
 */
public class SqlSessionTest {

    private static final Logger log = LoggerFactory.getLogger(SqlSessionTest.class);

    public static void main(String[] args) {
        new SqlSessionTest().springTest();

    }

    public void testSelectOne() {

        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionMag().getSqlSession();
            Person person = sqlSession.selectOne("getPersonByID", 1);
            log.info(person.toString());
        } catch (Exception e) {
            log.error("异常", e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    public void springTest() {
        try {
            ApplicationContext app = new ClassPathXmlApplicationContext("springcontext.xml");
            SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) app.getBean("sqlSessionTemplate");
            Class personMapperClass = Class.forName("com.jgc.mapper.PersonMapper");
            PersonMapper personMapper = (PersonMapper) sqlSessionTemplate.getMapper(personMapperClass);
            Person person = personMapper.getPersonByID(2);
            log.info(person.toString());
        } catch (Exception e) {
            log.error("异常信息", e);
        }
    }

}
