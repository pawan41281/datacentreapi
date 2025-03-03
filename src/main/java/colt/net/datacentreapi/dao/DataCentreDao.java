package colt.net.datacentreapi.dao;

import java.util.List;

import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.vo.DataCentreVo;

public interface DataCentreDao {

	public List<DataCentreVo> list();
	public DataCentreVo find(Integer id) throws ResourceNotFoundException;
	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException;
	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException;
	public DataCentreVo delete(Integer id) throws ResourceNotFoundException;
}
