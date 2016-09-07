package law.and.orders.platform.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="customers")
public class Customer {

	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="firstName", length=200, nullable=false)
	private String firstName;

	@Column(name="lastName", length=200, nullable=false)
	private String lastName;
	
	@Column(name="code", length=20, nullable=false, unique = true)
	@Pattern(regexp="(^[A-Z]N[0-9]{6,6}$)",message="{invalid.Code}")
	private String code;
	
	@Column(name="email", length=200, nullable=true)
	private String email;
	
	@Column(name="telephone1", nullable=true)
	private String telephone1;
	
	@Column(name="telephone2", nullable=true)
	private String telephone2;
	
	@Column(name="occupation", nullable=true)
	private String occupation;
	
	@Embedded
	private Address address=new Address();
	
	@Column(name="afm", unique = true)
	private String afm;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL, mappedBy="customer", fetch=FetchType.EAGER)
	private Set<Case> cases = new HashSet<Case>();

	public Set<Case> getCases() {
		return new HashSet<Case>(this.cases);
	}
	
	Set<Case> friendCases(){
		return this.cases;
	}
	
	public void setCases(Set<Case> cases) {
		this.cases = cases;
	}
	
	public void addCase(Case c){
		if(c != null){ c.setCustomer(this); }
	}
	
	public void removeCase(Case c){
		if(c != null){ c.setCustomer(null); }
	}

	public Customer(){
		
	}
	
	public Customer(String fname, String lname, String code, String email, String tel1, String tel2, String job, Address address, String afm) {
		this.firstName = fname;
		this.lastName = lname;
		this.code = code;
		this.email = email;
		this.telephone1 = tel1;
		this.telephone2 = tel2;
		this.occupation = job;
		this.address = address;
		this.afm = afm;
	}
	
	public static Customer newCustomerInstance(Customer customer) {
	    Customer temp = new Customer(customer.getFirstName(), customer.getLastName(), customer.getCode(),
	    		customer.getEmail(), customer.getTelephone1(),customer.getTelephone2(),customer.getOccupation(),customer.getAddress(),customer.getAfm());
	    temp.setId(customer.getId());
	    return temp;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String uuid) {
		this.code = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address == null ? null : new Address(address.getAddressStreet(), address.getAddressNumber(), address.getRegion(), address.getAddressZipCode(), address.getCity(), address.getCountry());
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}
}
