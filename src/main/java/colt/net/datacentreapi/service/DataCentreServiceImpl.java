package colt.net.datacentreapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import colt.net.datacentreapi.dao.DataCentreDao;
import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.vo.DataCentreVo;

@Service
public class DataCentreServiceImpl implements DataCentreService {

	private final DataCentreDao centreDao;

	public DataCentreServiceImpl(DataCentreDao centreDao) {
		this.centreDao = centreDao;
	}

	@Override
	public List<DataCentreVo> list() {
		return centreDao.list();
	}

	@Override
	public DataCentreVo find(Integer id) throws ResourceNotFoundException {
		return centreDao.find(id);
	}

	@Override
	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException {
		return centreDao.save(dataCentreVo);
	}

	@Override
	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException {
		return centreDao.update(dataCentreVo);
	}
	
	@Override
	public DataCentreVo delete(Integer id) throws ResourceNotFoundException{
		return centreDao.delete(id);
	}
	
	
}
