package spring.biz.category.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.biz.category.dao.CategoryDAO;
import spring.biz.category.vo.CategoryVO;

@Service("categoryservice")
public class CategoryServiceImpl implements CategoryService{

	@Resource(name = "categorymybatis")
	CategoryDAO dao;

	@Override
	public List<CategoryVO> getCategoryList() {
		// TODO Auto-generated method stub
		return dao.getCategoryList();
	}

}
