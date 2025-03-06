package colt.net.datacentreapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import colt.net.datacentreapi.dto.DataCentreDto;
import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.vo.DataCentreVo;

@Repository
public interface DataCentreDao extends JpaRepository<DataCentreDto, Integer>{

//	public List<DataCentreVo> list();
//	public DataCentreVo find(Integer id) throws ResourceNotFoundException;
//	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException;
//	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException;
//	public DataCentreVo delete(Integer id) throws ResourceNotFoundException;
}
