import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.dao.user.ItripUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2019/7/9.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

    @Autowired
    private ItripUserMapper mapper;

    @Test
    public void test1(){

        try {
            ItripUser user = mapper.getItripUserById(12L);
            System.out.println(user.getUserCode());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
