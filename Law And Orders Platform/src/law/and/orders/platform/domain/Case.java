package law.and.orders.platform.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cases")
public class Case {

	@Id
    @Column(name="id")
	@SequenceGenerator(name = "pk_sequence", sequenceName = "entity_sequence",allocationSize=1, initialValue=100)
	@GeneratedValue(strategy = GenerationType.AUTO, generator="pk_sequence")
	private int id;

	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="categoryA")
	private String categoryA;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="customerno", nullable=false)
	private Customer customer;
	
	@Column(name="courtDate")
	private Date courtDate;
	
	@Column(name="categoryB")
	private String categoryB;
	
	@Column(name="description")
	private String description;
	
	@Column(name="courtType")
	private String courtType;
	
	@Column(name="insertionDate", nullable=false)
	private Date insertionDate;
	
	@Column(name="issueDate")
	private Date issueDate;
	
	@Column(name="filingDate")
	private Date filingDate;
	
	@Column(name="postponements")
	private int postponements;

	@Column(name="creator", nullable=false)
	private String creator;
	
	@Column(name="status")
	private String status;

	public Case(){
		
	}
	
	public Case(String title, String category, Customer cust, Date date, String categoryb, String court, Date idate, String creator, Date issueDate, Date fillDate, String descr, int post, String status){
		
		this.title = title;
		this.categoryA = category;
		this.setCustomer(cust);
		this.courtDate = date;
		this.categoryB = categoryb;
		this.courtType = court;
		this.insertionDate = idate;
		this.creator = creator;
		this.issueDate = issueDate;
		this.filingDate = fillDate;
		this.description = descr;
		this.postponements = post;
		this.status = status;
	}
	
	public static Case newCaseInstance(Case c) {
	    Case temp = new Case(c.getTitle(), c.getCategoryA(), c.getCustomer(),
	    c.getCourtDate(), c.getCategoryB(),c.getCourtType(),c.getInsertionDate(),
	    c.getCreator(),c.getIssueDate(),c.getFilingDate(), c.getDescription(), 
	    c.getPostponements(),c.getStatus());
	    temp.setId(c.getId());
	    return temp;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategoryA() {
		return categoryA;
	}

	public void setCategoryA(String categoryA) {
		this.categoryA = categoryA;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		if(this.customer != null){
			this.customer.friendCases().remove(this);
		}
		this.customer = customer;
		if(this.customer != null){
			this.customer.friendCases().add(this);
		}
	}

	public Date getCourtDate() {
		return courtDate;
	}

	public void setCourtDate(Date courtDate) {
		this.courtDate = courtDate;
	}

	public String getCategoryB() {
		return categoryB;
	}

	public void setCategoryB(String categoryB) {
		this.categoryB = categoryB;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourtType() {
		return courtType;
	}

	public void setCourtType(String courtType) {
		this.courtType = courtType;
	}
	
	
	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getFilingDate() {
		return filingDate;
	}

	public void setFilingDate(Date filingDate) {
		this.filingDate = filingDate;
	}

	public int getPostponements() {
		return postponements;
	}

	public void setPostponements(int postponements) {
		this.postponements = postponements;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
