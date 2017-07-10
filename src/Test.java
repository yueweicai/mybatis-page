import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orilore.entitys.Product;
import com.orilore.mapper.ProductMapper;

public class Test {
	public static void main(String[] args) throws IOException {
		Reader r = Resources.getResourceAsReader("Configuration.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(r);
		SqlSession session = factory.openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);
		PageHelper.startPage(2, 10);
		List<Product> list = mapper.select();
		Product p = list.get(0);
		System.out.println(p.getName());
		System.out.println(((Page)list).getPages());
		System.out.println(((Page)list).getTotal());
		System.out.println(((Page)list).getPageSize());
		System.out.println(((Page)list).getStartRow());
		System.out.println(((Page)list).getEndRow());
	}
}
