package colt.net.datacentreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import colt.net.datacentreapi.dao.DataCentreDao;
import colt.net.datacentreapi.dto.DataCentreDto;
import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.util.DataCentreModelMapper;
import colt.net.datacentreapi.vo.DataCentreVo;

@Service
public class DataCentreServiceImpl implements DataCentreService {

	private final DataCentreDao dataCentreDao;
	private final DataCentreModelMapper dataCentreModelMapper;

	public DataCentreServiceImpl(DataCentreDao dataCentreDao, DataCentreModelMapper dataCentreModelMapper) {
		this.dataCentreDao = dataCentreDao;
		this.dataCentreModelMapper = dataCentreModelMapper;
	}

	@Override
	public List<DataCentreVo> list() {
		return dataCentreModelMapper.convertDtoList(dataCentreDao.findAll());
	}

	@Override
	public DataCentreVo find(Integer id) throws ResourceNotFoundException {
		Optional<DataCentreDto> dataCentreDto = dataCentreDao.findById(id);
		if (dataCentreDto.isEmpty())
			throw new ResourceNotFoundException("Record not found with Id " + id);

		DataCentreVo dataCentreVo = dataCentreModelMapper.convert(dataCentreDto.get());
		return dataCentreVo;
	}

	@Override
	public DataCentreVo save(DataCentreVo dataCentreVo) throws ResourceAlreadyExistsException {
		DataCentreDto dataCentreDto = dataCentreModelMapper.convert(dataCentreVo);
		dataCentreDto = dataCentreDao.save(dataCentreDto);
		dataCentreVo = dataCentreModelMapper.convert(dataCentreDto);
		return dataCentreVo;
	}

	@Override
	public DataCentreVo update(DataCentreVo dataCentreVo) throws ResourceNotFoundException {
		DataCentreDto dataCentreDto = dataCentreModelMapper.convert(dataCentreVo);
		dataCentreDto = dataCentreDao.save(dataCentreDto);
		dataCentreVo = dataCentreModelMapper.convert(dataCentreDto);
		return dataCentreVo;
	}

	@Override
	public DataCentreVo delete(Integer id) throws ResourceNotFoundException {
		DataCentreVo dataCentreVo =  find(id);
		dataCentreDao.deleteById(id);
		return dataCentreVo;
	}

}
