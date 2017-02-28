package com.projectapi.teardowall.entity;

import java.io.Serializable;

public class LocationTmp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5134541367387120699L;
	private String address;
	private String status;
	private Content content;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public class Content implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -6664227017389679770L;
		private String address;
		private AddressDetail address_detail;
		private Point point;
		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public AddressDetail getAddress_detail() {
			return address_detail;
		}

		public void setAddress_detail(AddressDetail address_detail) {
			this.address_detail = address_detail;
		}

		public Point getPoint() {
			return point;
		}

		public void setPoint(Point point) {
			this.point = point;
		}

		public class AddressDetail implements Serializable{
			/**
			 * 
			 */
			private static final long serialVersionUID = -3211873356370123171L;
			private String city;
			private String city_code;
			private String district;
			private String province;
			private String street;
			private String street_number;
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getCity_code() {
				return city_code;
			}
			public void setCity_code(String city_code) {
				this.city_code = city_code;
			}
			public String getDistrict() {
				return district;
			}
			public void setDistrict(String district) {
				this.district = district;
			}
			public String getProvince() {
				return province;
			}
			public void setProvince(String province) {
				this.province = province;
			}
			public String getStreet() {
				return street;
			}
			public void setStreet(String street) {
				this.street = street;
			}
			public String getStreet_number() {
				return street_number;
			}
			public void setStreet_number(String street_number) {
				this.street_number = street_number;
			}
		}
		
		public class Point implements Serializable{
			/**
			 * 
			 */
			private static final long serialVersionUID = 4739687588086093908L;
			private String x;
			public String getX() {
				return x;
			}
			public void setX(String x) {
				this.x = x;
			}
			public String getY() {
				return y;
			}
			public void setY(String y) {
				this.y = y;
			}
			private String y;
		}
	}
	
	@Override
	public String toString(){
		return address;
	}
}
