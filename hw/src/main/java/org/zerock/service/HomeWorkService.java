package org.zerock.service;

import java.util.List;

import org.zerock.domain.HomeWorkVO;


public interface HomeWorkService {
	public List<HomeWorkVO> getList();
	public HomeWorkVO get(Long id);
	public void register(HomeWorkVO home);
	public boolean modify(HomeWorkVO home);
	public boolean remove(Long id);
}
