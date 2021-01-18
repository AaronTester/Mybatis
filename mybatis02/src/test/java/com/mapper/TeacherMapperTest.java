package com.mapper;

import com.entry.Student;
import com.entry.Teacher;
import com.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/25
 */
public class TeacherMapperTest {
    static Logger logger = Logger.getLogger(TeacherMapperTest.class);
    @Test
    public void queryTeacherList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teachers = mapper.queryTeacherList();
            teachers.stream().forEach(t->{
                logger.info(t);
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
    }


    @Test
    public void queryStuList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //List<Student> students = mapper.queryStuList2();
            List<Student> students = mapper.queryStuList();
            students.stream().forEach(s->{
                logger.info(s);
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
    }
}
