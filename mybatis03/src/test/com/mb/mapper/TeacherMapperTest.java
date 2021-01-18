package com.mb.mapper;

import com.mb.entiry.Blog;
import com.mb.entiry.Teacher;
import com.mb.mapper.TeacherMapper;
import com.mb.util.DBUtils;
import com.mb.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/11/28
 */
public class TeacherMapperTest {

    static Logger logger = Logger.getLogger(TeacherMapperTest.class);

    @Test
    public void queryTeacherById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.queryTeacherById(1);
            logger.info(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void insertBlog() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog(DBUtils.getRandoId(), "php", "teahcer3", new Date(), 888);
            int res = mapper.insertBlog(blog);
            logger.info("insertBlog===========>"+res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void queryBlogIf() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            //map.put("title", "java");
            map.put("author", "%2%");
            List<Blog> blogs = mapper.queryBlogIf(map);
            blogs.stream().forEach((blog) -> {
                logger.info(blog);
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
    public void queryBlogDymic() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            //map.put("title", "java");
            //map.put("author", "%2%");
            ArrayList<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            map.put("ids", ids);
            List<Blog> blogs = mapper.queryBlogDymic(map);
            blogs.stream().forEach((blog) -> {
                logger.info(blog);
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
