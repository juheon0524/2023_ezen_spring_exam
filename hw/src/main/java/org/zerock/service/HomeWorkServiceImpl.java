package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.HomeWorkVO;
import org.zerock.mapper.HomeWorkMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class HomeWorkServiceImpl implements HomeWorkService{
	
	private final HomeWorkMapper homeMapper;
	
	@Override
	public List<HomeWorkVO> getList() {
		log.info("getList.... >> ");
		return homeMapper.getList();
	}

	@Override
	public HomeWorkVO get(Long id) {
		log.info("getList.... >> ");
		return homeMapper.read(id);
	}

	@Override
	public void register(HomeWorkVO home) {
		log.info("register ....... > " + home);
		homeMapper.inserteSelectKey(home);
		
	}

	@Override
	public boolean modify(HomeWorkVO home) {
		log.info("modify.... > " + home);
		return homeMapper.update(home)==1;
	}

	@Override
	public boolean remove(Long id) {
		log.info("remove.... >> " + id);
		return homeMapper.delete(id)==1;
	}

}
