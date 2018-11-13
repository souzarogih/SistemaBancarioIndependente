package client;

public class DomEquipment {
	
	private int equipment_id;
	private String serial_number;
	private String mac_address;
	private String ip_address;
	private String host_name;
	private boolean status;
	
	//CONSTRUTORES
	public DomEquipment(int equipment_id, String serial_number, String mac_address, String ip_address, String host_name,
			boolean status) {
		this.equipment_id = equipment_id;
		this.serial_number = serial_number;
		this.mac_address = mac_address;
		this.ip_address = ip_address;
		this.host_name = host_name;
		this.status = status;
	}

	public DomEquipment(String serial_number) {
		this.serial_number = serial_number;
	}
	
	public DomEquipment() {
	}

	//MÉTODOS GETs AND SETs
	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getMac_address() {
		return mac_address;
	}

	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	
	//OUTROS MÉTODOS
	
	//Gravar serial_number
	
	
	

}
