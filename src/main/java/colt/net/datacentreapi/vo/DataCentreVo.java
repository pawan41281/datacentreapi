package colt.net.datacentreapi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataCentreVo {
	
	private Integer id;
	private String label;
	private String zone;
	private String country;
	private String city;
	private String address;
	private boolean active;
	private boolean visible;
}
