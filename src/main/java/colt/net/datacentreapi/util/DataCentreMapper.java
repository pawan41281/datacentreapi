package colt.net.datacentreapi.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import colt.net.datacentreapi.dto.DataCentreDto;
import colt.net.datacentreapi.vo.DataCentreVo;

@Component
public class DataCentreMapper {
	
	private final ModelMapper modelMapper; 
	
	public DataCentreMapper(ModelMapper modelMapper) {
		this.modelMapper=modelMapper;
	}

	public DataCentreVo convert(DataCentreDto dataCentreDto) {
		DataCentreVo dataCentreVo = modelMapper.map(dataCentreDto, DataCentreVo.class);
		return dataCentreVo;
	}

	public List<DataCentreVo> convertDtoList(List<DataCentreDto> dataCentreDtoList) {
		List<DataCentreVo> list = new ArrayList<>();
		dataCentreDtoList.parallelStream().forEach(dto -> {
			list.add(convert(dto));
		}); 
		return list;
	}
	
	public DataCentreDto convert(DataCentreVo dataCentreVo) {
		DataCentreDto dataCentreDto = modelMapper.map(dataCentreVo, DataCentreDto.class);
		return dataCentreDto;
	}

	public List<DataCentreDto> convertVoList(List<DataCentreVo> dataCentreVoList) {
		List<DataCentreDto> list = new ArrayList<>();
		dataCentreVoList.parallelStream().forEach(vo -> {
			list.add(convert(vo));
		}); 
		return list;
	}
}
