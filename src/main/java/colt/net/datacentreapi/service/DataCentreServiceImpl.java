package colt.net.datacentreapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import colt.net.datacentreapi.dao.DataCentreDao;
import colt.net.datacentreapi.dto.DataCentreDto;
import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.util.DataCentreMapper;
import colt.net.datacentreapi.vo.DataCentreVo;

@Service
public class DataCentreServiceImpl implements DataCentreService {

	private static final Logger logger = LoggerFactory.getLogger(DataCentreServiceImpl.class);
	
	private final DataCentreDao dataCentreDao;
	private final DataCentreMapper dataCentreMapper;

	public DataCentreServiceImpl(DataCentreDao dataCentreDao, DataCentreMapper dataCentreMapper) {
		this.dataCentreDao = dataCentreDao;
		this.dataCentreMapper = dataCentreMapper;
	}

	@Override
	public List<DataCentreVo> list() {
		logger.info("dao layer call start for Get all datacentres");
		List<DataCentreDto> dtoList = dataCentreDao.findAll();
		List<DataCentreVo> voList = dataCentreMapper.convertDtoList(dtoList);
		logger.info("dao layer call done for Get all datacentres");
		return voList;
	}

	@Override
	public DataCentreVo find(Integer id) throws ResourceNotFoundException {
		Optional<DataCentreDto> dataCentreDto = dataCentreDao.findById(id);
		if (dataCentreDto.isEmpty())
			throw new ResourceNotFoundException("Record not found with Id " + id);

		DataCentreVo dataCentreVo = dataCentreMapper.convert(dataCentreDto.get());
		return dataCentreVo;
	}

	@Override
	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException {
		DataCentreDto dataCentreDto = dataCentreMapper.convert(dataCentreVo);
		dataCentreDto = dataCentreDao.save(dataCentreDto);
		dataCentreVo = dataCentreMapper.convert(dataCentreDto);
		return dataCentreVo;
	}

	@Override
	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException {
		DataCentreDto dataCentreDto = dataCentreMapper.convert(dataCentreVo);
		dataCentreDto = dataCentreDao.save(dataCentreDto);
		dataCentreVo = dataCentreMapper.convert(dataCentreDto);
		return dataCentreVo;
	}

	@Override
	public DataCentreVo delete(Integer id) throws ResourceNotFoundException {
		DataCentreVo dataCentreVo =  find(id);
		dataCentreDao.deleteById(id);
		return dataCentreVo;
	}

}
