import com.huanh.crud.dao.TblDeptMapper;
import com.huanh.crud.dao.TblEmpMapper;
import com.huanh.crud.domain.TblDept;
import com.huanh.crud.domain.TblEmp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContent.xml"})
public class MapperTest {

    @Resource
    private TblDeptMapper tblDeptMapper;

    @Resource
    private SqlSession sqlSession;

    @Test
    public void testCrud(){
        TblEmpMapper tblEmpMapper = sqlSession.getMapper(TblEmpMapper.class);
        for (int i = 0; i < 1000; i++) {
            TblEmp tblEmp = new TblEmp();
            String uuid = UUID.randomUUID().toString().substring(0,5);
            tblEmp.setEmpName(uuid);
            tblEmp.setEmail(uuid + "@qq.com");
            tblEmp.setGender("M");
            tblEmp.setDeptId(1);
            tblEmpMapper.insertSelective(tblEmp);
        }
    }
}
