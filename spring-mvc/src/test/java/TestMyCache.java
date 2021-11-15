import com.easy.archiecture.config.CacheConfig;
import com.easy.archiecture.config.DataConfig;
import com.easy.archiecture.config.ServletConfig;
import com.easy.archiecture.config.info.JdbcInfo;
import com.easy.archiecture.dao.UserClazzRefDao;
import com.easy.archiecture.dao.UserDao;
import com.easy.archiecture.entity.User;
import com.easy.archiecture.entity.UserClazzRef;
import com.easy.archiecture.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//spring-test来初始化单元测试用的IOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//用来给spring-test标注，哪些Bean需要注入到IOC容器中
@ContextConfiguration(classes = {DataConfig.class, JdbcInfo.class, CacheConfig.class, ServletConfig.class})
public class TestMyCache {

    @Autowired
    private UserDao userDao;
    //    @Autowired
//    private UserClazzRefDao userClazzRefDao;
//    @Autowired
//    private ApplicationContext applicationContext;

    @Test
    public void testCache() {
//        ApplicationContext applicationContext = this.applicationContexqt;
        User user = userDao.findByName("eee");
        Assert.assertEquals("eee", user.getName());

    }

}
