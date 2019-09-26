package spring.biz.category.dao;

import java.util.List;

import spring.biz.category.vo.CategoryVO;

public interface CategoryDAO {
	List<CategoryVO> getCategoryList();
}
