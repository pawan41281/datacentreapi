package colt.net.datacentreapi.service;

import java.util.List;

import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.vo.DataCentreVo;

public interface DataCentreService {

	public List<DataCentreVo> list();
	public DataCentreVo find(Integer id) throws ResourceNotFoundException;
	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException;
	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException;
	public DataCentreVo delete(Integer id) throws ResourceNotFoundException;
}
