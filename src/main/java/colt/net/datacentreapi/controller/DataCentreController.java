package colt.net.datacentreapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import colt.net.datacentreapi.exception.ResourceAlreadyExistsException;
import colt.net.datacentreapi.exception.ResourceNotFoundException;
import colt.net.datacentreapi.service.DataCentreService;
import colt.net.datacentreapi.vo.DataCentreVo;
import colt.net.datacentreapi.wrapper.ApiResponse;
import colt.net.datacentreapi.wrapper.ApiResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/datacentres")
@Tag(description = "Datacentre Management API", name = "Datacentre Management API")
public class DataCentreController {

	private final DataCentreService dataCentreService;

	public DataCentreController(DataCentreService dataCentreService) {
		this.dataCentreService = dataCentreService;
	}

	@GetMapping("")
	@Operation(summary = "Get all datacentres", description = "Fetches all datacentres from database")
	public ResponseEntity<ApiResponse<List<DataCentreVo>>> list() {
		List<DataCentreVo> list = dataCentreService.list();
//		ApiResponse<List<DataCentreVo>> apiResponse = new ApiResponse<>("success", "Record retrieved successfully", list, null);
//		return ResponseEntity.ok(apiResponse);
		return ResponseEntity.ok(
				ApiResponseWrapper.success("Record retrieved successfully", list, Map.of("recordCount", list.size())));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get datacentre by ID", description = "Fetches a datacentre using their ID")
	public ResponseEntity<ApiResponse<DataCentreVo>> find(@PathVariable Integer id) throws ResourceNotFoundException {
		DataCentreVo dataCentreVo = dataCentreService.find(id);
		return ResponseEntity.ok(ApiResponseWrapper.success("Record retrieved successfully", dataCentreVo, null));
	}

	@PostMapping("")
	@Operation(summary = "Save a datacentre", description = "Save a new datacentre in the database")
	public ResponseEntity<ApiResponse<DataCentreVo>> save(@RequestBody DataCentreVo dataCentreVo)
			throws ResourceAlreadyExistsException {
		dataCentreVo = dataCentreService.save(dataCentreVo);
		return ResponseEntity.ok(ApiResponseWrapper.success("Record saved successfully", dataCentreVo, null));
	}

	@PutMapping("")
	@Operation(summary = "Update or replace a datacentre", description = "Update or replace a datacentre in the database")
	public ResponseEntity<ApiResponse<DataCentreVo>> update(@RequestBody DataCentreVo dataCentreVo)
			throws ResourceNotFoundException {
		dataCentreVo = dataCentreService.update(dataCentreVo);
		return ResponseEntity.ok(ApiResponseWrapper.success("Record updated successfully", dataCentreVo, null));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete datacentre by ID", description = "Delete a datacentre using their ID")
	public ResponseEntity<ApiResponse<DataCentreVo>> delete(@PathVariable Integer id) throws ResourceNotFoundException {
		DataCentreVo dataCentreVo = dataCentreService.delete(id);
		return ResponseEntity.ok(ApiResponseWrapper.success("Record deleted successfully", dataCentreVo, null));
	}

}
