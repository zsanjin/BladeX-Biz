import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springblade.core.test.BladeBootTest;
import org.springblade.core.test.BladeSpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Blade单元测试
 *
 * @author Chill
 */
@RunWith(BladeSpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@BladeBootTest(appName = "blade-demo", profile = "test", enableLoader = true)
public class BladeDemoTest {

	@Test
	public void contextLoads() {
		System.out.println("测试～～～～～～");
	}

}
