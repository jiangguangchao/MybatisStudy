package com.jgc;

import com.jgc.bean.Person;
import com.jgc.mapper.PersonMapper;
import com.jgc.mysql.SqlSessionMag;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
            p.setLastName("乔峰");
            p.setAddr("蒙古");
            p.setGender(0);
            boolean saveFlag = personMapper.savePerson(p);
            log.info(String.valueOf(saveFlag));
        }catch (Exception e) {
            log.error("异常信息", e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
