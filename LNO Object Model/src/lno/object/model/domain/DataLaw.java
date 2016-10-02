package lno.object.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datalaw")
public class DataLaw implements Serializable {

	private static final long serialVersionUID = 5258694881616523276L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "code", length = 200, nullable = false)
	private String code;

	@Column(name = "categoryA", length = 200, nullable = false)
	private String categoryA;

	@Column(name = "categoryB", length = 200)
	private String categoryB;

	// @Column(name="title", length=200, nullable=false)
	// private String title;

	@Column(name = "description", length = 200)
	private String description;

	public DataLaw() {

	}

	public DataLaw(String code, String categoryA, String categoryB, String descr) {
		this.code = code;
		this.categoryA = categoryA;
		this.categoryB = categoryB;
		this.description = descr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategoryA() {
		return categoryA;
	}

	public void setCategoryA(String category) {
		this.categoryA = category;
	}

	public String getCategoryB() {
		return categoryB;
	}

	public void setCategoryB(String category) {
		this.categoryB = category;
	}

	// public String getTitle() {
	// return title;
	// }
	//
	// public void setTitle(String title) {
	// this.title = title;
	// }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
