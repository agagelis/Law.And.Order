package law.and.orders.platform.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="addressStreet", length=50, nullable=false)
	private String addressStreet;

	@Column(name="addressNumber", length=10)
	private String addressNumber;
	
	@Column(name="region", length=50)
	private String region;

	@Column(name="addressZipCode", length=10)
	private String addressZipCode;

	@Column(name="city", length=20, nullable=false)
	private String city;
	
	@Column(name="country", length=20, nullable=false)
	private String country;

	public Address(){}
	
	public Address(String addstreet, String addnumber, String region, String zipcode, String city, String country) {
		this.addressStreet = addstreet;
		this.addressNumber = addnumber;
		this.region = region;
		this.addressZipCode = zipcode;
		this.city = city;
		this.country = country;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}
		
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }

        Address theAddress = (Address) other;
        if (!(addressStreet == null ? theAddress.addressStreet 
                == null : addressStreet.equals(theAddress.addressStreet))) {
            return false;
        }
        if (!(addressNumber == null ? theAddress.addressNumber 
                == null : addressNumber.equals(theAddress.addressNumber))) {
            return false;
        }
        if (!(city == null ? theAddress.city 
                == null : city.equals(theAddress.city))) {
            return false;
        }
        if (!(addressZipCode == null ? theAddress.addressZipCode
                == null : addressZipCode.equals(theAddress.addressZipCode))) {
            return false;
        }
        if (!(country == null ? theAddress.country
                == null : country.equals(theAddress.country))) {
            return false;
        }
        return true;
    } 
}

