package colt.net.datacentreapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.vo.DataCentreVo;

@Repository
public class DataCentreDaoImpl implements DataCentreDao {

	private Map<Integer, DataCentreVo> map = new HashMap<>();

	@Override
	public List<DataCentreVo> list() {
		return map.values().stream().collect(Collectors.toList());
	}

	@Override
	public DataCentreVo find(Integer id) throws ResourceNotFoundException {
		if(map.containsKey(id))
			return map.get(id);
		
		throw new ResourceNotFoundException("Record not found for Id " + id);
	}

	@Override
	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException {
		if(map.containsKey(dataCentreVo.getId()))
			throw new ResourceAlreadyExistsException("Record already exists with Id " + dataCentreVo.getId());
		
		return map.put(dataCentreVo.getId(), dataCentreVo);
	}

	@Override
	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException {
		if(map.containsKey(dataCentreVo.getId())) {
			map.put(dataCentreVo.getId(), dataCentreVo);
			return dataCentreVo;
		}
		
		throw new ResourceNotFoundException("Record not found with Id " + dataCentreVo.getId());
	}

	@Override
	public DataCentreVo delete(Integer id) throws ResourceNotFoundException {
		if(map.containsKey(id))
			return map.remove(id);
		
		throw new ResourceNotFoundException("Record not found with Id " + id);
	}

}
