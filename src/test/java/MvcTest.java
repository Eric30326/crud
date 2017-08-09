import com.github.pagehelper.PageInfo;
import com.huanh.crud.domain.TblEmp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContent.xml", "classpath:spring/dispatcher-servlet.xml"})
public class MvcTest {

    @Resource
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.print("当前需要连续显示的页码：");
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(" " + nums[i]);
            } else {
                System.out.println(" " + nums[i]);
            }
        }
        List<TblEmp> empList = pageInfo.getList();
        for (TblEmp tblEmp : empList) {
            System.out.println("id:" + tblEmp.getEmpId() + ",name:" + tblEmp.getEmpName()
                    + ",gender:" + tblEmp.getGender() + ",email:"
                    + tblEmp.getEmail() + ",deptName:" + tblEmp.getTblDept().getDeptName());
        }
    }
}
