package lno.object.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "calendarEvents")
public class CalcendarEvent implements Serializable {

	private static final long serialVersionUID = -1230862001240471636L;
	private Date start;
	private Date end;

	private String title;
	private String descriprion;

	public CalcendarEvent() {
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriprion() {
		return descriprion;
	}

	public void setDescriprion(String descriprion) {
		this.descriprion = descriprion;
	}

	@Override
	public String toString() {
		return "CalcendarEvent [start=" + start + ", end=" + end + ", title=" + title + ", descriprion=" + descriprion + "]";
	}

}
