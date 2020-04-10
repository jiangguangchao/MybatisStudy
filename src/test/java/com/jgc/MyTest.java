package com.jgc;

import com.alibaba.druid.pool.DruidDataSource;
import com.jgc.bean.Person;
import com.jgc.mapper.PersonMapper;
import com.jgc.mysql.SqlSessionMag;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author:jgc
 * @create:2020-04-10 15:00
 */
public class MyTest {

    public static final Logger log = LoggerFactory.getLogger(MyTest.class);

    @Test
    public void query() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionMag().getSqlSession();
            Class personMapperClass= Class.forName("com.jgc.mapper.PersonMapper");
            PersonMapper personMapper = (PersonMapper) sqlSession.getMapper(personMapperClass);
            Person person = personMapper.getPersonByID(2);
            log.info(person.toString());
        }catch (Exception e) {
            log.error("异常信息", e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    @Test
    public void save() {
        SqlSession sqlSession = null;
        try {
            sqlSession = new SqlSessionMag().getSqlSession();
            Class personMapperClass= Class.forName("com.jgc.mapper.PersonMapper");
            PersonMapper personMapper = (PersonMapper) sqlSession.getMapper(personMapperClass);
            Person p = new Person();
            p.setLastName("小龙女");
            p.setAddr("古墓");
            p.setGender(1);
            boolean saveFlag = personMapper.savePerson(p);
            sqlSession.commit();
            log.info(String.valueOf(saveFlag));
            log.info(p.toString());
        }catch (Exception e) {
            log.error("异常信息", e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void springTest()  {
        try {
            ApplicationContext app = new ClassPathXmlApplicationContext("springcontext.xml");
            SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) app.getBean("sqlSessionFactory");
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Class personMapperClass= Class.forName("com.jgc.mapper.PersonMapper");
            PersonMapper personMapper = (PersonMapper) sqlSession.getMapper(personMapperClass);
            Person person = personMapper.getPersonByID(1);
            log.info(person.toString());
        }catch (Exception e){
            log.error("异常信息", e);
        }

    }
}
