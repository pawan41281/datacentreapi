package colt.net.datacentreapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "site_info", schema = "mydb")
public class DataCentreDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "site_name", length = 100, nullable = false)
	private String label;
	
	@Column(name = "zone", length = 100, nullable = false)
	private String zone;
	
	@Column(name = "country", length = 100, nullable = false)
	private String country;
	
	@Column(name = "city", length = 100, nullable = false)
	private String city;
	
	@Column(name = "address", length = 100, nullable = true)
	private String address;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name = "visible", nullable = false)
	private boolean visible;


}
